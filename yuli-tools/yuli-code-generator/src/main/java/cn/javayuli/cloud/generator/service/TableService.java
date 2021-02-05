package cn.javayuli.cloud.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * @description: 表信息
 * @author: hanguilin
 * @createDate: 2021/1/24
 * @version: 1.0
 */
public interface TableService {

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @param dsName 数据源
     * @return
     */
    Page doPage(Page page, String dsName);

    /**
     * 查找表字段
     *
     * @param tableName 表名
     * @param dsName 数据源
     * @return
     */
    List<Map<String, Object>> doColumn(String tableName, String dsName);
}
