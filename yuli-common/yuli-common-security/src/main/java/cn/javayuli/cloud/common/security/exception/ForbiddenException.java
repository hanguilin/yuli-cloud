package cn.javayuli.cloud.common.security.exception;

import cn.javayuli.cloud.common.security.exception.handler.YuLiAuthExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 * 请求禁止异常
 *
 * @author hanguilin
 */
@JsonSerialize(using = YuLiAuthExceptionSerializer.class)
public class ForbiddenException extends YuLiOAuth2Exception {

	public ForbiddenException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "access_denied";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.FORBIDDEN.value();
	}

}
