package cn.javayuli.auth.config;

import cn.javayuli.common.core.constant.SecurityConstant;
import cn.javayuli.common.security.config.YuLiWebResponseExceptionTranslator;
import cn.javayuli.common.security.entity.YuLiUser;
import cn.javayuli.common.security.service.SysUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * OAuth2 配置
 *
 * @author hanguilin
 */
@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * 指定密码的加密方式
     */
    @Autowired
    public PasswordEncoder passwordEncoder;

    /**
     * 该对象为刷新token提供支持
     */
    @Autowired
    public SysUserDetailsService sysUserDetailsService;

    /**
     * 该对象用来支持password模式
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 该对象用来将令牌信息存储到内存中
     */
    @Autowired
    private TokenStore redisTokenStore;

    /**
     * 密码模式下配置认证管理器 AuthenticationManager,并且设置 AccessToken的存储介质tokenStore,如果不设置，则会默认使用内存当做存储介质。
     * 而该AuthenticationManager将会注入 2个Bean对象用以检查(认证)
     * 1、ClientDetailsService的实现类 JdbcClientDetailsService (检查 ClientDetails 对象)
     * 2、UserDetailsService的实现类 SysUserDetailsService (检查 UserDetails 对象)
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                .authenticationManager(authenticationManager)
                .userDetailsService(sysUserDetailsService)
                .tokenStore(redisTokenStore)
                .tokenEnhancer(tokenEnhancer())
                .reuseRefreshTokens(false)
                .pathMapping("/oauth/confirm_access", "/token/confirm_access")
                .exceptionTranslator(new YuLiWebResponseExceptionTranslator());;
    }

    /**
     * 增强token, 放入更多自定义信息
     *
     * @return
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(3);
            YuLiUser yuLiUser = (YuLiUser) authentication.getUserAuthentication().getPrincipal();
            additionalInfo.put(SecurityConstant.LICENCE, SecurityConstant.PROJECT_LICENSE);
            additionalInfo.put(SecurityConstant.DETAILS_USER_ID, yuLiUser.getId());
            additionalInfo.put(SecurityConstant.DETAILS_USERNAME, yuLiUser.getUsername());
            additionalInfo.put(SecurityConstant.DETAILS_NICKNAME, yuLiUser.getNickname());
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

    /**
     * 从数据库中读取客户端配置
     *
     * @return
     */
    @Bean
    public ClientDetailsService myClientDetailsService() {
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService) clientDetailsService).setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }

    /**
     * 配置客户端详情服务
     * 从数据库读取client配置
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(myClientDetailsService());
    }

    /**
     * 授权码模式下的code存放在数据库中
     *
     * @return
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        //设置授权码模式的授权码数据库存取
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        //oauth/token_key是公开
        security.tokenKeyAccess("permitAll()")
                //oauth/check_token公开
                .checkTokenAccess("permitAll()")
                //表单认证（申请令牌）
                .allowFormAuthenticationForClients();
    }
}
