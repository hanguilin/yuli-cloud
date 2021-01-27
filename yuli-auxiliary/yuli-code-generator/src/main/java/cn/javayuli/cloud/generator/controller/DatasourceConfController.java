package cn.javayuli.cloud.generator.controller;

import cn.hutool.core.collection.CollUtil;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.generator.entity.DatasourceConf;
import cn.javayuli.cloud.generator.service.DatasourceConfService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 数据源
 * @author: hanguilin
 * @createDate: 2021年01月23日
 * @version: 1.0
 */
@RestController
@RequestMapping("/genDatasourceConf")
public class DatasourceConfController {

    @Autowired
    private DatasourceConfService datasourceConfService;

    /**
    * 详情数据
    *
    * @param id 主键id
    * @return
    */
    @PreAuthorize("hasAuthority('generator:genDatasourceConf:info')")
    @GetMapping("/info/{id}")
    public Rest<DatasourceConf> doInfo(@PathVariable("id") String id) {
        DatasourceConf datasourceConf = datasourceConfService.getById(id);
        return datasourceConf != null ? Rest.success(datasourceConf) : Rest.fail("无数据");
    }

    /**
     * 保存数据
     *
     * @param datasourceConf 数据源
     * @return
     */
    @PreAuthorize("hasAuthority('generator:genDatasourceConf:save')")
    @PostMapping("/save")
    public Rest<DatasourceConf> doSave(@RequestBody DatasourceConf datasourceConf) {
        return datasourceConfService.saveDatasource(datasourceConf);
    }

    /**
     * 更新数据
     *
     * @param datasourceConf 数据源
     * @return
     */
    @PreAuthorize("hasAuthority('generator:genDatasourceConf:update')")
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody DatasourceConf datasourceConf) {
        return datasourceConfService.updateDatasource(datasourceConf);
    }

    /**
    * 删除数据
    *
    * @param ids 主键id
    * @return
    */
    @PreAuthorize("hasAuthority('generator:genDatasourceConf:delete')")
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete(@RequestParam String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        datasourceConfService.removeDataSource(idList);
        return Rest.success();
    }

    /**
     * 分页数据
     *
     * @param page 分页对象
     * @param datasourceConf 数据源
     * @return
     */
    @PreAuthorize("hasAuthority('generator:genDatasourceConf:page')")
    @GetMapping("/page")
    public Rest<Page<DatasourceConf>> doPage(Page page, DatasourceConf datasourceConf) {
        return Rest.success(datasourceConfService.page(page, Wrappers.query(datasourceConf)));
    }

    /**
     * 查询数据源名称
     *
     * @return
     */
    @PreAuthorize("hasAuthority('generator:genDatasourceConf:page')")
    @GetMapping("/nameList")
    public Rest<List<String>> doNameList(){
        List<DatasourceConf> all = datasourceConfService.list(Wrappers.lambdaQuery(DatasourceConf.class).select(DatasourceConf::getName));
        if(CollUtil.isNotEmpty(all)){
            List<String> nameList = all.stream().map(DatasourceConf::getName).collect(Collectors.toList());
            return Rest.success(nameList);
        }
        return Rest.success(Collections.emptyList());
    }
}