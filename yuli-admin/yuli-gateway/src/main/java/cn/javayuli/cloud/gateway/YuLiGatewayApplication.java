package cn.javayuli.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 网关服务
 *
 * @author hanguilin
 */
@SpringCloudApplication
public class YuLiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuLiGatewayApplication.class, args);
    }
}
