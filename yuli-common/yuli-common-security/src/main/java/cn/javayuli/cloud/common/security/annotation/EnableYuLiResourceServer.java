package cn.javayuli.cloud.common.security.annotation;

import cn.javayuli.cloud.common.security.config.YuLiResourceServerAutoConfiguration;
import cn.javayuli.cloud.common.security.config.YuLiSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * 资源服务注解
 *
 * @author hanguilin
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ YuLiSecurityBeanDefinitionRegistrar.class, YuLiResourceServerAutoConfiguration.class })
public @interface EnableYuLiResourceServer {

}
