package cn.javayuli.system.ref.feign.factory;

import cn.javayuli.system.ref.feign.RemoteUserViewService;
import cn.javayuli.system.ref.feign.impl.RemoteUserViewServiceImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * factory
 *
 * @author hanguilin
 */
@Component
public class RemoteUserViewServiceFallbackFactory implements FallbackFactory<RemoteUserViewService> {

    @Override
    public RemoteUserViewService create(Throwable throwable) {
        RemoteUserViewServiceImpl remoteUserViewService = new RemoteUserViewServiceImpl();
        remoteUserViewService.setCause(throwable);
        return remoteUserViewService;
    }
}
