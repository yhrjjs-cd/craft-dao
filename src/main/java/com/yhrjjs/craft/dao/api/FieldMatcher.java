package com.yhrjjs.craft.dao.api;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
public class FieldMatcher {
    /**
     * 有效的
     */
    private Pattern valid;

    private FieldMatcher(String valid) {
        //TODO 添加缓存
        this.valid = Pattern.compile(valid);
    }

    public static FieldMatcher of(String regex) {
        return new FieldMatcher(regex);
    }

    /**
     * 是否匹配
     *
     * @param field 字段
     * @return 是否匹配
     */
    public boolean match(String field) {
        if (Objects.nonNull(valid)) {
            return valid.matcher(field).find();
        }

        return false;
    }
}
