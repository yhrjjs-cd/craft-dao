package com.yhrjjs.craft.dao.impl.jdbctemplate;

import com.google.common.collect.Lists;
import com.yhrjjs.craft.dao.annotation.Column;
import com.yhrjjs.craft.dao.annotation.Table;
import com.yhrjjs.craft.dao.api.Chain;
import com.yhrjjs.craft.dao.api.FieldMatcher;
import com.yhrjjs.craft.dao.api.entity.IEntity;
import com.yhrjjs.craft.dao.impl.jdbctemplate.sqlbuilder.InsertSqlTemplateBuilder;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import lombok.SneakyThrows;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ReflectionUtils;
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
public class EntityResolver {
    public static Sql resolveInsertSql(IEntity entity) {
        return Sql.builder()
                .insertTemplate(InsertSqlTemplateBuilder.INSTANCE.build(entity.getClass(), null))
                .entityInterceptor(entity.getEntityInterceptor())
                .build();
    }

    public static Sql resolveInsertSql(IEntity entity, Chain chain) {
        return Sql.builder()
                .insertTemplate(InsertSqlTemplateBuilder.INSTANCE.build(entity.getClass(), chain.getFields()))
                .entityInterceptor(entity.getEntityInterceptor())
                .build();
    }

    public static List<String> resolveFields(Class<? extends IEntity> entityClass) {
        List<String> fields = Lists.newArrayList();

        ReflectionUtils.doWithFields(entityClass, field -> {
            String name = field.getName();

            if (field.isAnnotationPresent(Column.class)) {
                Column column = field.getAnnotation(Column.class);

                if (column.hump()) {
                    fields.add(camel2Underline(name));
                } else if (!StringUtils.isEmpty(column.value())) {
                    fields.add(column.value());
                } else {
                    fields.add(name);
                }
            } else {
                fields.add(name);
            }
        }, field -> field.isAnnotationPresent(Column.class));

        return fields;
    }

    ;

    /**
     * 获取实体对应的表名
     *
     * @param entityClass 实体类
     * @return 表名
     */
    public static String getTableName(Class<? extends IEntity> entityClass) {
        Table table = AnnotationUtils.findAnnotation(entityClass, Table.class);

        return table.value();
    }

    /**
     * 驼峰转下划线
     *
     * @param camelStr 驼峰
     * @return 下划线字符串
     */
    private static String camel2Underline(String camelStr) {
        if (StringUtils.isEmpty(camelStr)) {
            return "";
        }

        int len = camelStr.length();
        StringBuilder sb = new StringBuilder(len + len >> 1);
        for (int i = 0; i < len; i++) {
            char c = camelStr.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @SneakyThrows
    public static <T extends IEntity> IEntity of(Class<T> entityClass) {
        return entityClass.newInstance();
    }

    public static <T extends IEntity> List<IEntity> getLinks(T masterEntity, FieldMatcher fieldMatcher) {
        List<IEntity> links = Lists.newArrayList();
        ReflectionUtils.doWithFields(masterEntity.getClass(), field ->
        {
            List<IEntity> entities = (List<IEntity>) masterEntity.valueMap().get(field.getName());

            if (Objects.isNull(entities)) {
                // TODO LOGGING
            } else {
                links.addAll(entities);
            }
        }, field -> fieldMatcher.match(field.getName()));

        return links;
    }

    public static Sql resolveClearSql(Class<? extends IEntity> classOfEntity) {
        String tableName = getTableName(classOfEntity);

        return Sql.builder()
                .sqlText("DELETE from " + tableName)
                .build();

    }
}
