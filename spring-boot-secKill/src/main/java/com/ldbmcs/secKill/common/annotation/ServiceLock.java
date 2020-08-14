package com.ldbmcs.secKill.common.annotation;

import java.lang.annotation.*;

/**
 * 同步锁注解
 *
 * @author ldbmcs
 * @date 2020/8/13
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLock {
    String description() default "";
}
