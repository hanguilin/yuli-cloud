package cn.javayuli.cloud.system.api.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 菜单service
 *
 * @author hanguilin
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 查询列表菜单树
     *
     * @param topId 上级id
     * @param excludeId 排除的id
     * @param type menu类型
     * @return
     */
    List<SysMenu> findMenuTree(String topId, String excludeId, String type);

    /**
     * 更新数据
     * @param sysMenu 菜单数据
     * @return
     */
    Rest<Boolean> updateMenu(SysMenu sysMenu);

    /**
     * 删除菜单
     *
     * @param ids 主键id
     * @return
     */
    Rest<Boolean> deleteMenu(String ids);

    /**
     * 保存数据
     *
     * @param sysMenu 菜单数据
     * @return
     */
    Rest<Boolean> saveMenu(SysMenu sysMenu);

    /**
     * 根据角色id获取菜单
     *
     * @param idList 角色id
     * @param types 指定查询的菜单类型
     * @return
     */
    List<SysMenu> getRoleMenu (List<String> idList, List<String> types);

    /**
     * 设置递归子菜单
     *
     * @param sysMenus 源数据
     * @param topId 上级id
     * @return
     */
    List<SysMenu> setDeepTreeMenuChildren(List<SysMenu> sysMenus, String topId);
}
