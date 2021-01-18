package cn.javayuli.cloud.common.security.config;

import cn.javayuli.cloud.common.core.constant.SecurityConstant;
import cn.javayuli.cloud.common.core.entity.YuLiUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 根据checktoken 的结果转化用户信息
 * 解决authentication.getPrincipal()获取用户时仅仅得到用户账户的问题
 *
 * @author hanguilin
 */
public class YuLiUserAuthenticationConverter implements UserAuthenticationConverter {

	private static final String N_A = "N/A";

	/**
	 * 转换用户的认证信息
	 *
	 * @param authentication 认证信息
	 * @return
	 */
	@Override
	public Map<String, ?> convertUserAuthentication(Authentication authentication) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put(SecurityConstant.DETAILS_USERNAME, authentication.getName());
		if (authentication.getAuthorities() != null && !authentication.getAuthorities().isEmpty()) {
			response.put(AUTHORITIES, AuthorityUtils.authorityListToSet(authentication.getAuthorities()));
		}
		return response;
	}

	/**
	 * 提取用户认证信息
	 *
	 * @param map
	 * @return
	 */
	@Override
	public Authentication extractAuthentication(Map<String, ?> map) {
		// 判断map中是否含有特定的值，需要需上方方法的key一致
		if (map.containsKey(SecurityConstant.DETAILS_USERNAME)) {
			// 获取用户权限
			Collection<? extends GrantedAuthority> authorities = getAuthorities(map);

			String id = (String) map.get(SecurityConstant.DETAILS_USER_ID);
			String username = (String) map.get(SecurityConstant.DETAILS_USERNAME);
			String nickname = (String) map.get(SecurityConstant.DETAILS_USERNAME);
			String enabled = (String) map.get(SecurityConstant.DETAILS_ENABLED);
			YuLiUser user = new YuLiUser(id, username, N_A, nickname, enabled, authorities);
			return new UsernamePasswordAuthenticationToken(user, N_A, authorities);
		}
		return null;
	}

	/**
	 * 获取用户权限
	 *
	 * @param map
	 * @return
	 */
	private Collection<? extends GrantedAuthority> getAuthorities(Map<String, ?> map) {
		Object authorities = map.get(AUTHORITIES);
		if (authorities instanceof String) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList((String) authorities);
		}
		if (authorities instanceof Collection) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList(
					StringUtils.collectionToCommaDelimitedString((Collection<?>) authorities));
		}
		return AuthorityUtils.NO_AUTHORITIES;
	}

}
