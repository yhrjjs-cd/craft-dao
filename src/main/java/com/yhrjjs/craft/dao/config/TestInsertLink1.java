package com.yhrjjs.craft.dao.config;

import com.google.common.collect.Maps;
import com.yhrjjs.craft.dao.annotation.Column;
import com.yhrjjs.craft.dao.annotation.Table;
import com.yhrjjs.craft.dao.api.entity.IEntity;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
@Table(value = "test_insert_link1")
public class TestInsertLink1 implements IEntity {
    @Column
    private String l1;

    @Column
    private String l2;
}
