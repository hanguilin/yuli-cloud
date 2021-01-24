package cn.javayuli.cloud.common.datasource.annotation;

import cn.javayuli.cloud.common.datasource.configuration.DynamicDataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @description: 开启动态数据源
 * @author: hanguilin
 * @createDate: 2021/1/23
 * @version: 1.0
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(DynamicDataSourceAutoConfiguration.class)
public @interface EnableYuLiDynamicDatasource {
}
