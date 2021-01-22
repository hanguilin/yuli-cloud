package cn.javayuli.cloud.generator;

import cn.javayuli.cloud.common.security.annotation.EnableYuLiResourceServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @description: 代码生成服务
 * @author: HanGuiLin
 * @createDate: 2021/1/17
 * @version: 1.0
 */
@EnableYuLiResourceServer
@SpringCloudApplication
public class YuLiGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuLiGeneratorApplication.class, args);
    }
}
