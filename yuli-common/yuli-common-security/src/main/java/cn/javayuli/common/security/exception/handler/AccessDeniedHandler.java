package cn.javayuli.common.security.exception.handler;

import cn.hutool.http.HttpStatus;
import cn.javayuli.common.core.constant.ErrorCode;
import cn.javayuli.common.core.entity.Rest;
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
	 * 授权拒绝处理
	 * @param request request
	 * @param response response
	 * @param authException authException
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) throws IOException {
		LOGGER.info("无权限，禁止访问 {}", request.getRequestURI());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		Rest<String> result = Rest.fail("无权限，禁止访问", ErrorCode.ACCESS_DENIED);
		response.setStatus(HttpStatus.HTTP_UNAUTHORIZED);
		PrintWriter printWriter = response.getWriter();
		printWriter.append(objectMapper.writeValueAsString(result));
	}

}
