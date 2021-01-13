package cn.javayuli.system.api.mapper;

import cn.javayuli.system.ref.entity.SysRole;
import cn.javayuli.system.ref.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色mapper
 *
 * @author hanguilin
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> findUserByRole(Page page, @Param("sysRole") SysRole sysRole, @Param("sysUser") SysUser sysUser);
}
