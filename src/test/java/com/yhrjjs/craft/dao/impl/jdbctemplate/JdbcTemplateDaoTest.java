package com.yhrjjs.craft.dao.impl.jdbctemplate;

import com.google.common.collect.Lists;
import com.yhrjjs.craft.dao.api.Chain;
import com.yhrjjs.craft.dao.config.Config;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JdbcTemplateDaoTest.class)
@ComponentScan(basePackageClasses = {Config.class, JdbcTemplateDao.class})
public class JdbcTemplateDaoTest {
    @Autowired
    private JdbcTemplateDao jdbcTemplateDao;

    @Test
    public void testInsert1() {
//        TestInsertEntity entity = new TestInsertEntity();
//        jdbcTemplateDao.insert(entity);
    }

    @Test
    public void testInsert2() {
//        List<TestInsertEntity> entities = Lists.newArrayList();
//        entities.add(new TestInsertEntity());
//        entities.add(new TestInsertEntity());
//        entities.add(new TestInsertEntity());
//
//        jdbcTemplateDao.insert(entities);
    }

    @Test
    public void testInsert3() {
        jdbcTemplateDao.insert(TestInsertEntity.class, Chain.of("a", "aaaa").add("c", "cccc"));
    }

    @Test
    public void insertWithLinks() {
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