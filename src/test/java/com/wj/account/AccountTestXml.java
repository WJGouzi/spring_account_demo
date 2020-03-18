package com.wj.account;

import com.wj.account.xml.domain.AccountInfoXml;
import com.wj.account.xml.service.AccountServiceXml;
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
@ContextConfiguration(locations = "classpath:XmlBean.xml")
public class AccountTestXml {

    @Autowired
    private ApplicationContext ac;

    @Test
    public void findAllAccount () {
        AccountServiceXml accountServiceXml = ac.getBean("accountServiceXml", AccountServiceXml.class);
        List<AccountInfoXml> allUser = accountServiceXml.findAllUser();
        System.out.println(allUser);
    }

    @Test
    public void transferAction() {
        AccountServiceXml accountServiceXml = ac.getBean("accountServiceXml", AccountServiceXml.class);
        accountServiceXml.transferMoney(1, 2, 100);
    }

}
