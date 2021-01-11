package cn.javayuli.system.ref.feign;

import cn.javayuli.common.core.constant.SecurityConstant;
import cn.javayuli.common.core.constant.ServiceConstant;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.ref.entity.UserRoleMenuView;
import cn.javayuli.system.ref.feign.factory.RemoteUserViewServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


/**
 * 远程调用系统服务
 *
 * @author hanguilin
 */
@FeignClient(contextId = "remoteUserViewService", value = ServiceConstant.SYSTEM,
        fallbackFactory = RemoteUserViewServiceFallbackFactory.class)
public interface RemoteUserViewService {

    /**
     * 获取用户视图
     *
     * @param username 用户名
     * @param source 请求来源
     * @return
     */
    @GetMapping("view/{username}")
    Rest<List<UserRoleMenuView>> doFindViewList(@PathVariable("username") String username, @RequestHeader(SecurityConstant.SOURCE) String source);
}
