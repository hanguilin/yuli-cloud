package cn.javayuli.system.api.mapper;

import cn.javayuli.system.ref.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户mapper
 *
 * @author hanguilin
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
