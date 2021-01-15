package cn.javayuli.common.security.config;

import cn.javayuli.common.security.exception.handler.AccessDeniedHandler;
import cn.javayuli.common.security.exception.handler.ResourceAuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;
import org.springframework.web.client.RestTemplate;

/**
 * 资源服务配置，由EnableYuLiResourceServer注解中的YuLiSecurityBeanDefinitionRegistrar注册成bean
 *
 * @author hanguilin
 */
public class YuLiResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

    @Autowired
    private IgnoreUrlProperties ignoreUrlProperties;

    @Autowired
    private RemoteTokenServices remoteTokenServices;

    @Autowired
    private ResourceAuthExceptionEntryPoint resourceAuthExceptionEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private RestTemplate lbRestTemplate;

    @Autowired
    private YuLiBearerTokenExtractor bearerTokenExtractor;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();
        // 将所有忽略的接口进行放行
        ignoreUrlProperties.getUrls().forEach(url -> registry.antMatchers(url).permitAll());
        // 其余所有接口需要进行验证
        registry.anyRequest().authenticated().and().csrf().disable();
    }

    /**
     * 配置用户信息转换
     *
     * @param resources
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        DefaultAccessTokenConverter accessTokenConverter = new DefaultAccessTokenConverter();
        UserAuthenticationConverter userTokenConverter = new YuLiUserAuthenticationConverter();
        accessTokenConverter.setUserTokenConverter(userTokenConverter);
        remoteTokenServices.setAccessTokenConverter(accessTokenConverter);
        remoteTokenServices.setRestTemplate(lbRestTemplate);

        resources
                .authenticationEntryPoint(resourceAuthExceptionEntryPoint)
                .accessDeniedHandler(accessDeniedHandler)
                .tokenServices(remoteTokenServices)
                .tokenExtractor(bearerTokenExtractor);
    }
}
