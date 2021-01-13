package cn.javayuli.common.security.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.javayuli.common.core.constant.SecurityConstant;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.common.core.entity.YuLiUser;
import cn.javayuli.system.ref.entity.SysUser;
import cn.javayuli.system.ref.entity.UserRoleMenuView;
import cn.javayuli.system.ref.feign.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;

/**
 * Security User实现类
 *
 * @author hanguilin
 */
@Component
public class SysUserDetailsService implements UserDetailsService {

    @Autowired
    private RemoteUserService remoteUserService;

    /**
     * 获取用户权限信息
     *
     * @param username 账户
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Rest<SysUser> userRest = remoteUserService.doGetSysUserByName(username, SecurityConstant.SOURCE_IN);
        if (userRest == null || userRest.getData() == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        Rest<List<UserRoleMenuView>> viewRest = remoteUserService.doFindViewList(username, SecurityConstant.SOURCE_IN);
        List<GrantedAuthority> grantedAuthorities;
        if (viewRest == null || CollUtil.isNotEmpty(viewRest.getData())) {
            grantedAuthorities = AuthorityUtils.NO_AUTHORITIES;
        } else {
            List<UserRoleMenuView> list = viewRest.getData();
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
            grantedAuthorities = AuthorityUtils.createAuthorityList(authSet.toArray(authArr));
        }
        SysUser sysUser = userRest.getData();
        return new YuLiUser(sysUser.getId(), sysUser.getUsername(), sysUser.getPassword(), sysUser.getNickname(), grantedAuthorities);
    }
}
