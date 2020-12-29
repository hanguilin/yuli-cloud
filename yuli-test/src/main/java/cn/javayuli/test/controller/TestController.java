package cn.javayuli.test.controller;

import cn.javayuli.security.entity.YuLiUser;
import cn.javayuli.security.util.YuLiSecurityUtil;
import cn.javayuli.test.feign.RemoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 测试接口
 *
 * @author hanguilin
 */
@RestController
public class TestController {

    @Autowired
    private RemoteUserService remoteUserService;

    @PreAuthorize("hasAuthority('sys:menu:view')")
    @GetMapping("/test")
    public String doTest() {
        return "hello";
    }

    @PreAuthorize("hasRole('超级管理员')")
    @GetMapping("/test/role")
    public String doTest2() {
        return "role_view";
    }

    @GetMapping("/test/remote")
    public String doTestRemote() {
        return remoteUserService.doTest();
    }

    @GetMapping("/test/current")
    public YuLiUser doCurrent() {
        return YuLiSecurityUtil.getUser();
    }
}
