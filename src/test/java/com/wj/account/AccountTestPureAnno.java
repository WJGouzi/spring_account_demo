package com.wj.account;

import com.wj.account.pure_annotation.domain.AccountBeanAnno;
import com.wj.account.pure_annotation.service.AccountServicePureAnno;
import com.wj.account.pure_annotation.utils.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTestPureAnno {

    @Autowired
    private ApplicationContext ac;

    @Test
    public void findAllUser() {
        AccountServicePureAnno servicePureAnno = ac.getBean("accountServicePureAnno", AccountServicePureAnno.class);
        List<AccountBeanAnno> allUser = servicePureAnno.findAllUser();
        System.out.println(allUser);
    }

    @Test
    public void transferMoney() {
        AccountServicePureAnno servicePureAnno = ac.getBean("accountServicePureAnno", AccountServicePureAnno.class);
        servicePureAnno.transferMoney(2, 1, 200);
    }
}
