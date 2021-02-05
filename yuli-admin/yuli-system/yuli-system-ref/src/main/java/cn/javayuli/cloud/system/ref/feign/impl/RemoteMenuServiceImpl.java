package cn.javayuli.cloud.system.ref.feign.impl;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.feign.RemoteMenuService;
import cn.javayuli.cloud.system.ref.vo.MenuUnitVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 熔断降级
 *
 * @author hanguilin
 */
@Component
public class RemoteMenuServiceImpl implements RemoteMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteMenuServiceImpl.class);

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
    public Rest<Boolean> doSaveMenuUnit(MenuUnitVo menuUnitVo) {
        LOGGER.error("保存菜单失败", cause);
        return null;
    }
}
