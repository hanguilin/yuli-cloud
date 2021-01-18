package cn.javayuli.cloud.system;

import cn.javayuli.cloud.common.security.annotation.EnableYuLiFeignClients;
import cn.javayuli.cloud.common.security.annotation.EnableYuLiResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 系统服务
 *
 * @author hanguilin
 */
@EnableYuLiFeignClients
@EnableYuLiResourceServer
@SpringCloudApplication
public class YuLiSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuLiSystemApplication.class, args);
    }
}
