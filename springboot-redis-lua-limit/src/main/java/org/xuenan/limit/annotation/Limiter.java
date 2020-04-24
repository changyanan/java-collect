package org.xuenan.limit.annotation;

import org.xuenan.limit.type.LimitType;

import java.lang.annotation.*;

/**
 * @author changyanan1
 * @version 1.0.0
 * @date 2020/4/24 11:13
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Limiter {
    /**
     * 名字
     *
     * @return
     */
    String name() default "";

    /**
     * key
     *
     * @return
     */

    String key() default "";


    /**
     * Key的前缀
     *
     * @return
     */

    String prefix() default "";


    /**
     * 给定的时间范围 单位(秒)
     *
     * @return
     */

    int period();


    /**
     * 一定时间内最多访问次数
     *
     * @return
     */

    int count();

    /**
     * 限流的类型(用户自定义key 或者 请求ip)
     *
     * @return
     */

    LimitType limitType() default LimitType.CUSTOMER;
}
