package cn.javayuli.cloud.common.security.aspect;

import cn.hutool.core.util.StrUtil;
import cn.javayuli.cloud.common.core.constant.SecurityConstants;
import cn.javayuli.cloud.common.security.annotation.Inner;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

/**
 * Inner切面，负责区别内部接口
 *
 * @author hanguilin
 */
@Aspect
public class InnerAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(InnerAspect.class);

	@Autowired
	private HttpServletRequest request;

	/**
	 * 环绕事件
	 *
	 * @param point 切入点
	 * @param inner 切入注解
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(inner)")
	public Object around(ProceedingJoinPoint point, Inner inner) throws Throwable {
		String header = request.getHeader(SecurityConstants.SOURCE);
		// 当inner设置为仅内部访问，且头部没有内部访问标识符时抛出错误
		if (inner.value() && !StrUtil.equals(SecurityConstants.SOURCE_IN, header)) {
			LOGGER.warn("访问接口 {} 没有权限", point.getSignature().getName());
			throw new AccessDeniedException("Access is denied");
		}
		return point.proceed();
	}
}
