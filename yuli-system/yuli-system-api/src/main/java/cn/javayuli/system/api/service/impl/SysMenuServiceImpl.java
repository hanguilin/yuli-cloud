package cn.javayuli.system.api.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.javayuli.common.core.constant.FlagConstant;
import cn.javayuli.system.api.mapper.SysMenuMapper;
import cn.javayuli.system.api.service.SysMenuService;
import cn.javayuli.system.api.service.UserRoleMenuViewService;
import cn.javayuli.system.ref.entity.SysMenu;
import cn.javayuli.system.ref.entity.UserRoleMenuView;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 顶级菜单编号
     */
    private static final String TOP_MENU = "1";

    @Autowired
    private UserRoleMenuViewService userRoleMenuViewService;

    /**
     * 查询菜单树
     *
     * @param currentUser 用户账户,唯一
     * @return
     */
    @Override
    public List<SysMenu> ownMenuTree(String currentUser) {
        List<UserRoleMenuView> userRoleMenuViewList = userRoleMenuViewService.list(Wrappers.lambdaQuery(UserRoleMenuView.class)
                .eq(UserRoleMenuView::getUsername, currentUser)
                .eq(UserRoleMenuView::getMenuVisible, FlagConstant.TRUE)
                .orderByAsc(UserRoleMenuView::getMenuSort));
        List<SysMenu> menuList = userRoleMenuViewList.stream().map(o -> viewToMenu(o)).collect(Collectors.toList());
        return getMenuChildren(menuList, TOP_MENU);
    }

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
        return getMenuChildren(list, topId);
    }

    /**
     * 获取子菜单
     *
     * @param sysMenus 源数据
     * @param topId 上级id
     * @return
     */
    private List<SysMenu> getMenuChildren(List<SysMenu> sysMenus, String topId) {

        // 顶级菜单，从上往下设值
        return sysMenus.stream().filter(o -> Objects.equals(topId, o.getParentId())).map(o -> {
            treeData(o, sysMenus);
            return o;
        }).sorted(Comparator.comparing(SysMenu::getSort)).collect(Collectors.toList());
    }

    /**
     * 为当前菜单项设置子菜单
     *
     * @param menus 菜单数据
     */
    private void treeData (SysMenu current, List<SysMenu> menus) {
        if (current != null) {
            // 寻找当前节点的子节点
            List<SysMenu> children = menus.stream().filter(o -> current.getId().equals(o.getParentId())).collect(Collectors.toList());
            if (CollUtil.isNotEmpty(children)) {
                // 将子节点依赖于当前节点
                current.setChildren(children);
                // 子节点寻找自己的子节点
                children.forEach(o -> treeData(o, menus));
                // 子节点按照sort字段升序排序
                children.sort(Comparator.comparing(SysMenu::getSort));
            }
        }
    }

    /**
     * 视图对象转menu
     *
     * @param view 视图
     * @return
     */
    private SysMenu viewToMenu(UserRoleMenuView view) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(view.getMenuId());
        sysMenu.setTitle(view.getMenuTitle());
        sysMenu.setIcon(view.getMenuIcon());
        sysMenu.setPath(view.getMenuPath());
        sysMenu.setType(view.getMenuType());
        sysMenu.setSort(view.getMenuSort());
        sysMenu.setParentId(view.getMenuParentId());
        return sysMenu;
    }
}
