package cn.javayuli.system.api.service.impl;

import cn.javayuli.system.api.mapper.RoleUserViewMapper;
import cn.javayuli.system.api.service.RoleUserViewService;
import cn.javayuli.system.ref.entity.RoleUserView;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色用户视图实现类
 *
 * @author hanguilin
 */
@Service
public class RoleUserViewServiceImpl extends ServiceImpl<RoleUserViewMapper, RoleUserView> implements RoleUserViewService {
}
