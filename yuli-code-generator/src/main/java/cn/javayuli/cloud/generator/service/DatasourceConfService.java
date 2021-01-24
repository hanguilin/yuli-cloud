package cn.javayuli.cloud.generator.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.generator.entity.DatasourceConf;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @description: 数据源业务接口
 * @author: hanguilin
 * @createDate: 2021年01月23日
 * @version: 1.0
 */
public interface DatasourceConfService extends IService<DatasourceConf> {

    /**
     * 保存数据
     *
     * @param datasourceConf 数据源
     * @return
     */
    Rest<DatasourceConf> saveDatasource(DatasourceConf datasourceConf);

    /**
     * 添加动态数据源
     *
     * @param conf 数据源信息
     */
    void addDynamicDataSource(DatasourceConf conf);

    /**
     * 校验数据源配置是否有效
     * @param datasourceConf 数据源信息
     * @return 有效/无效
     */
    Boolean checkDataSource(DatasourceConf datasourceConf);

    /**
     * 更新数据
     *
     * @param datasourceConf 数据源
     * @return
     */
    Rest<Boolean> updateDatasource(DatasourceConf datasourceConf);

    /**
     * 删除数据
     *
     * @param idList 主键id
     * @return
     */
    void removeDataSource(List<String> idList);
}
