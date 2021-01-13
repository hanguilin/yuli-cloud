package cn.javayuli.system.ref.feign;

import cn.javayuli.common.core.constant.SecurityConstant;
import cn.javayuli.common.core.constant.ServiceConstant;
import cn.javayuli.common.core.entity.Rest;
import cn.javayuli.system.ref.entity.SysUser;
import cn.javayuli.system.ref.entity.UserRoleMenuView;
import cn.javayuli.system.ref.feign.factory.RemoteUserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * 远程调用系统服务
 *
 * @author hanguilin
 */
@FeignClient(path = "/user", contextId = "remoteUserService", value = ServiceConstant.SYSTEM_API,
        fallbackFactory = RemoteUserServiceFallbackFactory.class)
public interface RemoteUserService {

    /**
     * 获取当前用户
     *
     * @param username 用户登录名
     * @param source 请求来源
     * @return
     */
    @GetMapping("/byName")
    Rest<SysUser> doGetSysUserByName(@RequestParam("username") String username, @RequestHeader(SecurityConstant.SOURCE) String source);

    /**
     * 获取用户视图
     *
     * @param username 用户名
     * @param source 请求来源
     * @return
     */
    @GetMapping("/view/{username}")
    Rest<List<UserRoleMenuView>> doFindViewList(@PathVariable("username") String username, @RequestHeader(SecurityConstant.SOURCE) String source);
}
