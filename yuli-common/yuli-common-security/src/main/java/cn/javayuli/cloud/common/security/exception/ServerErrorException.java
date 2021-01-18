package cn.javayuli.cloud.common.security.exception;

import cn.javayuli.cloud.common.security.exception.handler.YuLiAuthExceptionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.http.HttpStatus;

/**
 * 服务端异常
 *
 * @author hanguilin
 */
@JsonSerialize(using = YuLiAuthExceptionSerializer.class)
public class ServerErrorException extends YuLiOAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
