package cn.javayuli.cloud.system.api.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.entity.SysRole;
import cn.javayuli.cloud.system.ref.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 角色菜单关联service
 *
 * @author hanguilin
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {

    /**
     * 更新角色菜单数据
     *
     * @param sysRole 角色
     * @return
     */
    Rest<Boolean> updateRoleMenu(SysRole sysRole);
}
