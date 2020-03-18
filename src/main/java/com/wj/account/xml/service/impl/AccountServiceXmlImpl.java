package com.wj.account.xml.service.impl;

import com.wj.account.xml.dao.AccountDaoXml;
import com.wj.account.xml.domain.AccountInfoXml;
import com.wj.account.xml.service.AccountServiceXml;

import java.util.List;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.xml.service.impl
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
public class AccountServiceXmlImpl implements AccountServiceXml {

    private AccountDaoXml accountDaoXml;

    public void setAccountDaoXml(AccountDaoXml accountDaoXml) {
        this.accountDaoXml = accountDaoXml;
    }

    public List<AccountInfoXml> findAllUser() {
        return accountDaoXml.findAllUser();
    }

    public AccountInfoXml findUserById(Integer userId) {
        return accountDaoXml.findUserById(userId);
    }

    public void addUser(AccountInfoXml userInfo) {
        accountDaoXml.addUser(userInfo);
    }

    public AccountInfoXml updateUserInfo(AccountInfoXml userInfo) {
        return accountDaoXml.updateUserInfo(userInfo);
    }

    public void deleteUser(Integer userId) {
        accountDaoXml.deleteUser(userId);
    }

    public void transferMoney(Integer ownId, Integer targetId, double money) {
        AccountInfoXml ownUser = findUserById(ownId);
        AccountInfoXml targetUser = findUserById(targetId);
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
