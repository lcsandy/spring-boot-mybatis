package com.wxstock;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.inject.Inject;
import javax.sql.DataSource;

/**
 * config in java
 * Created by wcong on 15/6/5.
 */
@Configuration
public class AppConfig {

    @Bean
    DataSource makeDataSource(@Value("${spring.datasource.url}") String url,
                              @Value("${spring.datasource.username}") String useName,
                              @Value("${spring.datasource.password}") String password,
                              @Value("${spring.datasource.driver-class-name}") String driverName) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(url);
        dataSource.setUsername(useName);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    @Inject
    SqlSessionFactoryBean makeSqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    MapperScannerConfigurer makeMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.wxstock.repository.mapper");
        return mapperScannerConfigurer;
    }

    @Bean
    @Inject
    DataSourceTransactionManager makeDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
