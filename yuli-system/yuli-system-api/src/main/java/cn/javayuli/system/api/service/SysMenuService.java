package cn.javayuli.system.api.service;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.ref.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 菜单service
 *
 * @author hanguilin
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 查询菜单树
     *
     * @param currentUser 用户账户，唯一
     * @return
     */
    List<SysMenu> ownMenuTree(String currentUser);

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
}
