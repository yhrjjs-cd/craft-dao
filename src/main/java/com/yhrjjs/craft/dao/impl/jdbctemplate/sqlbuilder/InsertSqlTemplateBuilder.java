package com.yhrjjs.craft.dao.impl.jdbctemplate.sqlbuilder;

import com.yhrjjs.craft.dao.api.entity.IEntity;
import com.yhrjjs.craft.dao.impl.jdbctemplate.EntityResolver;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import org.springframework.util.StringUtils;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
public enum InsertSqlTemplateBuilder implements ISqlTemplateBuilder {
    INSTANCE;

    @Override
    public String build(Class<? extends IEntity> entityClass, List<String> fields) {
        List<String> fieldList;
        if (Objects.isNull(fields)) {
            fieldList = EntityResolver.resolveFields(entityClass);
        } else {
            fieldList = fields;
        }

        StringJoiner sqlJoiner = new StringJoiner(" ");
        sqlJoiner.add("INSERT INTO")
                .add(EntityResolver.getTableName(entityClass))
                .add("(")
                .add(StringUtils.collectionToCommaDelimitedString(fieldList))
                .add(") values (")
                .add(StringUtils.collectionToCommaDelimitedString(fieldList.stream().map(field -> ":" + field).collect(Collectors.toList())))
                .add(")");

        return sqlJoiner.toString();
    }
}
