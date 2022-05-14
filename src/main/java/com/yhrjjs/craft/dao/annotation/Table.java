package com.yhrjjs.craft.dao.annotation;

import com.yhrjjs.craft.dao.interceptor.DefaultEntityInterceptor;
import com.yhrjjs.craft.dao.interceptor.IEntityInterceptor;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Table {
    /**
     * @return 对应表名
     */
    String value() default "";

    /**
     * @return 实体拦截器
     */
    Class<? extends IEntityInterceptor> interceptor() default DefaultEntityInterceptor.class;
}
