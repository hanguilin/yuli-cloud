package cn.javayuli.test.feign;

import cn.javayuli.security.entity.YuLiUser;
import cn.javayuli.test.feign.factory.RemoteUserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 远程调用库存服务
 *
 * @author hanguilin
 */
@FeignClient(contextId = "remoteUserService", value = "yuli-auth",
        fallbackFactory = RemoteUserServiceFallbackFactory.class)
public interface RemoteUserService {

    /**
     * 获取当前用户
     *
     * @return
     */
    @GetMapping("/user/test")
    String doTest();
}
