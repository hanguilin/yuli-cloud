package cn.javayuli.cloud.system.api.controller;

import cn.javayuli.cloud.common.core.constant.CacheNames;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.service.SysDictValueService;
import cn.javayuli.cloud.system.ref.entity.SysDictValue;
import cn.javayuli.cloud.system.ref.entity.SysRole;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Splitter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典键值controller
 *
 * @author hanguilin
 */
@Api(description = "字典键值")
@RestController
@RequestMapping("/dict/value")
public class SysDictValueController {

    @Autowired
    private SysDictValueService sysDictValueService;

    /**
     * 详情数据
     *
     * @param id 主键id
     * @return
     */
    @ApiOperation("根据id查询字典键值")
    @GetMapping("/info/{id}")
    public Rest<SysDictValue> doInfo(@PathVariable("id") String id) {
        return Rest.success(sysDictValueService.getById(id));
    }

    /**
     * 保存数据
     *
     * @param sysDictValue 字典键值
     * @return
     */
    @ApiOperation("保存字典键值")
    @CacheEvict(value = CacheNames.DICT_DETAILS, allEntries = true)
    @PostMapping("/save")
    public Rest<Boolean> doSave(@RequestBody SysDictValue sysDictValue) {
        return sysDictValueService.save(sysDictValue) ? Rest.success() : Rest.fail("保存失败");
    }

    /**
     * 更新数据
     *
     * @param sysDictValue 字典键值数据
     * @return
     */
    @ApiOperation("更新字典键值")
    @CacheEvict(value = CacheNames.DICT_DETAILS, allEntries = true)
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysDictValue sysDictValue) {
        return sysDictValueService.updateById(sysDictValue) ? Rest.success() : Rest.fail("更新失败");
    }

    /**
     * 删除数据
     *
     * @param ids 主键id
     * @return
     */
    @ApiOperation("删除字典键值")
    @CacheEvict(value = CacheNames.DICT_DETAILS, allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete (@RequestParam String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        sysDictValueService.removeByIds(idList);
        return Rest.success();
    }

    /**
     * 查询分页数据
     *
     * @param page 分页对象
     * @param sysDictValue 角色过滤
     * @return
     */
    @ApiOperation("分页查询字典键值")
    @GetMapping("/page")
    public Rest<Page<SysRole>> doPage (Page page, SysDictValue sysDictValue) {
        return Rest.success(sysDictValueService.page(page, Wrappers.query(sysDictValue).lambda().orderByAsc(SysDictValue::getSort)));
    }
}
