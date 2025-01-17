package com.demo_db_multiple;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

//設定Spring使用的class
@Configuration
public class DataSourceConfiguration {

    // 連線到 test1 資料庫的 DataSource 和 NamedParameterJdbcTemplate
    // 使用 "prefix" : 查看資料庫連線設定
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource test1DataSource() {
        return DataSourceBuilder.create().build();
    }

    // 固定寫法 : 創建專屬的 NamedParameterJdbcTemplate
    @Bean
    public NamedParameterJdbcTemplate test1JdbcTemplate(
            @Qualifier("test1DataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


    // 連線到 test2 資料庫的 DataSource 和 NamedParameterJdbcTemplate
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource test2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public NamedParameterJdbcTemplate test2JdbcTemplate(
            @Qualifier("test2DataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
