package cn.javayuli.system.api.controller;

import cn.hutool.core.util.StrUtil;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.api.service.SysDictTypeService;
import cn.javayuli.system.ref.entity.SysDictType;
import cn.javayuli.system.ref.entity.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 字典类型controller
 *
 * @author hanguilin
 */
@RestController
@RequestMapping("/dict/type")
public class SysDictTypeController {

    @Autowired
    private SysDictTypeService sysDictTypeService;

    /**
     * 详情数据
     *
     * @param id 主键id
     * @return
     */
    @GetMapping("/info/{id}")
    public Rest<SysDictType> doInfo(@PathVariable("id") String id) {
        return sysDictTypeService.getInfo(id);
    }

    /**
     * 保存数据
     *
     * @param sysDictType 字典类型
     * @return
     */
    @PostMapping("/save")
    public Rest<Boolean> doSave(@RequestBody SysDictType sysDictType) {
        return sysDictTypeService.save(sysDictType) ? Rest.success() : Rest.fail("保存失败");
    }

    /**
     * 更新数据
     *
     * @param sysDictType 字典类型数据
     * @return
     */
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysDictType sysDictType) {
        return sysDictTypeService.updateById(sysDictType) ? Rest.success() : Rest.fail("更新失败");
    }

    /**
     * 删除数据
     *
     * @param ids 主键id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping("/delete")
    public Rest<Boolean> doDelete (@RequestParam String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        sysDictTypeService.removeByIds(idList);
        return Rest.success();
    }

    /**
     * 删除数据
     *
     * @param page 分页对象
     * @param sysDictType 角色过滤
     * @return
     */
    @GetMapping("/page")
    public Rest<Page<SysRole>> doPage (Page page, SysDictType sysDictType) {
        LambdaQueryWrapper<SysDictType> lambdaQueryWrapper = Wrappers.lambdaQuery(SysDictType.class)
                .likeRight(StrUtil.isNotBlank(sysDictType.getType()), SysDictType::getType, sysDictType.getType())
                .likeRight(StrUtil.isNotBlank(sysDictType.getRemark()), SysDictType::getRemark, sysDictType.getRemark());
        return Rest.success(sysDictTypeService.page(page, lambdaQueryWrapper));
    }
}
