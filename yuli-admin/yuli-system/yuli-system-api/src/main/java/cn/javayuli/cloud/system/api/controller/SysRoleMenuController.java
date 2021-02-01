package cn.javayuli.cloud.system.api.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.service.SysRoleMenuService;
import cn.javayuli.cloud.system.ref.entity.SysRole;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(description = "角色关联菜单")
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
    @ApiOperation("更新角色与菜单的关联")
    @PutMapping("/update")
    public Rest<Boolean> doUpdate(@RequestBody SysRole sysRole) {
        return sysRoleMenuService.updateRoleMenu(sysRole);
    }
}
