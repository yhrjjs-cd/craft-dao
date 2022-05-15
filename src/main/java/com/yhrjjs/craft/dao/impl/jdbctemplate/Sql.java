package com.yhrjjs.craft.dao.impl.jdbctemplate;

import com.yhrjjs.craft.dao.interceptor.IEntityInterceptor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Sql {
    /**
     * 实体拦截器
     */
    private IEntityInterceptor entityInterceptor;

    /**
     * 获取Insert模板
     *
     * @return Insert模板
     */
    private String insertTemplate;

    /**
     * 待执行的Sql脚本
     */
    private String sqlText;
}
