package cn.javayuli.auth.service.impl;

import cn.javayuli.auth.entity.SysUser;
import cn.javayuli.auth.mapper.SysUserMapper;
import cn.javayuli.auth.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * User业务实现类
 *
 * @author hanguilin
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService  {
}
