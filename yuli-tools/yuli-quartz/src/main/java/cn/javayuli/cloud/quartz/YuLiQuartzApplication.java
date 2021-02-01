package cn.javayuli.cloud.quartz;

import cn.javayuli.cloud.common.security.annotation.EnableYuLiResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @description: QuartzApplication
 * @author: hanguilin
 * @createDate: 2021/1/28
 * @version: 1.0
 */
@EnableYuLiResourceServer
@SpringCloudApplication
public class YuLiQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuLiQuartzApplication.class, args);
    }
}
