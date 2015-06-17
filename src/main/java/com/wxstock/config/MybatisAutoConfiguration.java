package com.wxstock.config;

import lombok.Data;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * auto configuration of mybatis
 * Created by wcong on 15/6/16.
 */
@Configuration
@ConditionalOnClass({MapperScannerConfigurer.class, SqlSessionFactoryBean.class})
@EnableConfigurationProperties(MybatisAutoConfiguration.MybatisProperties.class)
public class MybatisAutoConfiguration {

    @Inject
    private DataSource dataSource;

    @Inject
    private MybatisProperties mybatisProperties;

    @Bean
    public SqlSessionFactoryBean makeSqlSessionFactoryBean() throws SQLException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer makeMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(mybatisProperties.getBasePackage());
        return mapperScannerConfigurer;
    }


    @ConfigurationProperties("spring.mybatis")
    @Data
    public static class MybatisProperties {
        private String basePackage;
    }
}
