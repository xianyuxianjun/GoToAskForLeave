package com.chenxianyu.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 数据库配置
 */
@Configuration
public class JdbcConfig {
    private final String driverClassName = "com.mysql.cj.jdbc.Driver";
    private final String url ="jdbc:mysql://47.120.63.135:3306/wxyqj";
    private final String username = "root";
    private final String password = "123456";
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
