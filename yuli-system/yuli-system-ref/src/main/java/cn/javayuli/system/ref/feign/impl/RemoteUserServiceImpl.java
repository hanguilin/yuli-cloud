package cn.javayuli.system.ref.feign.impl;

import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.ref.entity.SysUser;
import cn.javayuli.system.ref.feign.RemoteUserService;
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
    public Rest<SysUser> doGetUserPermission(String username, String source) {
        LOGGER.error("通过用户账号获取用户信息失败", cause);
        return null;
    }
}
