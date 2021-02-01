package cn.javayuli.cloud.auth;

import cn.javayuli.cloud.common.security.annotation.EnableYuLiFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 认证服务
 *
 * @author hanguilin
 */
@EnableYuLiFeignClients
@SpringCloudApplication
public class YuLiAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuLiAuthApplication.class, args);
    }
}
