package cn.javayuli.auth.handler;

import cn.javayuli.common.security.handler.AbstractAuthenticationSuccessEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * 登录成功
 *
 * @author hanguilin
 */
@Component
public class YuLiAuthenticationSuccessEventHandler extends AbstractAuthenticationSuccessEventHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(YuLiAuthenticationSuccessEventHandler.class);

	/**
	 * 处理登录成功方法
	 * <p>
	 * 获取到登录的authentication 对象
	 * @param authentication 登录对象
	 */
	@Override
	public void handle(Authentication authentication) {
		LOGGER.info("用户：{} 登录成功", authentication.getPrincipal());
	}

}
