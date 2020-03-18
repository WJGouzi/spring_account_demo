package com.wj.account.annotation.service.impl;

import com.wj.account.annotation.dao.AccountDaoAnno;
import com.wj.account.annotation.domain.AccountBeanAnno;
import com.wj.account.annotation.service.AccountServiceAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.xml.service.impl
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
@Service("accountServiceAnno")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class AccountServiceAnnoImpl implements AccountServiceAnno {

    @Autowired
    private AccountDaoAnno accountDaoAnno;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<AccountBeanAnno> findAllUser() {
        return accountDaoAnno.findAllUser();
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public AccountBeanAnno findUserById(Integer userId) {
        return accountDaoAnno.findUserById(userId);
    }

    public void addUser(AccountBeanAnno userInfo) {
        accountDaoAnno.addUser(userInfo);
    }

    public AccountBeanAnno updateUserInfo(AccountBeanAnno userInfo) {
        return accountDaoAnno.updateUserInfo(userInfo);
    }

    public void deleteUser(Integer userId) {
        accountDaoAnno.deleteUser(userId);
    }

    public void transferMoney(Integer ownId, Integer targetId, double money) {
        AccountBeanAnno ownUser = findUserById(ownId);
        AccountBeanAnno targetUser = findUserById(targetId);
        if (ownUser.getId() == targetUser.getId()) {
            throw new RuntimeException("账号不能相同");
        }
        if (ownUser.getBalance() < money) {
            throw new RuntimeException("转账金额过大");
        } else {
            ownUser.setBalance(ownUser.getBalance() - money);
            targetUser.setBalance(targetUser.getBalance() + money);
            updateUserInfo(ownUser);
            int i = 1/0;
            updateUserInfo(targetUser);
        }
    }
}
