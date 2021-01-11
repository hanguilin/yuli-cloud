package cn.javayuli.system.api.service.impl;

import cn.javayuli.system.api.mapper.SysUserMapper;
import cn.javayuli.system.api.service.SysUserService;
import cn.javayuli.system.ref.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * User业务实现类
 *
 * @author hanguilin
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
