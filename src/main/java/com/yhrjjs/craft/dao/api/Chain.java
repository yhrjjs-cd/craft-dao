package com.yhrjjs.craft.dao.api;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
public class Chain {
    private ChainEntry head;
    private ChainEntry tail;

    private Chain(String name, Object value) {
        this.head = new ChainEntry(name, value);
        this.tail = head;
    }

    public static Chain of(String name, Object value) {
        return new Chain(name, value);
    }

    public Chain add(String name, Object value) {
        tail.next = new ChainEntry(name, value);
        tail = tail.next;

        return this;
    }

    /**
     * 获取加载的字段列表
     *
     * @return 字段列表
     */
    public List<String> getFields() {
        List<String> fields = Lists.newArrayList();
        ChainEntry current = this.head;

        while (Objects.nonNull(current)) {
            fields.add(current.name);

            current = current.next;
        }

        return fields;
    }

    public Map<String, Object> valueMap() {
        Map<String, Object> values = Maps.newHashMap();
        ChainEntry current = this.head;

        while (Objects.nonNull(current)) {
            values.put(current.name, current.value);

            current = current.next;
        }

        return values;
    }

    public static class ChainEntry {
        protected String name;
        protected Object value;
        //        protected boolean special;
        protected ChainEntry next;

        public ChainEntry(String name, Object value) {
            this.name = name;
            this.value = value;
        }
    }
}
