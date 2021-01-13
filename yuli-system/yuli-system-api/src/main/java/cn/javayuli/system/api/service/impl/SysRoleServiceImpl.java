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
                // 根据菜单id查询菜单数据
                List<SysMenu> menuList = sysMenuService.listByIds(menuIdList);
                // 根据父节点进行分组
                Map<String, List<SysMenu>> groupingBy = menuList.stream().map(o -> {
                    if (o.getParentId() == null) {
                        o.setParentId("NULL");
                    }
                    return o;
                }).collect(Collectors.groupingBy(SysMenu::getParentId));
                // 筛选出没有子节点的节点
                String menuIds = menuList
                        .stream().filter(o -> {
                            List<SysMenu> temp = groupingBy.get(o.getId());
                            return CollUtil.isEmpty(temp);
                        })
                        .map(SysMenu::getId)
                        .collect(Collectors.joining(","));
                role.setMenuIds(menuIds);
            }
        }
        return Rest.success(role);
    }
}
