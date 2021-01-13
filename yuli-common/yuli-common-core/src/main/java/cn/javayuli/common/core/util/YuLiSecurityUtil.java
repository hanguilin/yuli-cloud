package cn.javayuli.common.core.util;

import cn.hutool.core.util.StrUtil;
import cn.javayuli.common.core.constant.SecurityConstant;
import cn.javayuli.common.core.entity.YuLiUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
     * @return 角色集合
     */
    public static List<Integer> getRoles() {
        Authentication authentication = getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<Integer> roleIds = new ArrayList<>();
        authorities.stream().filter(granted -> StrUtil.startWith(granted.getAuthority(), SecurityConstant.ROLE))
                .forEach(granted -> {
                    String id = StrUtil.removePrefix(granted.getAuthority(), SecurityConstant.ROLE);
                    roleIds.add(Integer.parseInt(id));
                });
        return roleIds;
    }
}
