package cn.javayuli.cloud.system.ref.feign.factory;

import cn.javayuli.cloud.system.ref.feign.RemoteMenuService;
import cn.javayuli.cloud.system.ref.feign.impl.RemoteMenuServiceImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * factory
 *
 * @author hanguilin
 */
@Component
public class RemoteMenuServiceFallbackFactory implements FallbackFactory<RemoteMenuService> {

    @Override
    public RemoteMenuService create(Throwable throwable) {
        RemoteMenuServiceImpl remoteMenuService = new RemoteMenuServiceImpl();
        remoteMenuService.setCause(throwable);
        return remoteMenuService;
    }
}
