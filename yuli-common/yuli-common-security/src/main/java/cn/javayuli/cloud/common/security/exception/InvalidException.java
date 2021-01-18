package cn.javayuli.cloud.common.security.exception;

import cn.javayuli.cloud.common.security.exception.handler.YuLiAuthExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 非法异常
 *
 * @author hanguilin
 */
@JsonSerialize(using = YuLiAuthExceptionSerializer.class)
public class InvalidException extends YuLiOAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
