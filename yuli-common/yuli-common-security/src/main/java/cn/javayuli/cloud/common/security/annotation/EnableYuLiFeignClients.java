package cn.javayuli.cloud.common.security.annotation;

import org.springframework.cloud.openfeign.EnableFeignClients;

import java.lang.annotation.*;


/**
 * 自定义feign注解
 *
 * @author hanguilin
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableFeignClients
public @interface EnableYuLiFeignClients {

	String[] value() default {};

	// 配置默认扫描包
	String[] basePackages() default { "cn.javayuli.cloud" };

	Class<?>[] basePackageClasses() default {};

	Class<?>[] defaultConfiguration() default {};

	Class<?>[] clients() default {};

}
