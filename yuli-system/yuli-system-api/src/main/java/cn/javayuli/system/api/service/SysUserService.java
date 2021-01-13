package cn.javayuli.system.api.service;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.ref.entity.SysUser;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户Service
 *
 * @author hanguilin
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 新建用户
     *
     * @param sysUser 用户
     * @return
     */
    Rest<Boolean> saveUser(SysUser sysUser);

    /**
     * 删除用户数据
     *
     * @param ids 主键id
     * @return
     */
    Rest<Boolean> deleteUser(String ids);

    /**
     * 详情数据
     *
     * @param id 主键id
     * @return
     */
    Rest<SysUser> info(String id);

    /**
     * 分页查询
     *
     * @param page 分页对象
     * @param sysUser 过滤对象
     * @return
     */
    Page<SysUser> findPage(Page page, SysUser sysUser);

    /**
     * 分页查询角色下的用户
     *
     * @param page 分页对象
     * @param sysUser 过滤对象
     * @return
     */
    Page<SysUser> findUserOfRole(Page page, SysUser sysUser);

    /**
     * 更新数据
     * @param sysUser 用户数据
     * @return
     */
    Rest<Boolean> updateUser(SysUser sysUser);
}
