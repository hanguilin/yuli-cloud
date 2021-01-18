package cn.javayuli.cloud.generator.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.generator.entity.GeneratorDefinition;
import cn.javayuli.cloud.generator.service.GeneratorDefinitionService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 生成属性定义
 * @author: ${author}
 * @createDate: ${now}
 * @version: ${projectVersion}
 */
@RestController
@RequestMapping("/generatorDefinition")
public class GeneratorDefinitionController {

    @Autowired
    private GeneratorDefinitionService generatorDefinitionService;

    /**
     * 详情数据
     *
     * @param id 主键id
     * @return
     */
    @GetMapping("/info/{id}")
    public Rest<GeneratorDefinition> doInfo(@PathVariable("id") String id) {
        GeneratorDefinition generatorDefinition = generatorDefinitionService.getById(id);
        return generatorDefinition != null ? Rest.success(generatorDefinition) : Rest.fail("无数据");
    }

    /**
     * 保存数据
     *
     * @param generatorDefinition 生成属性定义
     * @return
     */
    @PostMapping("/save")
    public Rest<GeneratorDefinition> doSave(@RequestBody GeneratorDefinition generatorDefinition) {
        return generatorDefinitionService.save(generatorDefinition) ? Rest.success(generatorDefinition) : Rest.fail("保存失败");
    }

    /**
     * 更新数据
     *
     * @param generatorDefinition 生成属性定义
     * @return
     */
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody GeneratorDefinition generatorDefinition) {
        return generatorDefinitionService.updateById(generatorDefinition) ? Rest.success() : Rest.fail("更新失败");
    }

    /**
     * 删除数据
     *
     * @param ids 主键id
     * @return
     */
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete(@RequestParam String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        generatorDefinitionService.removeByIds(idList);
        return Rest.success();
    }

    /**
     * 分页数据
     *
     * @param page 分页对象
     * @param generatorDefinition 生成属性定义
     * @return
     */
    @GetMapping("/page")
    public Rest<Page<GeneratorDefinition>> doPage(Page page, GeneratorDefinition generatorDefinition) {
        return Rest.success(generatorDefinitionService.page(page, Wrappers.query(generatorDefinition)));
    }
}