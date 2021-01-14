package cn.javayuli.system.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.api.mapper.SysUserMapper;
import cn.javayuli.system.api.service.SysMenuService;
import cn.javayuli.system.api.service.SysRoleService;
import cn.javayuli.system.api.service.SysUserRoleService;
import cn.javayuli.system.api.service.SysUserService;
import cn.javayuli.system.ref.entity.SysMenu;
import cn.javayuli.system.ref.entity.SysRole;
import cn.javayuli.system.ref.entity.SysUser;
import cn.javayuli.system.ref.entity.SysUserRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User业务实现类
 *
 * @author hanguilin
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 新建用户
     *
     * @param sysUser 用户
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> saveUser(SysUser sysUser) {
        // 密码加密
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        // 机构
        if (sysUser.getOffice() != null) {
            sysUser.setOfficeId(sysUser.getOffice().getId());
        }
        boolean res = save(sysUser);
        if (!res) {
            return Rest.fail("保存失败");
        }
        // 保存用户角色关联关系
        saveUserRole(sysUser);
        return Rest.success();
    }

    /**
     * 删除用户数据
     *
     * @param ids 主键id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> deleteUser(String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        if (CollUtil.isNotEmpty(idList)) {
            removeByIds(idList);
            // 删除用户角色关联关系
            sysUserRoleService.remove(Wrappers.lambdaQuery(SysUserRole.class).in(SysUserRole::getUserId, idList));
        }
        return Rest.success();
    }

    @Override
    public Rest<SysUser> info(String id) {
        // 不返回password
        LambdaQueryWrapper<SysUser> queryWrapper = Wrappers
                .lambdaQuery(SysUser.class)
                .eq(SysUser::getId, id)
                .select(SysUser.class, o -> !"password".equals(o.getColumn()));
        SysUser sysUser = getOne(queryWrapper);
        if (sysUser != null) {
            List<SysUserRole> list = sysUserRoleService.list(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getUserId, id));
            sysUser.setRoleIdList(list.stream().map(SysUserRole::getRoleId).collect(Collectors.toList()));
        }
        return Rest.success(sysUser);
    }

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @param sysUser 过滤对象
     * @return
     */
    @Override
    public Page<SysUser> findPage(Page page, SysUser sysUser) {
        List<SysUser> list = sysUserMapper.findList(page, sysUser);
        page.setRecords(list);
        return page;
    }

    /**
     * 分页查询角色下的用户
     *
     * @param page 分页对象
     * @param sysUser 过滤对象
     * @param roleId 角色id
     * @return
     */
    @Override
    public Page<SysUser> findUserOfRole(Page page, SysUser sysUser, String roleId) {
        List<SysUser> userOfRole = sysUserMapper.findUserOfRole(page, sysUser, roleId);
        page.setRecords(userOfRole);
        return page;
    }

    /**
     * 更新数据
     * @param sysUser 用户数据
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> updateUser(SysUser sysUser) {
        // 机构
        if (sysUser.getOffice() != null) {
            sysUser.setOfficeId(sysUser.getOffice().getId());
        }
        updateById(sysUser);
        // 删除用户角色关联表旧数据
        sysUserRoleService.remove(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getUserId, sysUser.getId()));
        // 保存用户角色关联关系
        saveUserRole(sysUser);
        return Rest.success();
    }

    /**
     * 获取用户权限
     *
     * @param username 登录名
     * @return
     */
    @Override
    public Rest<SysUser> getUserPermission(String username) {
        // 获取用户信息
        SysUser sysUser = getOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getUsername, username));
        if (sysUser == null) {
            return Rest.fail("用户不存在");
        }
        // 获取用户角色
        List<SysRole> sysRoles = sysRoleService.getUserRole(sysUser.getId());
        sysUser.setRoleList(sysRoles);
        if (CollUtil.isNotEmpty(sysRoles)) {
            List<String> roleIdList = sysRoles.stream().map(SysRole::getId).collect(Collectors.toList());
            // 获取角色菜单
            List<SysMenu> menuList = sysMenuService.getRoleMenu(roleIdList, null);
            sysUser.setMenuList(menuList);
        }
        return Rest.success(sysUser);
    }

    /**
     * 获取用户菜单树
     *
     * @param username 登录名
     * @return
     */
    @Override
    public List<SysMenu> getUserMenu(String username) {
        // 获取用户角色
        List<SysRole> sysRoles = sysRoleService.getUserRole(username);
        if (CollUtil.isNotEmpty(sysRoles)) {
            List<String> roleIdList = sysRoles.stream().map(SysRole::getId).collect(Collectors.toList());
            // 获取角色菜单(目录和菜单类型)
            List<SysMenu> menuList = sysMenuService.getRoleMenu(roleIdList, Lists.newArrayList("0", "1"));
            return sysMenuService.setDeepTreeMenuChildren(menuList, null);
        }
        return CollUtil.empty(null);
    }

    /**
     * 保存用户角色关联关系
     *
     * @param sysUser 用户
     */
    private void saveUserRole(SysUser sysUser) {
        List<String> roleIdList = sysUser.getRoleIdList();
        if (CollUtil.isNotEmpty(roleIdList)) {
            String userId = sysUser.getId();
            List<SysUserRole> sysUserRoleList = roleIdList.stream().map(o -> {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setUserId(userId);
                sysUserRole.setRoleId(o);
                return  sysUserRole;
            }).collect(Collectors.toList());
            sysUserRoleService.saveBatch(sysUserRoleList);
        }
    }
}
