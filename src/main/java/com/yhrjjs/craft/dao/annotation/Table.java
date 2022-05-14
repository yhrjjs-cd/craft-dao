package com.yhrjjs.craft.dao.annotation;

import com.yhrjjs.craft.dao.interceptor.DefaultEntityInterceptor;
import com.yhrjjs.craft.dao.interceptor.IEntityInterceptor;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
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
