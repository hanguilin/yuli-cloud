package cn.javayuli.auth.handler;

import cn.javayuli.common.security.handler.AbstractAuthenticationFailureEvenHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * @author lengleng
 * @date 2019/2/1
 */
@Component
public class YuLiAuthenticationFailureEvenHandler extends AbstractAuthenticationFailureEvenHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(YuLiAuthenticationSuccessEventHandler.class);

	/**
	 * 处理登录失败方法
	 * <p>
	 * @param authenticationException 登录的authentication 对象
	 * @param authentication 登录的authenticationException 对象
	 */
	@Override
	public void handle(AuthenticationException authenticationException, Authentication authentication) {
		LOGGER.info("用户：{} 登录失败，异常：{}", authentication.getPrincipal(), authenticationException.getLocalizedMessage());
	}

}
