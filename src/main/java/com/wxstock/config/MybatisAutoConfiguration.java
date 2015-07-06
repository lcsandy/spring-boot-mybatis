//package com.wxstock.config;
//
//import lombok.Data;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//
//import javax.inject.Inject;
//import javax.sql.DataSource;
//import java.sql.SQLException;
//
//import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;
//
///**
// * auto configuration of mybatis
// * Created by wcong on 15/6/16.
// */
//@Configuration
//@ConditionalOnClass({MapperScannerConfigurer.class, SqlSessionFactoryBean.class})
//@EnableConfigurationProperties(MybatisAutoConfiguration.MybatisProperties.class)
//@MapperScan(basePackages="com.wxstock.repository.mapper")
//public class MybatisAutoConfiguration {
//
//    @Inject
//    private DataSource dataSource;
//
//    @Inject
//    private MybatisProperties mybatisProperties;
//
//    @Bean
//    public SqlSessionFactoryBean makeSqlSessionFactoryBean() throws SQLException {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource);
//        return sqlSessionFactoryBean;
//    }
//
//    @Bean
//    public MapperScannerConfigurer makeMapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage(mybatisProperties.getBasePackage());
//        return mapperScannerConfigurer;
//    }
//
//    @ConfigurationProperties("spring.mybatis")
//    @Data
//    public static class MybatisProperties {
//        private String basePackage;
//
//        public String getBasePackage() {
//            return basePackage;
//        }
//
//        public void setBasePackage(String basePackage) {
//            this.basePackage = basePackage;
//        }
//    }
//
//
//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder().setType(H2).build();
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//        return sessionFactory.getObject();
//    }
//}
