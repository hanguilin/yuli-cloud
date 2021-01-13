package cn.javayuli.system.api.mapper;

import cn.javayuli.system.ref.entity.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户关联角色
 *
 * @author hanguilin
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
}
