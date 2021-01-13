package cn.javayuli.auth.config;

import cn.javayuli.common.core.constant.SecurityConstant;
import cn.javayuli.common.security.handler.FormAuthenticationFailureHandler;
import cn.javayuli.common.security.handler.FormAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * Spring Security配置
 *
 * @author hanguilin
 */
@Configuration
@Primary
@Order(90)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage(SecurityConstant.LOGIN_URL).loginProcessingUrl(SecurityConstant.LOGIN_FORM)
                .failureHandler(authenticationFailureHandler())
                .successHandler(authenticationSuccessHandler())
                .and().authorizeRequests().antMatchers("/token/**", "/actuator/**").permitAll().anyRequest().authenticated()
                .and().csrf().disable();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new FormAuthenticationFailureHandler();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new FormAuthenticationSuccessHandler();
    }
}
