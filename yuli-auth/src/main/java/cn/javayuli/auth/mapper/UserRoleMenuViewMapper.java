package cn.javayuli.auth.mapper;

import cn.javayuli.auth.entity.SysUser;
import cn.javayuli.auth.entity.UserRoleMenuView;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户mapper
 *
 * @author hanguilin
 */
@Mapper
public interface UserRoleMenuViewMapper extends BaseMapper<UserRoleMenuView> {
}
