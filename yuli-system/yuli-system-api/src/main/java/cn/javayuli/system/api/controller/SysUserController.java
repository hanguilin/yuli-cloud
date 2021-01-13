package cn.javayuli.system.api.controller;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.common.security.annotation.Inner;
import cn.javayuli.system.api.service.SysUserService;
import cn.javayuli.system.api.service.UserRoleMenuViewService;
import cn.javayuli.system.ref.entity.SysUser;
import cn.javayuli.system.ref.entity.UserRoleMenuView;
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

    @Autowired
    private UserRoleMenuViewService userRoleMenuViewService;

    @Inner
    @GetMapping("/byName")
    public Rest<SysUser> doGetSysUserByName(@RequestParam("username") String username) {
        SysUser sysUser = sysUserService.getOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getUsername, username));
        return Rest.success(sysUser);
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
     * 通过username查询关联的角色菜单信息
     *
     * @param username 登录账户名
     * @return
     */
    @Inner
    @GetMapping("/view/{username}")
    public Rest<List<UserRoleMenuView>> doFindViewList(@PathVariable("username") String username) {
        List<UserRoleMenuView> list = userRoleMenuViewService.list(Wrappers.lambdaQuery(UserRoleMenuView.class).eq(UserRoleMenuView::getUsername, username));
        return Rest.success(list);
    }

    /**
     * 分页查询角色下的用户
     *
     * @param page 分页对象
     * @param sysUser 过滤对象
     * @return
     */
    @GetMapping("/ofRole/page")
    public Rest<Page<SysUser>> doOfRolePage (Page page, SysUser sysUser) {
        return Rest.success(sysUserService.findUserOfRole(page, sysUser));
    }
}
