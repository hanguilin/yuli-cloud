package cn.javayuli.common.security.config;

import cn.hutool.http.HttpStatus;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.common.security.exception.DeniedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 封装授权失败信息
 *
 * @author hanguilin
 */
@Component
public class AccessDeniedHandler extends OAuth2AccessDeniedHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccessDeniedHandler.class);

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * 授权拒绝处理，使用R包装
	 * @param request request
	 * @param response response
	 * @param authException authException
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException {
		LOGGER.info("授权失败，禁止访问 {}", request.getRequestURI());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		Rest<DeniedException> result = Rest.fail(new DeniedException("授权失败，禁止访问"));
		response.setStatus(HttpStatus.HTTP_FORBIDDEN);
		PrintWriter printWriter = response.getWriter();
		printWriter.append(objectMapper.writeValueAsString(result));
	}

}
