package cn.javayuli.common.security.exception;

import cn.javayuli.common.security.config.YuLiAuthExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author lengleng
 * @date 2019/2/1
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
