package com.ldbmcs.redPacket.common.annotation;

import java.lang.annotation.*;

/**
 * 限流注解
 *
 * @author ldbmcs
 * @date 2020/8/13
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLimit {
    /**
     * 描述
     */
    String description() default "";

    /**
     * key
     */
    String key() default "";

    /**
     * 类型
     */
    LimitType limitType() default LimitType.CUSTOMER;

    enum LimitType {
        /**
         * 自定义key
         */
        CUSTOMER,
        /**
         * 根据请求者IP
         */
        IP
    }
}
