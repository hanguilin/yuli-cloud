package cn.javayuli.common.security.config;

import cn.javayuli.common.core.constant.SecurityConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hanguilin
 */
public class YuLiSecurityBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	private static final Logger LOGGER = LoggerFactory.getLogger(YuLiSecurityBeanDefinitionRegistrar.class);

	/**
	 * 根据注解值动态注入资源服务器的相关属性
	 *
	 * @param metadata 注解信息
	 * @param registry 注册器
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
		if (registry.isBeanNameInUse(SecurityConstant.RESOURCE_SERVER_CONFIGURER)) {
			LOGGER.warn("本地存在资源服务器配置，覆盖默认配置:" + SecurityConstant.RESOURCE_SERVER_CONFIGURER);
			return;
		}

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(YuLiResourceServerConfigurerAdapter.class);
		registry.registerBeanDefinition(SecurityConstant.RESOURCE_SERVER_CONFIGURER, beanDefinition);

	}

}
