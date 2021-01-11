package cn.javayuli.system.ref.feign.impl;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.ref.entity.UserRoleMenuView;
import cn.javayuli.system.ref.feign.RemoteUserViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 熔断降级
 *
 * @author hanguilin
 */
@Component
public class RemoteUserViewServiceImpl implements RemoteUserViewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteUserViewServiceImpl.class);

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
    public Rest<List<UserRoleMenuView>> doFindViewList(String username, String source) {
        LOGGER.error(cause.getMessage(), cause);
        return null;
    }
}
