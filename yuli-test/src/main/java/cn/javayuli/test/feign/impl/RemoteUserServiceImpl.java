package cn.javayuli.test.feign.impl;

import cn.javayuli.test.feign.RemoteUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 熔断降级
 *
 * @author hanguilin
 */
@Component
public class RemoteUserServiceImpl implements RemoteUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteUserServiceImpl.class);

    /**
     * 抛出异常
     */
    private Throwable cause;

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    @Override
    public String doTest() {
        LOGGER.error(cause.getMessage(), cause);
        return null;
    }
}
