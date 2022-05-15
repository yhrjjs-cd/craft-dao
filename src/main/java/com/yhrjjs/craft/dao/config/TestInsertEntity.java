package com.yhrjjs.craft.dao.config;

import com.google.common.collect.Lists;
import com.yhrjjs.craft.dao.annotation.Column;
import com.yhrjjs.craft.dao.annotation.Guid;
import com.yhrjjs.craft.dao.annotation.Table;
import com.yhrjjs.craft.dao.api.entity.IEntity;
import java.util.List;
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
@Table(value = "test_insert")
@Data
public class TestInsertEntity implements IEntity {
    public TestInsertEntity() {
        this.link1.add(new TestInsertLink1());
        this.link1.add(new TestInsertLink1());
    }

    @Column
    @Guid
    private String a;

    @Column
    private String b;

    @Column(value = "c")
    private String c;

    @Column(hump = true)
    private String d;

    private List<TestInsertLink1> link1 = Lists.newArrayList();
}
