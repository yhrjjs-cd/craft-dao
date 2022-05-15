package com.yhrjjs.craft.dao;

import com.yhrjjs.craft.dao.impl.jdbctemplate.JdbcTemplateDao;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 * (iTek-china 2022)
 *
 * @author <a href="huangqi@itek-china.com">黄奇</a>
 * @version 7.0
 * <pre>
 *   2022-05-14 * 黄奇创建
 * </pre>
 */
@Configuration
@RequiredArgsConstructor
public class Config {
    @Bean
    public DataSource dataSource() {
        //可以在此处调用相关接口获取数据库的配置信息进行 DataSource 的配置
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setUrl("jdbc:mysql://rm-bp122m4oxuti48i0kro.mysql.rds.aliyuncs.com:3306/sfa_test?useUnicode=true&characterEncoding=UTF-8&allowPublicKeyRetrieval=true");
        dataSource.setUsername("sfa_test");
        dataSource.setPassword("sfa_test_iTek@123456");
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);

        return dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
