package cn.javayuli.cloud.generator.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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
}
