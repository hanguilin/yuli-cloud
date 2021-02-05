package cn.javayuli.cloud.generator.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.generator.service.TableService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description: 查询表信息
 * @author: hanguilin
 * @createDate: 2021/1/24
 * @version: 1.0
 */
@RestController
@RequestMapping("/table")
public class TableController {

    @Autowired
    private TableService tableService;

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @param dsName 数据源
     * @return
     */
    @PreAuthorize("hasAuthority('generator:table:page')")
    @GetMapping("/page")
    public Rest<Page> doPage(Page page, String dsName){
        return Rest.success(tableService.doPage(page, dsName));
    }

    /**
     * 查找表字段
     *
     * @param tableName 表名
     * @param dsName 数据源
     * @return
     */
    @PreAuthorize("hasAuthority('generator:table:page')")
    @GetMapping("/column")
    public Rest<List<Map<String, Object>>> doColumn(String tableName, String dsName){
        return Rest.success(tableService.doColumn(tableName, dsName));
    }
}
