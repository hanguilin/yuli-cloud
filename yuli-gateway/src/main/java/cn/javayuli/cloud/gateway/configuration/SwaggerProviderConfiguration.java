package cn.javayuli.cloud.gateway.configuration;

import cn.hutool.core.collection.CollUtil;
import cn.javayuli.cloud.common.core.constant.ServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.List;
import java.util.function.Predicate;

/**
 * @description: swagger资源提供配置
 * @author: hanguilin
 * @createDate: 2021/1/27
 * @version: 1.0
 */
@Primary
@Configuration
public class SwaggerProviderConfiguration implements SwaggerResourcesProvider {

    @Autowired
    private RouteLocator routeLocator;

    @Autowired
    private GatewayProperties gatewayProperties;

    /**
     * SpringCloudGateWay predicates中Path字段
     */
    private static final String PATH = "Path";

    /**
     * Swagger版本
     */
    private static final String VERSION = "2.0";

    /**
     * Swagger资源地址
     */
    private static final String API_URI = "/v2/api-docs";

    /**
     * 从配置的网关路径获取资源路径
     *
     * @return
     */
    @Override
    public List<SwaggerResource> get() {
        List<String> routeList = CollUtil.newArrayList();
        List<SwaggerResource> resources = CollUtil.newArrayList();
        routeLocator.getRoutes().subscribe(route -> routeList.add(route.getId()));
        // 排除认证服务
        Predicate<RouteDefinition> authPredicate = routeDefinition -> !ServiceConstants.AUTH.equalsIgnoreCase(routeDefinition.getId());
        Predicate<RouteDefinition> idPredicate = routeDefinition -> routeList.contains(routeDefinition.getId());
        // 排除非Path的predicates
        Predicate<PredicateDefinition> pathPredicate = predicateDefinition -> PATH.equalsIgnoreCase(predicateDefinition.getName());
        gatewayProperties.getRoutes().stream().filter(authPredicate.and(idPredicate)).forEach(routeDefinition -> {
            // 遍历Predicates生成swagger资源并添加到集合
            routeDefinition.getPredicates().stream()
                    .filter(pathPredicate)
                    .forEach(predicateDefinition -> resources.add(swaggerResource(routeDefinition.getId(), predicateDefinition.getArgs().get(NameUtils.GENERATED_NAME_PREFIX + "0").replace("/**", API_URI)))
            );
        });
        return resources;
    }

    /**
     * 生成swagger资源
     *
     * @param name     资源名
     * @param location 资源位置
     * @return
     */
    private SwaggerResource swaggerResource(String name, String location) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(VERSION);
        return swaggerResource;
    }
}
