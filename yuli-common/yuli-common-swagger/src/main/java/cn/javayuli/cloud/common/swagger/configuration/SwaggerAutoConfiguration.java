package cn.javayuli.cloud.common.swagger.configuration;

import cn.javayuli.cloud.common.swagger.property.SwaggerProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: swagger自动注入配置
 * @author: hanguilin
 * @createDate: 2021/1/27
 * @version: 1.0
 */
@EnableSwagger2
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SwaggerProperties.class)
@ConditionalOnProperty(name = "swagger.enabled", matchIfMissing = true)
public class SwaggerAutoConfiguration {

    @Bean
    public Docket api(SwaggerProperties swaggerProperties){
        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerProperties.getHost())
                .apiInfo(apiInfo(swaggerProperties))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(Collections.singletonList(securitySchemes(swaggerProperties)))
                .securityContexts(Collections.singletonList(securityContexts(swaggerProperties)));

    }

    /**
     * 获取api配置信息
     *
     * @param swaggerProperties swagger配置文件
     * @return
     */
    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder().title(swaggerProperties.getTitle()).description(swaggerProperties.getDescription())
                .license(swaggerProperties.getLicense()).licenseUrl(swaggerProperties.getLicenseUrl())
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(),
                        swaggerProperties.getContact().getEmail()))
                .version(swaggerProperties.getVersion()).build();
    }

    /**
     * 认证方式使用密码模式
     *
     * @param swaggerProperties swagger配置文件
     * @return
     */
    private SecurityScheme securitySchemes(SwaggerProperties swaggerProperties) {
        List<GrantType> grantTypeList = swaggerProperties.getAuthorization().getTokenUrlList().stream().map(tokenUrl -> new ResourceOwnerPasswordCredentialsGrant(tokenUrl)).collect(Collectors.toList());
        return new OAuthBuilder()
                .name(swaggerProperties.getAuthorization().getName())
                .grantTypes(grantTypeList)
                .scopes(scopeList(swaggerProperties))
                .build();
    }

    /**
     * 设置 swagger2 认证的安全上下文
     *
     * @param swaggerProperties swagger配置文件
     * @return
     */
    private SecurityContext securityContexts(SwaggerProperties swaggerProperties) {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(defaultAuth(swaggerProperties)))
                .build();
    }

    /**
     * 默认鉴权策略
     *
     * @param swaggerProperties swagger配置文件
     * @return
     */
    private SecurityReference defaultAuth(SwaggerProperties swaggerProperties) {
        List<AuthorizationScope> authorizationScopes = scopeList(swaggerProperties);
        AuthorizationScope[] authorizationScopesArr = new AuthorizationScope[authorizationScopes.size()];
        authorizationScopes.toArray(authorizationScopesArr);
        return SecurityReference.builder()
                .reference(swaggerProperties.getAuthorization().getName())
                .scopes(authorizationScopesArr)
                .build();
    }

    /**
     * 生成scopeList
     *
     * @param swaggerProperties swagger配置文件
     * @return
     */
    private List<AuthorizationScope> scopeList(SwaggerProperties swaggerProperties) {
        List<SwaggerProperties.AuthorizationScope> authorizationScopeList = swaggerProperties.getAuthorization().getAuthorizationScopeList();
        List<AuthorizationScope> scopeList = authorizationScopeList.stream().map(scope -> new AuthorizationScope(scope.getScope(), scope.getDescription())).collect(Collectors.toList());
        return scopeList;
    }
}
