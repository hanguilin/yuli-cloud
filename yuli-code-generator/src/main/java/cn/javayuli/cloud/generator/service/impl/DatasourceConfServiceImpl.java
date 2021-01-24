package cn.javayuli.cloud.generator.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.common.core.util.SpringContextHolder;
import cn.javayuli.cloud.common.datasource.constant.DataSourceConstants;
import cn.javayuli.cloud.generator.entity.DatasourceConf;
import cn.javayuli.cloud.generator.mapper.DatasourceConfMapper;
import cn.javayuli.cloud.generator.service.DatasourceConfService;
import com.baomidou.dynamic.datasource.DynamicRoutingDataSource;
import com.baomidou.dynamic.datasource.creator.DataSourceCreator;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jasypt.encryption.StringEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * @description: 数据源业务接口实现类
 * @author: hanguilin
 * @createDate: 2021年01月23日
 * @version: 1.0
 */
@Service
public class DatasourceConfServiceImpl extends ServiceImpl<DatasourceConfMapper, DatasourceConf> implements DatasourceConfService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatasourceConfServiceImpl.class);

    @Autowired
    private DataSourceCreator dataSourceCreator;

    @Autowired
    private StringEncryptor stringEncryptor;

    /**
     * 保存数据
     *
     * @param datasourceConf 数据源
     * @return
     */
    @Override
    public Rest<DatasourceConf> saveDatasource(DatasourceConf datasourceConf) {
        if (!checkDataSource(datasourceConf)) {
            return Rest.fail("数据源连接失败，保存失败");
        }
        // 添加动态数据源
        addDynamicDataSource(datasourceConf);
        datasourceConf.setPassword(stringEncryptor.encrypt(datasourceConf.getPassword()));
        // 信息保存入库
        save(datasourceConf);
        return Rest.success();
    }

    /**
     * 添加动态数据源
     *
     * @param conf 数据源信息
     */
    @Override
    public void addDynamicDataSource(DatasourceConf conf) {
        DataSourceProperty dataSourceProperty = new DataSourceProperty();
        dataSourceProperty.setPoolName(conf.getName());
        dataSourceProperty.setUrl(conf.getUrl());
        dataSourceProperty.setUsername(conf.getUsername());
        dataSourceProperty.setPassword(conf.getPassword());
        dataSourceProperty.setDriverClassName(DataSourceConstants.DS_DRIVER);
        DataSource dataSource = dataSourceCreator.createDataSource(dataSourceProperty);
        SpringContextHolder.getBean(DynamicRoutingDataSource.class).addDataSource(dataSourceProperty.getPoolName(), dataSource);
    }

    /**
     * 校验数据源配置是否有效
     * @param conf 数据源信息
     * @return 有效/无效
     */
    @Override
    public Boolean checkDataSource(DatasourceConf conf) {
        try {
            DriverManager.getConnection(conf.getUrl(), conf.getUsername(), conf.getPassword());
        }
        catch (SQLException e) {
            LOGGER.error("数据源配置 {} , 获取链接失败", conf.getName(), e);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /**
     * 更新数据
     *
     * @param datasourceConf 数据源
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> updateDatasource(DatasourceConf datasourceConf) {
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringContextHolder.getBean(DynamicRoutingDataSource.class);
        // 根据名称从多数据源中移除
        dynamicRoutingDataSource.removeDataSource(datasourceConf.getName());
        // 添加到多数据源
        addDynamicDataSource(datasourceConf);
        if (StrUtil.isNotBlank(datasourceConf.getPassword())) {
            datasourceConf.setPassword(stringEncryptor.encrypt(datasourceConf.getPassword()));
        }
        // 更新库中的数据
        updateById(datasourceConf);
        return Rest.success();
    }

    /**
     * 删除数据
     *
     * @param idList 主键id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeDataSource(List<String> idList) {
        DynamicRoutingDataSource dynamicRoutingDataSource = SpringContextHolder.getBean(DynamicRoutingDataSource.class);
        List<DatasourceConf> datasourceConfList = listByIds(idList);
        // 根据名称从多数据源中移除
        datasourceConfList.forEach(o -> dynamicRoutingDataSource.removeDataSource(o.getName()));
        // 移除出库
        removeByIds(idList);
    }
}
