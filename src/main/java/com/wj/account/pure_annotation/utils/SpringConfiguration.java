package com.wj.account.pure_annotation.utils;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.pure_annotation.utils
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
@Configuration
@ComponentScan("com.wj.account.pure_annotation")
@Import({JDBCUtilsConfigurartion.class, TransactionManagerConfiguration.class})
@EnableTransactionManagement
public class SpringConfiguration {

}
