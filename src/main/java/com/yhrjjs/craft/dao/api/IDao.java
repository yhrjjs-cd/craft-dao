package com.yhrjjs.craft.dao.api;

import com.yhrjjs.craft.dao.api.condition.Condition;
import com.yhrjjs.craft.dao.api.entity.IEntity;
import com.yhrjjs.craft.dao.pager.Pager;
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
public interface IDao {
    /**
     * 插入实体对象
     *
     * @param entity 实体对象
     * @param <T>    实体类型
     * @return 属性更新后的当前对象
     */
    <T extends IEntity> T insert(T entity);

    /**
     * 插入多个实体对象
     *
     * @param entities 实体对象列表
     * @param <T>      实体类型
     * @return 插入的实体列表
     */
    <T extends IEntity> List<T> insert(List<T> entities);

    /**
     * 根据实体名、属性链插入对象，返回插入的对象
     *
     * @param entityClass 实体类
     * @param chain       属性链
     * @return 插入的对象
     */
    <T extends IEntity> T insert(Class<T> entityClass, Chain chain);

    /**
     * 同时插入主子实体
     *
     * @param masterEntity 主实体
     * @param fieldMatcher 匹配字段
     * @param <T>          实体类型
     * @return 主实体
     */
    <T extends IEntity> T insertWithLinks(T masterEntity, FieldMatcher fieldMatcher);


    /**
     * 同时插入主实体，关联实体
     *
     * @param masterEntity 主实体
     * @param fieldMatcher 匹配字段
     * @param <T>          实体类型
     * @return 主实体
     */
    <T extends IEntity> T insertWithRelations(T masterEntity, FieldMatcher fieldMatcher);

    /**
     * 更新实体
     *
     * @param entity 实体
     * @param <T>    实体类型
     * @return 更新记录条数，一般情况下，成功返回1，否则返回0
     */
    <T extends IEntity> int update(T entity);

    /**
     * 更新实体，过滤字段
     *
     * @param entity       实体
     * @param fieldMatcher 匹配字段
     * @param <T>          实体类型
     * @return 更新记录条数，一般情况下，成功返回1，否则返回0
     */
    <T extends IEntity> int update(T entity, FieldMatcher fieldMatcher);

    /**
     * 更新实体，过滤字段，可忽略空值
     *
     * @param entity       实体
     * @param fieldMatcher 匹配字段
     * @param ignoreNull   是否忽略空值
     * @param <T>          实体类型
     * @return 更新记录条数，一般情况下，成功返回1，否则返回0
     */
    <T extends IEntity> int update(T entity, FieldMatcher fieldMatcher, boolean ignoreNull);

    /**
     * 根据条件更新
     *
     * @param classOfT  实体类
     * @param chain     属性链
     * @param condition 条件
     * @param <T>       实体类型
     * @return 更新记录条数
     */
    <T extends IEntity> int update(Class<T> classOfT, Chain chain, Condition condition);

    /**
     * 更新主子实体
     *
     * @param masterEntity 主实体
     * @param fieldMatcher 匹配字段
     * @param <T>          实体类型
     * @return 主实体
     */
    <T extends IEntity> T updateWithLinks(T masterEntity, FieldMatcher fieldMatcher);

    /**
     * 更新子实体
     *
     * @param masterEntity 主实体
     * @param fieldMatcher 匹配字段
     * @param <T>          实体类型
     * @return 主实体
     */
    <T extends IEntity> T updateLinks(T masterEntity, FieldMatcher fieldMatcher);

    /**
     * 更新主实体，同时更新关联实体
     *
     * @param masterEntity 主实体
     * @param fieldMatcher 匹配字段
     * @param <T>          实体类型
     * @return 主实体
     */
    <T extends IEntity> T updateWithRelations(T masterEntity, FieldMatcher fieldMatcher);

    /**
     * 更新关联实体
     *
     * @param masterEntity 主实体
     * @param fieldMatcher 匹配字段
     * @param <T>          实体类型
     * @return 主实体
     */
    <T extends IEntity> T updateRelations(T masterEntity, FieldMatcher fieldMatcher);

    <T extends IEntity> T merge(T entity);

    <T extends IEntity> int delete(T entity);

    <T extends IEntity> int delete(Class<T> classOfT, Condition condition);

    <T extends IEntity> int delete(Class<T> classOfT, String guid);

    <T extends IEntity> int deleteWithLinks(T entity, FieldMatcher fieldMatcher);

    <T extends IEntity> int deleteLinks(T entity, FieldMatcher fieldMatcher);

    <T extends IEntity> int deleteWithRelations(T entity, FieldMatcher fieldMatcher);

    <T extends IEntity> int deleteRelations(T entity, FieldMatcher fieldMatcher);

    <T extends IEntity> T fetch(Class<T> classOfT, String guid);

    <T extends IEntity> T fetch(Class<T> classOfT, Condition guid);

    <T extends IEntity> T fetchWithLinks(Class<T> classOfT, String guid, FieldMatcher fieldMatcher);

    <T extends IEntity> T fetchWithLinks(Class<T> classOfT, Condition guid, FieldMatcher fieldMatcher);

    <T extends IEntity> T fetchLinks(T entity, FieldMatcher fieldMatcher);

    <T extends IEntity> T fetchWithRelations(Class<T> classOfT, String guid, FieldMatcher fieldMatcher);

    <T extends IEntity> T fetchWithRelations(Class<T> classOfT, Condition guid, FieldMatcher fieldMatcher);

    <T extends IEntity> T fetchRelations(T entity, FieldMatcher fieldMatcher);

    <T extends IEntity> List<T> query(Class<T> classOfT, Condition condition);

    <T extends IEntity> List<T> query(Class<T> classOfT, Condition condition, Pager pager);

    <T extends IEntity> List<T> query(Class<T> classOfT, Condition condition, Pager pager, FieldMatcher fieldMatcher);

    <T extends IEntity> List<T> count(Class<T> classOfT, Condition condition);

    <T extends IEntity> List<T> exists(Class<T> classOfT, Condition condition);

    /**
     * 清除， 会删除表所有记录
     *
     * @param classOfEntity 实体类
     */
    void clear(Class<? extends IEntity> classOfEntity);
}
