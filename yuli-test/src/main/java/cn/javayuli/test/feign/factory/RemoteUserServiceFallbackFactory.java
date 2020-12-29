package cn.javayuli.test.feign.factory;

import cn.javayuli.test.feign.RemoteUserService;
import cn.javayuli.test.feign.impl.RemoteUserServiceImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * factory
 *
 * @author hanguilin
 */
@Component
public class RemoteUserServiceFallbackFactory implements FallbackFactory<RemoteUserService> {

    @Override
    public RemoteUserService create(Throwable throwable) {
        RemoteUserServiceImpl remoteUserService = new RemoteUserServiceImpl();
        remoteUserService.setCause(throwable);
        return remoteUserService;
    }
}
