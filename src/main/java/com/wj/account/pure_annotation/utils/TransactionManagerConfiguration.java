package com.wj.account.pure_annotation.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.pure_annotation.utils
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */

public class TransactionManagerConfiguration {

    @Bean("transactionManager")
    public DataSourceTransactionManager createDataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
