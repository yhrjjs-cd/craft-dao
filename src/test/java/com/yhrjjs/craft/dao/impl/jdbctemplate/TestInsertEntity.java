package com.yhrjjs.craft.dao.impl.jdbctemplate;

import com.google.common.collect.Maps;
import com.yhrjjs.craft.dao.annotation.Column;
import com.yhrjjs.craft.dao.annotation.Table;
import com.yhrjjs.craft.dao.api.entity.IEntity;
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
@Table(value = "test_insert")
public class TestInsertEntity implements IEntity {
    @Column
    private String a;

    @Column
    private String b;

    @Column(value = "c")
    private String c;

    @Column(hump = true)
    private String d;

    @Override
    public Map<String, Object> valueMap() {
        Map<String, Object> valueMap = Maps.newHashMap();
        valueMap.put("a", "a");
        valueMap.put("b", "b");
        valueMap.put("c", "c");
        valueMap.put("d", "d");

        return valueMap;
    }
}
