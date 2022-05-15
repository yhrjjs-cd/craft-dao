package com.yhrjjs.craft.dao.impl.jdbctemplate;

import com.google.common.collect.Lists;
import com.yhrjjs.craft.dao.Config;
import com.yhrjjs.craft.dao.api.Chain;
import com.yhrjjs.craft.dao.config.TestInsertEntity;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@DisplayName("Dao测试")
@SpringBootTest(classes = JdbcTemplateDaoTest.class)
@ComponentScan(basePackageClasses = {Config.class})
public class JdbcTemplateDaoTest {
    @Autowired
    private JdbcTemplateDao jdbcTemplateDao;

    @BeforeAll
    public static void init() {
        System.out.println("开始处理");
    }

    @AfterAll
    public static void exit() {
        System.out.println("结束处理");
    }

    @Test
    public void testInsert1() {
        jdbcTemplateDao.clear(TestInsertEntity.class);
        System.out.println("testInsert1");
        TestInsertEntity entity = new TestInsertEntity();
        entity.setA("这是我的");
        jdbcTemplateDao.insert(entity);
    }

    @Test
    public void testInsert2() {
        List<TestInsertEntity> entities = Lists.newArrayList();
        entities.add(new TestInsertEntity());
        entities.add(new TestInsertEntity());
        entities.add(new TestInsertEntity());

        jdbcTemplateDao.insert(entities);
    }

    @Test
    public void testInsert3() {
        jdbcTemplateDao.insert(TestInsertEntity.class, Chain.of("a", "aaaa").add("c", "cccc"));
    }

    @Test
    public void insertWithLinks() {
//        TestInsertEntity testInsertEntity = new TestInsertEntity();
//
//        jdbcTemplateDao.insertWithLinks(testInsertEntity, FieldMatcher.of("^link1|link2$"));
    }

    @Test
    public void insertWithRelations() {
    }

    @Test
    public void update() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testUpdate1() {
    }

    @Test
    public void testUpdate2() {
    }

    @Test
    public void updateWithLinks() {
    }

    @Test
    public void updateLinks() {
    }

    @Test
    public void updateWithRelations() {
    }

    @Test
    public void updateRelations() {
    }

    @Test
    public void merge() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testDelete1() {
    }

    @Test
    public void deleteWithLinks() {
    }

    @Test
    public void deleteLinks() {
    }

    @Test
    public void deleteWithRelations() {
    }

    @Test
    public void deleteRelations() {
    }

    @Test
    public void fetch() {
    }

    @Test
    public void testFetch() {
    }

    @Test
    public void fetchWithLinks() {
    }

    @Test
    public void testFetchWithLinks() {
    }

    @Test
    public void fetchLinks() {
    }

    @Test
    public void fetchWithRelations() {
    }

    @Test
    public void testFetchWithRelations() {
    }

    @Test
    public void fetchRelations() {
    }

    @Test
    public void query() {
    }

    @Test
    public void testQuery() {
    }

    @Test
    public void testQuery1() {
    }

    @Test
    public void count() {
    }

    @Test
    public void exists() {
    }
}