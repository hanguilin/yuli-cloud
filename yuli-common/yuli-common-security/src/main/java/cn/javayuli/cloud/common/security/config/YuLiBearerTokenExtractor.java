package cn.javayuli.cloud.common.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;

/**
 * 改造 {@link org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor} 对公开权限的请求不进行校验
 *
 * @author hanguilin
 */
@Component
public class YuLiBearerTokenExtractor extends BearerTokenExtractor {

	private final PathMatcher pathMatcher = new AntPathMatcher();

	@Autowired
	private IgnoreUrlProperties ignoreUrlProperties;

	@Override
	public Authentication extract(HttpServletRequest request) {
		boolean match = ignoreUrlProperties.getUrls().stream()
				.anyMatch(url -> pathMatcher.match(url, request.getRequestURI()));

		return match ? null : super.extract(request);
	}

}
