package cn.javayuli.system.api.controller;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.api.service.SysUserRoleService;
import cn.javayuli.system.api.vo.UserRoleVo;
import cn.javayuli.system.ref.entity.SysUserRole;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户关联角色controller
 *
 * @author hanguilin
 */
@RestController
@RequestMapping("/userRole")
public class SysUserRoleController {

    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 根据用户id和角色id进行移除
     *
     * @param userId 用户id
     * @param roleId 角色id
     * @return
     */
    @DeleteMapping("/remove")
    public Rest<Boolean> doRemove (@RequestParam String userId, @RequestParam String roleId) {
        sysUserRoleService.remove(Wrappers.lambdaQuery(SysUserRole.class).eq(SysUserRole::getUserId, userId).eq(SysUserRole::getRoleId, roleId));
        return Rest.success();
    }

    /**
     * 保存角色数据
     *
     * @param userRoleVo 用户角色保存对象
     * @return
     */
    @PostMapping("/save/role")
    public Rest<Boolean> doSaveRole (@RequestBody UserRoleVo userRoleVo) {
        return sysUserRoleService.saveByRole(userRoleVo);
    }

}
