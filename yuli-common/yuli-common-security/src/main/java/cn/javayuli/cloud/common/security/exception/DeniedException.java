package cn.javayuli.cloud.common.security.exception;

/**
 * 授权拒绝异常
 *
 * @author hanguilin
 */
public class DeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeniedException () {}

	public DeniedException(String message) {
		super(message);
	}

	public DeniedException(Throwable cause) {
		super(cause);
	}

	public DeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
