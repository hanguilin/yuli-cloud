package cn.javayuli.system.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.api.mapper.SysMenuMapper;
import cn.javayuli.system.api.service.SysMenuService;
import cn.javayuli.system.api.service.SysRoleMenuService;
import cn.javayuli.system.api.service.SysUserRoleService;
import cn.javayuli.system.ref.entity.SysMenu;
import cn.javayuli.system.ref.entity.SysRoleMenu;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Splitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 菜单实现类
 *
 * @author hanguilin
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 查询列表菜单树
     *
     * @param topId 上级id
     * @param excludeId 排除的id
     * @param type menu类型
     * @return
     */
    @Override
    public List<SysMenu> findMenuTree(String topId, String excludeId, String type) {
        List<SysMenu> list = list(Wrappers.lambdaQuery(SysMenu.class)
                .ne(StrUtil.isNotBlank(excludeId), SysMenu::getId, excludeId)
                .eq(StrUtil.isNotBlank(type), SysMenu::getType, type)
                .orderByAsc(SysMenu::getSort));
        return setDeepTreeMenuChildren(list, topId);
    }

    /**
     * 更新数据
     * @param sysMenu 菜单数据
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> updateMenu(SysMenu sysMenu) {
        SysMenu parent = sysMenu.getParent();
        if (parent != null) {
            sysMenu.setParentId(parent.getId());
        }
        boolean res = updateById(sysMenu);
        if (!res) {
            return Rest.fail("更新失败");
        }
        String visible = sysMenu.getVisible();
        // 联动更新子菜单得到显示状态
        if (StrUtil.isNotBlank(visible)) {
            List<SysMenu> deepMenuChildren = getDeepMenuChildren(CollUtil.newArrayList(sysMenu.getId()));
            if (CollUtil.isNotEmpty(deepMenuChildren)) {
                // 给子菜单设置与父菜单相同的显示状态
                deepMenuChildren.forEach(o -> o.setVisible(visible));
                saveOrUpdateBatch(deepMenuChildren);
            }
        }
        return Rest.success();
    }

    /**
     * 删除菜单，同时级联删除子菜单
     *
     * @param ids 主键id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Rest<Boolean> deleteMenu(String ids) {
        List<String> idList = Splitter.on(",").splitToList(ids);
        removeByIds(idList);
        // 查找删除id集的子菜单
        List<SysMenu> deepMenuChildren = getDeepMenuChildren(idList);
        if (CollUtil.isNotEmpty(deepMenuChildren)) {
            List<String> delIdList = deepMenuChildren.stream().map(SysMenu::getId).collect(Collectors.toList());
            // 逻辑删除所有相关子菜单
            removeByIds(delIdList);
        }
        return Rest.success();
    }

    /**
     * 保存数据
     *
     * @param sysMenu 菜单数据
     * @return
     */
    @Override
    public Rest<Boolean> saveMenu(SysMenu sysMenu) {
        SysMenu parent = sysMenu.getParent();
        if (parent != null) {
            sysMenu.setParentId(parent.getId());
        }
        return save(sysMenu) ? Rest.success() : Rest.fail("保存失败");
    }

    /**
     * 根据角色id获取菜单
     *
     * @param idList 角色id
     * @param types 指定查询的菜单类型
     * @return
     */
    @Override
    public List<SysMenu> getRoleMenu(List<String> idList, List<String> types) {
        if (CollUtil.isEmpty(idList)) {
            return CollUtil.empty(null);
        }
        // 获取角色菜单列表
        List<SysRoleMenu> sysRoleMenuList = sysRoleMenuService.list(Wrappers.lambdaQuery(SysRoleMenu.class).in(SysRoleMenu::getRoleId, idList));
        if (CollUtil.isEmpty(sysRoleMenuList)) {
            return CollUtil.empty(null);
        }
        List<String> menuIdList = sysRoleMenuList.stream().map(SysRoleMenu::getMenuId).collect(Collectors.toList());
        // 获取菜单列表
        List<SysMenu> menuList = list(Wrappers.lambdaQuery(SysMenu.class).in(SysMenu::getId, menuIdList).in(CollUtil.isNotEmpty(types), SysMenu::getType, types));
        if (CollUtil.isEmpty(menuList)) {
            return CollUtil.empty(null);
        }
        return menuList;
    }

    /**
     * 获取菜单的所有菜单子项
     *
     * @param ids 目标id
     */
    private List<SysMenu> getDeepMenuChildren (List<String> ids) {
        List<SysMenu> source = list();
        List<SysMenu> target = CollUtil.newArrayList();
        ids.forEach(o -> deepMenuChildren(source, target, o));
        return target;
    }

    /**
     * 递归设置菜单的所有菜单子项
     *
     * @param source 源数据
     * @param target 目标数据
     * @param id 目标id
     */
    private void deepMenuChildren (List<SysMenu> source, List<SysMenu> target, String id) {
        if (CollUtil.isNotEmpty(source)) {
            List<SysMenu> children = source.stream().filter(o -> Objects.equals(o.getParentId(), id)).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(children)) {
                target.addAll(children);
                children.forEach(o -> deepMenuChildren(source, target, o.getId()));
            }
        }
    }

    /**
     * 设置递归子菜单
     *
     * @param sysMenus 源数据
     * @param topId 上级id
     * @return
     */
    @Override
    public List<SysMenu> setDeepTreeMenuChildren(List<SysMenu> sysMenus, String topId) {

        // 顶级菜单，从上往下设值
        return sysMenus.stream().filter(o -> {
            // 根据顶级id过滤
            if (StrUtil.isNotBlank(topId)) {
                return Objects.equals(topId, o.getParentId());
            }
            return StrUtil.isBlank(o.getParentId());
        }).map(o -> {
            deepTreeMenuChildren(o, sysMenus);
            return o;
        }).sorted(Comparator.comparing(SysMenu::getSort)).collect(Collectors.toList());
    }

    /**
     * 为当前菜单项设置子菜单
     *
     * @param menus 菜单数据
     */
    private void deepTreeMenuChildren (SysMenu current, List<SysMenu> menus) {
        if (current != null) {
            // 寻找当前节点的子节点
            List<SysMenu> children = menus.stream().filter(o -> current.getId().equals(o.getParentId())).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(children)) {
                // 将子节点依赖于当前节点
                current.setChildren(children);
                // 子节点寻找自己的子节点
                children.forEach(o -> deepTreeMenuChildren(o, menus));
                // 子节点按照sort字段升序排序
                children.sort(Comparator.comparing(SysMenu::getSort));
            }
        }
    }
}
