package cn.javayuli.system.api.controller;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.common.core.util.YuLiSecurityUtil;
import cn.javayuli.common.security.annotation.Inner;
import cn.javayuli.system.api.service.SysUserService;
import cn.javayuli.system.ref.entity.SysMenu;
import cn.javayuli.system.ref.entity.SysUser;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 获取用户权限
     *
     * @param username 登录名
     * @return
     */
    @Inner
    @GetMapping("/permission")
    public Rest<SysUser> doGetUserPermission(@RequestParam("username") String username) {
        return sysUserService.getUserPermission(username);
    }

    /**
     * 获取当前用户的权限标识
     *
     * @return
     */
    @GetMapping("/permission/code")
    public Rest<List<String>> doGetUserPermissionCode() {
        return Rest.success(YuLiSecurityUtil.getPermissionCode());
    }

    /**
     * 获取用户菜单树
     *
     * @return
     */
    @GetMapping("/menu/tree")
    public Rest<List<SysMenu>> doUserMenuTree() {
        String userId = YuLiSecurityUtil.getUser().getId();
        return Rest.success(sysUserService.getUserMenu(userId));
    }

    /**
     * 用户名是否存在
     *
     * @param username 用户名
     * @return
     */
    @GetMapping("/exist")
    public Rest<Boolean> doExist(@RequestParam String username) {
        SysUser sysUser = sysUserService.getOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getUsername, username));
        return Rest.success(sysUser != null);
    }

    /**
     * 详情数据
     *
     * @param id 主键id
     * @return
     */
    @GetMapping("/info/{id}")
    public Rest<SysUser> doInfo(@PathVariable("id") String id) {
        return sysUserService.info(id);
    }

    /**
     * 保存数据
     *
     * @param sysUser 用户数据
     * @return
     */
    @PostMapping("/save")
    public Rest<Boolean> doSave(@RequestBody SysUser sysUser) {
        return sysUserService.saveUser(sysUser);
    }

    /**
     * 更新数据
     * @param sysUser 用户数据
     * @return
     */
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysUser sysUser) {
        return sysUserService.updateUser(sysUser);
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
        return sysUserService.deleteUser(ids);
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @param sysUser 过滤对象
     * @return
     */
    @GetMapping("/page")
    public Rest<Page<SysUser>> doPage (Page page, SysUser sysUser) {
        return Rest.success(sysUserService.findPage(page, sysUser));
    }

    /**
     * 分页查询角色下的用户
     *
     * @param page 分页对象
     * @param sysUser 过滤对象
     * @param roleId 角色id
     * @return
     */
    @GetMapping("/ofRole/page")
    public Rest<Page<SysUser>> doOfRolePage (Page page, SysUser sysUser, String roleId) {
        return Rest.success(sysUserService.findUserOfRole(page, sysUser, roleId));
    }
}
