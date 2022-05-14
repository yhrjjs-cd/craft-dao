package com.yhrjjs.craft.dao.impl.jdbctemplate;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class EntityResolverTest {

    @Test
    public void resolveInsertSql() {
        Sql sql = EntityResolver.resolveInsertSql(new TestInsertEntity());

        Assert.assertTrue(sql.getInsertTemplate().startsWith("INSERT"));
        Assert.assertNotNull(sql.getEntityInterceptor());
    }

    @Test
    public void resolveFields() {
        List<String> fields = EntityResolver.resolveFields(TestInsertEntity.class);
        Assert.assertEquals(4, fields.size());
        Assert.assertEquals("guidGuid", fields.get(0));
        Assert.assertEquals("cameNormal", fields.get(1));
        Assert.assertEquals("name_camel", fields.get(2));
        Assert.assertEquals("name_underline", fields.get(3));

    }

    @Test
    public void getTableName() {
        Assert.assertEquals("insert_entity", EntityResolver.getTableName(TestInsertEntity.class));
    }
}