package cn.javayuli.system.api.service;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.ref.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
