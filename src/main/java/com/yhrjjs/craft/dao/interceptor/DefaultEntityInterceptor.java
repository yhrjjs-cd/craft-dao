package com.yhrjjs.craft.dao.interceptor;

import com.yhrjjs.craft.dao.api.entity.IEntity;
import com.yhrjjs.craft.dao.impl.jdbctemplate.OperateType;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
public class DefaultEntityInterceptor implements IEntityInterceptor {
    @Override
    public <T extends IEntity> void setupEntity(T entity, OperateType operateType) {
    }
}
