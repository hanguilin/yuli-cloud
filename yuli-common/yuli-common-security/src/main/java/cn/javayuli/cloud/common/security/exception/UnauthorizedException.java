package cn.javayuli.cloud.common.security.exception;

import cn.javayuli.cloud.common.security.exception.handler.YuLiAuthExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 * 未认证异常
 *
 * @author hanguilin
 */
@JsonSerialize(using = YuLiAuthExceptionSerializer.class)
public class UnauthorizedException extends YuLiOAuth2Exception {

	public UnauthorizedException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "unauthorized";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.UNAUTHORIZED.value();
	}

}
