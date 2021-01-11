package cn.javayuli.common.security.annotation;

import java.lang.annotation.*;

/**
 * 定义内部访问接口
 *
 * @author hanguilin
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inner {

    /**
     * 是否仅仅只能用于内部Feign调用
     *
     * @return
     */
    boolean value() default true;
}
