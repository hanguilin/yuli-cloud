package cn.javayuli.cloud.generator.service.impl;

import cn.javayuli.cloud.generator.mapper.DbMapper;
import cn.javayuli.cloud.generator.service.TableService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @description: 表信息
 * @author: hanguilin
 * @createDate: 2021/1/24
 * @version: 1.0
 */
@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private DbMapper dbMapper;

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @param dsName 数据源
     * @return
     */
    @Override
    public Page doPage(Page page, String dsName) {
        List<Map<String, Object>> tableList = dbMapper.pageTable(dsName);
        page.setRecords(tableList);
        return page;
    }

    /**
     * 查找表字段
     *
     * @param tableName 表名
     * @param dsName 数据源
     * @return
     */
    @Override
    public List<Map<String, Object>> doColumn(String tableName, String dsName) {
        return dbMapper.queryColumns(tableName, dsName);
    }
}
