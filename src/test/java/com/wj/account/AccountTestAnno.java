package com.wj.account;

import com.wj.account.annotation.domain.AccountBeanAnno;
import com.wj.account.annotation.service.AccountServiceAnno;
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
@ContextConfiguration(locations = "classpath:AnnotationBean.xml")
public class AccountTestAnno {

    @Autowired
    private ApplicationContext ac;

    @Test
    public void findAllUser () {
        AccountServiceAnno serviceAnno = ac.getBean("accountServiceAnno", AccountServiceAnno.class);
        List<AccountBeanAnno> allUser = serviceAnno.findAllUser();
        System.out.println(allUser);
    }

    @Test
    public void transferAction() {
        AccountServiceAnno serviceAnno = ac.getBean("accountServiceAnno", AccountServiceAnno.class);
        serviceAnno.transferMoney(2, 1, 100);
    }
}
