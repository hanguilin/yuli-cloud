package cn.javayuli.common.security.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.javayuli.common.core.constant.SecurityConstant;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.common.core.entity.YuLiUser;
import cn.javayuli.system.ref.entity.SysMenu;
import cn.javayuli.system.ref.entity.SysRole;
import cn.javayuli.system.ref.entity.SysUser;
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
import java.util.Set;
import java.util.stream.Collectors;

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
        Rest<SysUser> userRest = remoteUserService.doGetUserPermission(username, SecurityConstant.SOURCE_IN);
        SysUser sysUser = userRest.getData();
        if (userRest == null || sysUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 结果集
        HashSet<String> authSet = new HashSet<>();
        // 角色列表
        List<SysRole> roleList = sysUser.getRoleList();
        // 菜单列表
        List<SysMenu> menuList = sysUser.getMenuList();
        if (CollUtil.isNotEmpty(roleList)) {
            Set<String> roleSet = roleList.stream().filter(o -> StrUtil.isNotBlank(o.getEnName())).map(o -> SecurityConstant.ROLE + o.getEnName()).collect(Collectors.toSet());
            authSet.addAll(roleSet);
        }
        if (CollUtil.isNotEmpty(menuList)) {
            Set<String> permissionSet = menuList.stream().filter(o -> StrUtil.isNotBlank(o.getPermission())).map(SysMenu::getPermission).collect(Collectors.toSet());
            authSet.addAll(permissionSet);
        }
        String[] authArr = new String[authSet.size()];
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.createAuthorityList(authSet.toArray(authArr));
        return new YuLiUser(sysUser.getId(), sysUser.getUsername(), sysUser.getPassword(), sysUser.getNickname(), sysUser.getEnabled(),grantedAuthorities);
    }
}
