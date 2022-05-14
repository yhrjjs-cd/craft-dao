package com.yhrjjs.craft.dao.annotation;

/**
 * 标记当前字段为Guid字段
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
public @interface Guid {
    /**
     * 是否自动创建
     *
     * @return 默认true
     */
    boolean auto() default true;
}
