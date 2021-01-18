package cn.javayuli.cloud.common.security.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ReUtil;
import cn.javayuli.cloud.common.security.annotation.Inner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * 接口不鉴权URL
 *
 * @author hanguilin
 */
@Configuration
@ConfigurationProperties("security.oauth2.ignore")
public class IgnoreUrlProperties implements InitializingBean, ApplicationContextAware {

    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");

    private static final String ASTERISK = "*";

    private ApplicationContext applicationContext;

    /**
     * security.oauth2.ignore.urls配置注入
     */
    private List<String> urls = CollUtil.newArrayList();

    @Override
    public void afterPropertiesSet() throws Exception {
        // 获取处理映射器对象
        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 获取路径映射与具体方法的对应关系
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        handlerMethods.entrySet().stream().forEach(entry -> {
            RequestMappingInfo requestMappingInfo = entry.getKey();
            HandlerMethod handlerMethod = entry.getValue();
            // 获取方法上的@Inner注解,将PathVariable替换路径替换成*, eg:/info/{id}=>/info/*
            Inner method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Inner.class);
            Optional.ofNullable(method).ifPresent(o -> requestMappingInfo.getPatternsCondition().getPatterns().forEach(url -> urls.add(ReUtil.replaceAll(url, PATTERN, ASTERISK))));
            // 获取类上的@Inner注解,将PathVariable替换路径替换成*
            Inner type = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Inner.class);
            Optional.ofNullable(type).ifPresent(o -> requestMappingInfo.getPatternsCondition().getPatterns().forEach(url -> urls.add(ReUtil.replaceAll(url, PATTERN, ASTERISK))));
        });
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
