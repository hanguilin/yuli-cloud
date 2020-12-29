package cn.javayuli.auth.config.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.javayuli.auth.entity.SysUser;
import cn.javayuli.auth.entity.UserRoleMenuView;
import cn.javayuli.auth.service.SysUserService;
import cn.javayuli.auth.service.UserRoleMenuViewService;
import cn.javayuli.core.constant.SecurityConstant;
import cn.javayuli.security.entity.YuLiUser;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Security User实现类
 *
 * @author hanguilin
 */
@Component
public class SysUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private UserRoleMenuViewService userRoleMenuViewService;

    /**
     * 获取用户权限信息
     *
     * @param account 账户
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getOne(Wrappers.lambdaQuery(SysUser.class).eq(SysUser::getAccount, account));
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<UserRoleMenuView> list = userRoleMenuViewService.list(Wrappers.lambdaQuery(UserRoleMenuView.class).eq(UserRoleMenuView::getUserAccount, account));
        HashSet<String> authSet = new HashSet<>();
        if (CollUtil.isNotEmpty(list)) {
            list.forEach(o -> {
                if (StrUtil.isNotBlank(o.getRoleName())) {
                    authSet.add(SecurityConstant.ROLE + o.getRoleName());
                }
                if (StrUtil.isNotBlank(o.getMenuPermission())) {
                    authSet.add(o.getMenuPermission());
                }
            });
        }
        String[] authArr = new String[authSet.size()];
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.createAuthorityList(authSet.toArray(authArr));
        return new YuLiUser(sysUser.getId(), sysUser.getAccount(), sysUser.getPassword(), grantedAuthorities);
    }
}
