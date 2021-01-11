package cn.javayuli.system.api.controller;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.api.service.SysRoleMenuService;
import cn.javayuli.system.ref.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色菜单controller
 *
 * @author hanguilin
 */
@RestController
@RequestMapping("/roleMenu")
public class SysRoleMenuController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 更新菜单数据
     *
     * @param sysRole 角色数据
     * @return
     */
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysRole sysRole) {
        return sysRoleMenuService.updateRoleMenu(sysRole);
    }
}
