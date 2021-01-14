package cn.javayuli.common.core.util;

import cn.hutool.core.util.StrUtil;
import cn.javayuli.common.core.constant.SecurityConstant;
import cn.javayuli.common.core.entity.YuLiUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Security 工具类
 *
 * @author hanguilin
 */
public class YuLiSecurityUtil {

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     */
    public static YuLiUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal instanceof YuLiUser) {
            return (YuLiUser) principal;
        }
        return null;
    }

    /**
     * 获取用户
     */
    public static YuLiUser getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * 获取用户角色信息
     *
     * @return 角色集合
     */
    public static List<String> getRoles() {
        Authentication authentication = getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roleEnNameList = authorities.stream().filter(granted -> StrUtil.startWith(granted.getAuthority(), SecurityConstant.ROLE))
                .map(granted -> StrUtil.removePrefix(granted.getAuthority(), SecurityConstant.ROLE))
                .collect(Collectors.toList());
        return roleEnNameList;
    }

    /**
     * 获取用户权限标识信息
     *
     * @return 角色集合
     */
    public static List<String> getPermissionCode() {
        Authentication authentication = getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> permissionList = authorities.stream().filter(granted -> !StrUtil.startWith(granted.getAuthority(), SecurityConstant.ROLE))
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return permissionList;
    }
}
