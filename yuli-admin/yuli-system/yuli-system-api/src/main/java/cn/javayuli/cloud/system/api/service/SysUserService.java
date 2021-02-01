package cn.javayuli.cloud.system.api.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.entity.SysMenu;
import cn.javayuli.cloud.system.ref.entity.SysUser;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
     * @param roleId 角色id
     * @return
     */
    Page<SysUser> findUserOfRole(Page page, SysUser sysUser, String roleId);

    /**
     * 更新数据
     * @param sysUser 用户数据
     * @return
     */
    Rest<Boolean> updateUser(SysUser sysUser);

    /**
     * 获取用户权限
     *
     * @param username 登录名
     * @return
     */
    Rest<SysUser> getUserPermission(String username);

    /**
     * 获取用户菜单树
     *
     * @param userId 用户id
     * @return
     */
    List<SysMenu> getUserMenu(String userId);

}
