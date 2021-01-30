package cn.javayuli.cloud.system.api.controller;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.api.service.SystemInfoService;
import cn.javayuli.cloud.system.ref.entity.SystemParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

/**
 * @description: 系统信息
 * @author: hanguilin
 * @createDate: 2021/1/29
 * @version: 1.0
 */
@RestController
@RequestMapping("/info")
public class SystemInfoController {

    @Autowired
    private SystemInfoService systemInfoService;

    /**
     * 获取系统信息
     *
     * @return
     * @throws InterruptedException
     * @throws UnknownHostException
     */
    @GetMapping("/get")
    public Rest<SystemParam> doGet() throws InterruptedException, UnknownHostException {
        return systemInfoService.getInfo();
    }
}
