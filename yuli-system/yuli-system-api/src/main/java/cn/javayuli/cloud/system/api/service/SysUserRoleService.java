package cn.javayuli.cloud.system.api.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.vo.UserRoleVo;
import cn.javayuli.cloud.system.ref.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户关联角色service
 *
 * @author hanguilin
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    /**
     * 保存角色数据
     *
     * @param userRoleVo 用户角色保存对象
     * @return
     */
    Rest<Boolean> saveByRole(UserRoleVo userRoleVo);
}
