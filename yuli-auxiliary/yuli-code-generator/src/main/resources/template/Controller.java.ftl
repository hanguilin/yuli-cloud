package ${packageName!}.${moduleName!}.${apiPackage!}.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import ${packageName!}.${moduleName!}.${referencePackage!}.entity.${className!};
import ${packageName!}.${moduleName!}.${apiPackage!}.service.${className!}Service;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @description: ${comment!}
 * @author: ${author!}
 * @createDate: ${now!}
 * @version: ${projectVersion!}
 */
@Api(${comment!})
@RestController
@RequestMapping("/${classNameLower!}")
public class ${className!}Controller {

    @Autowired
    private ${className!}Service ${classNameLower!}Service;

    /**
    * 详情数据
    *
    * @param id 主键id
    * @return
    */
    @ApiOperation("根据id查询${comment!}")
    @PreAuthorize("hasAuthority('${moduleName!}:${classNameLower!}:info')")
    @GetMapping("/info/{id}")
    public Rest<${className!}> doInfo(@PathVariable("id") String id) {
        ${className!} ${classNameLower!} = ${classNameLower!}Service.getById(id);
        return ${classNameLower!} != null ? Rest.success(${classNameLower!}) : Rest.fail("无数据");
    }

    /**
     * 保存数据
     *
     * @param ${classNameLower!} ${comment!}
     * @return
     */
    @ApiOperation("保存${comment!}")
    @PreAuthorize("hasAuthority('${moduleName!}:${classNameLower!}:save')")
    @PostMapping("/save")
    public Rest<${className!}> doSave(@RequestBody ${className!} ${classNameLower!}) {
        return ${classNameLower!}Service.save(${classNameLower!}) ? Rest.success("保存${comment!}成功", ${classNameLower!}) : Rest.fail("保存${comment!}失败");
    }

    /**
     * 更新数据
     *
     * @param ${classNameLower!} ${comment!}
     * @return
     */
    @ApiOperation("更新${comment!}")
    @PreAuthorize("hasAuthority('${moduleName!}:${classNameLower!}:update')")
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody ${className!} ${classNameLower!}) {
        return ${classNameLower!}Service.updateById(${classNameLower!}) ? Rest.success("更新${comment!}成功") : Rest.fail("更新${comment!}失败");
    }

    /**
    * 删除数据
    *
    * @param ids 主键id
    * @return
    */
    @ApiOperation("删除${comment!}")
    @PreAuthorize("hasAuthority('${moduleName!}:${classNameLower!}:delete')")
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete(@RequestParam String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        ${classNameLower!}Service.removeByIds(idList);
        return Rest.success("删除${comment!}成功");
    }

    /**
     * 分页数据
     *
     * @param page 分页对象
     * @param ${classNameLower!} ${comment!}
     * @return
     */
    @ApiOperation("分页查询${comment!}")
    @PreAuthorize("hasAuthority('${moduleName!}:${classNameLower!}:page')")
    @GetMapping("/page")
    public Rest<Page<${className!}>> doPage(Page page, ${className!} ${classNameLower!}) {
        return Rest.success(${classNameLower!}Service.page(page, Wrappers.query(${classNameLower!})));
    }
}