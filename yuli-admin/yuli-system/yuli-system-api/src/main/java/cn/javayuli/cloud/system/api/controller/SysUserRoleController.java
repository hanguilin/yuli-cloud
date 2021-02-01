package cn.javayuli.cloud.system.api.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.service.SysUserRoleService;
import cn.javayuli.cloud.system.api.vo.UserRoleVo;
import cn.javayuli.cloud.system.ref.entity.SysUserRole;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户关联角色controller
 *
 * @author hanguilin
 */
@Api(description = "用户关联角色")
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
    @ApiOperation("删除用户与角色的关联关系")
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
    @ApiOperation("保存用户与角色的关联关系")
    @PostMapping("/save/role")
    public Rest<Boolean> doSaveRole (@RequestBody UserRoleVo userRoleVo) {
        return sysUserRoleService.saveByRole(userRoleVo);
    }

}
