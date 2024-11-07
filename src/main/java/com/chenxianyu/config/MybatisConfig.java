package com.chenxianyu.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;


import javax.sql.DataSource;

@MapperScan("com.chenxianyu.mapper")
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    // 配置MybatisPlus
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("com.chenxianyu.model");
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 设置驼峰命名规则
        Configuration configuration = new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);

        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.chenxianyu.mapper");
        return mapperScannerConfigurer;
    }
}