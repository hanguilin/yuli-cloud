package cn.javayuli.system.api.mapper;

import cn.javayuli.system.ref.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户mapper
 *
 * @author hanguilin
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询列表
     *
     * @param page page对象
     * @param sysUser 过滤对象
     * @return
     */
    List<SysUser> findList(@Param("page") Page page, @Param("sysUser") SysUser sysUser);

    /**
     * 查询角色下的用户
     *
     * @param page page对象
     * @param sysUser 过滤对象
     * @return
     */
    List<SysUser> findUserOfRole(Page page, @Param("sysUser") SysUser sysUser);
}
