package cn.javayuli.cloud.system.api.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.common.core.util.YuLiSecurityUtil;
import cn.javayuli.cloud.common.security.annotation.Inner;
import cn.javayuli.cloud.system.api.service.SysUserService;
import cn.javayuli.cloud.system.ref.entity.SysMenu;
import cn.javayuli.cloud.system.ref.entity.SysUser;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户接口
 *
 * @author hanguilin
 */
@Api(description = "用户")
@RestController
@RequestMapping("/user")
public class SysUserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取用户权限
     *
     * @param username 登录名
     * @return
     */
    @ApiOperation("查询用户权限")
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
    @ApiOperation("查询用户权限码")
    @GetMapping("/permission/code")
    public Rest<List<String>> doGetUserPermissionCode() {
        return Rest.success(YuLiSecurityUtil.getPermissionCode());
    }

    /**
     * 获取用户菜单树
     *
     * @return
     */
    @ApiOperation("获取用户菜单树")
    @SentinelResource(value = "userMenuTree", blockHandler = "blockHandler", fallback = "fallback")
    @GetMapping("/menu/tree")
    public Rest<List<SysMenu>> doUserMenuTree() {
        String userId = YuLiSecurityUtil.getUser().getId();
        return Rest.success(sysUserService.getUserMenu(userId));
    }

    public Rest<List<SysMenu>> blockHandler(BlockException ex) {
        LOGGER.error("blockHandler", ex);
        return Rest.fail("接口限流");
    }

    public Rest<List<SysMenu>> fallback() {
        LOGGER.error("fallbackHandler");
        return Rest.fail("接口降级");
    }

    /**
     * 用户名是否存在
     *
     * @param username 用户名
     * @return
     */
    @ApiOperation("查询用户是否存在")
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
    @ApiOperation("根据id查询用户")
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
    @ApiOperation("保存用户")
    @PostMapping("/save")
    public Rest<Boolean> doSave(@RequestBody SysUser sysUser) {
        return sysUserService.saveUser(sysUser);
    }

    /**
     * 更新数据
     * @param sysUser 用户数据
     * @return
     */
    @ApiOperation("更新用户")
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
    @ApiOperation("删除用户")
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
    @ApiOperation("分页查询用户")
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
    @ApiOperation("根据角色查询用户")
    @GetMapping("/ofRole/page")
    public Rest<Page<SysUser>> doOfRolePage (Page page, SysUser sysUser, String roleId) {
        return Rest.success(sysUserService.findUserOfRole(page, sysUser, roleId));
    }
}
