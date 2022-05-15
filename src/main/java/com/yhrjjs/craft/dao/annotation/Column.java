package com.yhrjjs.craft.dao.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
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
@Target({ElementType.FIELD})
@Inherited
@Documented
public @interface Column {
    /**
     * 对应字段名
     */
    String value() default "";

    /**
     * 是否把字段的命名方式从驼峰式大小写(camelCase)变成蛇底式小写(snake_case)
     *
     * @return true: 蛇底式小写，false: 驼峰式大小写
     */
    boolean hump() default false;
}
