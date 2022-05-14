package com.yhrjjs.craft.dao.impl.jdbctemplate.sqlbuilder;

import com.yhrjjs.craft.dao.api.entity.IEntity;
import java.util.List;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
public interface ISqlTemplateBuilder {
    /**
     * 根据实体类构建模板
     *
     * @param entityClass 实体类
     * @param fields      构建字段
     * @return SQL字符串
     */
    String build(Class<? extends IEntity> entityClass, List<String> fields);
}
