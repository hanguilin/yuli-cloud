package cn.javayuli.cloud.common.core.exception.handler;

import cn.javayuli.cloud.common.core.constant.ErrorCode;
import cn.javayuli.cloud.common.core.entity.Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Rest接口全局异常处理
 *
 * @author hanguilin
 */
@RestControllerAdvice
public class GlobalRestErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalRestErrorHandler.class);

    /**
     * 捕获AccessDeniedException
     *
     * @param exception AccessDeniedException.class
     * @return Rest
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Rest<String> handleException(AccessDeniedException exception) {
        LOGGER.error(exception.getMessage(), exception);
        return Rest.fail("无权限访问", ErrorCode.ACCESS_DENIED);
    }

    /**
     * 捕获Exception
     *
     * @param exception Exception.class
     * @return Rest
     */
    @ExceptionHandler(Exception.class)
    public Rest<String> handleException(Exception exception) {
        LOGGER.error(exception.getMessage(), exception);
        return Rest.fail(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
