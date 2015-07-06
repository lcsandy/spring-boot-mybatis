package com.wxstock.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <p>name:  </p>
 * <p>desc:  </p>
 * <p>Copyright: www.hunantv.com</p>
 * <p>Company:  www.hunantv.com</p>
 *
 * @author  lcsandy on 15/7/6.
 * @version  1.0
 */
@Configuration
@MapperScan("com.wxstock.repository.mapper")
public class AppConfig {

//    @Autowired
//    private AppDataSourceProperties appDataSourceProperties;

//    @Bean
//    public DataSource getDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(appDataSourceProperties.getDriver());
//        dataSource.setUrl(appDataSourceProperties.getUrl());
//        dataSource.setUsername(appDataSourceProperties.getUsername());
//        dataSource.setPassword(appDataSourceProperties.getPassword());
//        dataSource.setValidationQuery("select 1");
//        return dataSource;
//    }

    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(getDataSource());
    }
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        return sessionFactory.getObject();
    }
}