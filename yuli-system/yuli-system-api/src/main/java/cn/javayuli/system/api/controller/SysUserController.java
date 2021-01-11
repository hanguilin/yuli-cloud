package cn.javayuli.system.api.controller;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.common.security.annotation.Inner;
import cn.javayuli.system.api.service.SysUserService;
import cn.javayuli.system.ref.entity.SysRole;
import cn.javayuli.system.ref.entity.SysUser;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户接口
 *
 * @author hanguilin
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Inner
    @GetMapping("/byName")
    public Rest<SysUser> doGetSysUserByName(@RequestParam("username") String username) {
        SysUser sysUser = sysUserService.getOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getUsername, username));
        return Rest.success(sysUser);
    }

    /**
     * 详情数据
     *
     * @param id 主键id
     * @return
     */
    @GetMapping("/info/{id}")
    public Rest<SysRole> doInfo(@PathVariable("id") String id) {
        return Rest.success(sysUserService.getById(id));
    }

    /**
     * 保存数据
     *
     * @param sysUser 用户数据
     * @return
     */
    @PostMapping("/save")
    public Rest<Boolean> doSave(@RequestBody SysUser sysUser) {
        return sysUserService.save(sysUser) ? Rest.success() : Rest.fail("保存失败");
    }

    /**
     * 更新数据
     * @param sysUser 用户数据
     * @return
     */
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysUser sysUser) {
        return sysUserService.updateById(sysUser) ? Rest.success() : Rest.fail("更新失败");
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
        return sysUserService.removeByIds(idList) ? Rest.success() : Rest.fail("删除失败");
    }

    /**
     * 删除数据
     *
     * @param page 分页对象
     * @param sysUser 过滤对象
     * @return
     */
    @GetMapping("/page")
    public Rest<Page<SysRole>> doPage (Page page, SysUser sysUser) {
        return Rest.success(sysUserService.page(page, Wrappers.query(sysUser)));
    }
}
