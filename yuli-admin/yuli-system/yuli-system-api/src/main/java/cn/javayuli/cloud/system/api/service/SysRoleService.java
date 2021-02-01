package cn.javayuli.cloud.system.api.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 角色service
 *
 * @author hanguilin
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 获取角色详细信息
     *
     * @param id 主键id
     * @return
     */
    Rest<SysRole> getInfo(String id);

    /**
     * 根据用户id获取角色
     *
     * @param userId 用户id
     * @return
     */
    List<SysRole> getUserRole(String userId);
}
