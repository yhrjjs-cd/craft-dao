package com.yhrjjs.craft.dao.api.entity;

import com.yhrjjs.craft.dao.interceptor.DefaultEntityInterceptor;
import com.yhrjjs.craft.dao.interceptor.IEntityInterceptor;
import java.util.Collections;
import java.util.Map;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
public interface IEntity {
    /**
     * 数据Map，可以为属性名，value为实际值
     *
     * @return 值Map
     */
    default Map<String, Object> valueMap() {
        return Collections.emptyMap();
    }

    /**
     * 获取实体拦截器
     *
     * @return 获取实体拦截器
     */
    default IEntityInterceptor getEntityInterceptor() {
        return new DefaultEntityInterceptor();
    }
}
