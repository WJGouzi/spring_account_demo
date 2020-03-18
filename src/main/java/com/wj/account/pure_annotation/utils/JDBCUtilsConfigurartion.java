package com.wj.account.pure_annotation.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.pure_annotation.utils
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
@PropertySource("druid.properties")
public class JDBCUtilsConfigurartion {

    @Value("${driverClassName}")
    private String driverClassName;

    @Value("${url}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${initialSize}")
    private String initialSize;

    @Value("${maxActive}")
    private String maxActive;

    @Value("${minIdle}")
    private String minIdle;

    @Value("${maxWait}")
    private String maxWait;

    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("dataSource")
    public DataSource createDataSource() {
        try {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName(driverClassName);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setInitialSize(Integer.parseInt(initialSize));
            dataSource.setMaxActive(Integer.parseInt(maxActive));
            dataSource.setMinIdle(Integer.parseInt(minIdle));
            dataSource.setMaxWait(Long.parseLong(maxWait));
            return dataSource;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}