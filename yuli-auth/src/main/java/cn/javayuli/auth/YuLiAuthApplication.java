package cn.javayuli.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 认证服务
 *
 * @author hanguilin
 */
@SpringCloudApplication
public class YuLiAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuLiAuthApplication.class, args);
    }
}
