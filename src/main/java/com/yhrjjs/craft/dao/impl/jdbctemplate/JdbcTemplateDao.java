package com.yhrjjs.craft.dao.impl.jdbctemplate;

import com.yhrjjs.craft.dao.api.Chain;
import com.yhrjjs.craft.dao.api.FieldMatcher;
import com.yhrjjs.craft.dao.api.IDao;
import com.yhrjjs.craft.dao.api.entity.IEntity;
import com.yhrjjs.craft.dao.api.condition.Condition;
import com.yhrjjs.craft.dao.pager.Pager;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
@Service
@RequiredArgsConstructor
public class JdbcTemplateDao implements IDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public <T extends IEntity> T insert(T entity) {
        Sql sql = EntityResolver.resolveInsertSql(entity);

        sql.getEntityInterceptor().setupEntity(entity, OperateType.INSERT);
        
        namedParameterJdbcTemplate.update(sql.getInsertTemplate(), entity.valueMap());

        return entity;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public <T extends IEntity> List<T> insert(List<T> entities) {
        for (IEntity entity : entities) {
            this.insert(entity);
        }

        return entities;
    }

    @Override
    public <T extends IEntity> T insert(Class<T> entityClass, Chain chain) {
        IEntity entity = EntityResolver.of(entityClass);

        Sql sql = EntityResolver.resolveInsertSql(entity, chain);
        sql.getEntityInterceptor().setupEntity(entity, OperateType.INSERT);

        namedParameterJdbcTemplate.update(sql.getInsertTemplate(), chain.valueMap());

        return (T) entity;
    }

    @Override
    public <T extends IEntity> T insertWithLinks(T masterEntity, FieldMatcher fieldMatcher) {
        Sql sql = EntityResolver.resolveInsertSql(masterEntity);
        sql.getEntityInterceptor().setupEntity(masterEntity, OperateType.INSERT);
        namedParameterJdbcTemplate.update(sql.getInsertTemplate(), masterEntity.valueMap());

        List<IEntity> links = EntityResolver.getLinks(masterEntity, fieldMatcher);
        System.out.println(links);
        for (IEntity entity : links) {
            sql = EntityResolver.resolveInsertSql(entity);
            sql.getEntityInterceptor().setupEntity(entity, OperateType.INSERT);
            namedParameterJdbcTemplate.update(sql.getInsertTemplate(), entity.valueMap());
        }

        return masterEntity;
    }

    @Override
    public <T extends IEntity> T insertWithRelations(T masterEntity, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> int update(T entity) {
        return 0;
    }

    @Override
    public <T extends IEntity> int update(T entity, FieldMatcher fieldMatcher) {
        return 0;
    }

    @Override
    public <T extends IEntity> int update(T entity, FieldMatcher fieldMatcher, boolean ignoreNull) {
        return 0;
    }

    @Override
    public <T extends IEntity> int update(Class<T> classOfT, Chain chain, Condition condition) {
        return 0;
    }

    @Override
    public <T extends IEntity> T updateWithLinks(T masterEntity, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> T updateLinks(T masterEntity, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> T updateWithRelations(T masterEntity, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> T updateRelations(T masterEntity, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> T merge(T entity) {
        return null;
    }

    @Override
    public <T extends IEntity> int delete(T entity) {
        return 0;
    }

    @Override
    public <T extends IEntity> int delete(Class<T> classOfT, Condition condition) {
        return 0;
    }

    @Override
    public <T extends IEntity> int delete(Class<T> classOfT, String guid) {
        return 0;
    }

    @Override
    public <T extends IEntity> int deleteWithLinks(T entity, FieldMatcher fieldMatcher) {
        return 0;
    }

    @Override
    public <T extends IEntity> int deleteLinks(T entity, FieldMatcher fieldMatcher) {
        return 0;
    }

    @Override
    public <T extends IEntity> int deleteWithRelations(T entity, FieldMatcher fieldMatcher) {
        return 0;
    }

    @Override
    public <T extends IEntity> int deleteRelations(T entity, FieldMatcher fieldMatcher) {
        return 0;
    }

    @Override
    public <T extends IEntity> T fetch(Class<T> classOfT, String guid) {
        return null;
    }

    @Override
    public <T extends IEntity> T fetch(Class<T> classOfT, Condition guid) {
        return null;
    }

    @Override
    public <T extends IEntity> T fetchWithLinks(Class<T> classOfT, String guid, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> T fetchWithLinks(Class<T> classOfT, Condition guid, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> T fetchLinks(T entity, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> T fetchWithRelations(Class<T> classOfT, String guid, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> T fetchWithRelations(Class<T> classOfT, Condition guid, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> T fetchRelations(T entity, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> List<T> query(Class<T> classOfT, Condition condition) {
        return null;
    }

    @Override
    public <T extends IEntity> List<T> query(Class<T> classOfT, Condition condition, Pager pager) {
        return null;
    }

    @Override
    public <T extends IEntity> List<T> query(Class<T> classOfT, Condition condition, Pager pager, FieldMatcher fieldMatcher) {
        return null;
    }

    @Override
    public <T extends IEntity> List<T> count(Class<T> classOfT, Condition condition) {
        return null;
    }

    @Override
    public <T extends IEntity> List<T> exists(Class<T> classOfT, Condition condition) {
        return null;
    }
//    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
}
