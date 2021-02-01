package cn.javayuli.cloud.gateway.configuration;

import cn.javayuli.cloud.gateway.handler.SwaggerResourceHandler;
import cn.javayuli.cloud.gateway.handler.SwaggerSecurityHandler;
import cn.javayuli.cloud.gateway.handler.SwaggerUiHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * @description: RouterFunctionConfiguration
 * @author: hanguilin
 * @createDate: 2021/1/27
 * @version: 1.0
 */
@Configuration
public class RouterFunctionConfiguration {

    @Autowired
    private SwaggerResourceHandler swaggerResourceHandler;

    @Autowired
    private SwaggerSecurityHandler swaggerSecurityHandler;

    @Autowired
    private SwaggerUiHandler swaggerUiHandler;

    /**
     * 添加webflux请求映射
     *
     * @return
     */
    @Bean
    public RouterFunction routerFunction() {
        return RouterFunctions
                .route(RequestPredicates.GET("/swagger-resources").and(RequestPredicates.accept(MediaType.ALL)), swaggerResourceHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui").and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security").and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);
    }
}
