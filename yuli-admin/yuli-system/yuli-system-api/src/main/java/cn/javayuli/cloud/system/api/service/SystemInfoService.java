package cn.javayuli.cloud.system.api.service;

import cn.javayuli.cloud.common.core.entity.Rest;
import cn.javayuli.cloud.system.ref.entity.SystemParam;

import java.net.UnknownHostException;

/**
 * @description: SystemInfoService
 * @author: hanguilin
 * @createDate: 2021/1/29
 * @version: 1.0
 */
public interface SystemInfoService {

    /**
     * 获取系统信息
     *
     * @return
     * @throws InterruptedException
     * @throws UnknownHostException
     */
    Rest<SystemParam> getInfo() throws InterruptedException, UnknownHostException;
}
