package cn.javayuli.test;

import cn.javayuli.common.security.annotation.EnableYuLiResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 测试服务
 *
 * @author hanguilin
 */
@EnableYuLiResourceServer
@EnableFeignClients
@SpringCloudApplication
public class YuLiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuLiTestApplication.class, args);
    }
}
