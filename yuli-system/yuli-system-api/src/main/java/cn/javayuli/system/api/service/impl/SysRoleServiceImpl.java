package cn.javayuli.system.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.api.mapper.SysRoleMapper;
import cn.javayuli.system.api.service.*;
import cn.javayuli.system.ref.entity.*;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 角色实现类
 *
 * @author hanguilin
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 获取角色详细信息
     *
     * @param id 主键id
     * @return
     */
    @Override
    public Rest<SysRole> getInfo(String id) {
        SysRole role = getById(id);
        if (role != null) {
            // 通过角色菜单表查询当前角色持有的菜单数据
            List<String> menuIdList = sysRoleMenuService.list(Wrappers.lambdaQuery(SysRoleMenu.class)
                    .eq(SysRoleMenu::getRoleId, id)).stream().map(o -> o.getMenuId()).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(menuIdList)) {
                List<String> noChildrenNode = getSystemNoChildrenNode();
                // 在当前角色持有菜单和所有底层节点中取交集
                noChildrenNode.retainAll(menuIdList);
                role.setMenuIds(String.join(",", noChildrenNode));
            }
        }
        return Rest.success(role);
    }

    /**
     * 查询所有菜单信息，找到底层节点
     * @return
     */
    private List<String> getSystemNoChildrenNode() {
        List<SysMenu> menuList = sysMenuService.list();
        // 根据父节点进行分组
        Map<String, List<SysMenu>> groupingBy = menuList.stream().map(o -> {
            if (o.getParentId() == null) {
                o.setParentId("NULL");
            }
            return o;
        }).collect(Collectors.groupingBy(SysMenu::getParentId));
        // 筛选出没有子节点的节点
        List<String> menuIdList = menuList
                .stream().filter(o -> {
                    List<SysMenu> temp = groupingBy.get(o.getId());
                    return CollUtil.isEmpty(temp);
                })
                .map(SysMenu::getId)
                .collect(Collectors.toList());
        return menuIdList;
    }

    /**
     * 根据用户id获取角色
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public List<SysRole> getUserRole(String userId) {
        // 获取用户角色列表
        List<SysUserRole> sysUserRoleList = sysUserRoleService.list(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getUserId, userId));
        if (CollUtil.isEmpty(sysUserRoleList)) {
            return CollUtil.empty(null);
        }
        List<String> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        if (CollUtil.isEmpty(roleIdList)) {
            return CollUtil.empty(null);
        }
        List<SysRole> sysRoleList = list(Wrappers.lambdaQuery(SysRole.class).in(SysRole::getId, roleIdList));
        return sysRoleList;
    }
}
