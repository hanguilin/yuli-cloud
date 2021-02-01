package cn.javayuli.cloud.system.ref.feign;

import cn.javayuli.cloud.common.core.constant.SecurityConstants;
import cn.javayuli.cloud.common.core.constant.ServiceConstants;
import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.entity.SysUser;
import cn.javayuli.cloud.system.ref.feign.factory.RemoteUserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 远程调用系统服务
 *
 * @author hanguilin
 */
@FeignClient(path = "/user", contextId = "remoteUserService", value = ServiceConstants.SYSTEM_API,
        fallbackFactory = RemoteUserServiceFallbackFactory.class)
public interface RemoteUserService {

    /**
     * 获取当前用户
     *
     * @param username 用户登录名
     * @param source 请求来源
     * @return
     */
    @GetMapping("/permission")
    Rest<SysUser> doGetUserPermission(@RequestParam("username") String username, @RequestHeader(SecurityConstants.SOURCE) String source);
}
