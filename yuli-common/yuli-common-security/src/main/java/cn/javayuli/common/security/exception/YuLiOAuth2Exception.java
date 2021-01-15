package cn.javayuli.common.security.exception;

import cn.javayuli.common.security.exception.handler.YuLiAuthExceptionSerializer;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author lengleng
 * @date 2019/2/1 自定义OAuth2Exception
 */
@JsonSerialize(using = YuLiAuthExceptionSerializer.class)
public class YuLiOAuth2Exception extends OAuth2Exception {

	private String errorCode;

	public YuLiOAuth2Exception(String msg) {
		super(msg);
	}

	public YuLiOAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
