package com.wj.account.xml.service;

import com.wj.account.xml.domain.AccountInfoXml;

import java.util.List;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.xml.service
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
public interface AccountServiceXml {


    /**
     * 找到所有的用户
     * @return
     */
    List<AccountInfoXml> findAllUser();

    /**
     * 根据ID找寻用户
     * @return
     */
    AccountInfoXml findUserById(Integer userId);

    /**
     * 添加用户
     * @param userInfo
     */
    void addUser(AccountInfoXml userInfo);

    /**
     * 更新用户的信息
     * @param userInfo
     * @return
     */
    AccountInfoXml updateUserInfo(AccountInfoXml userInfo);

    /**
     * 删除用户的信息
     * @param
     */
    void deleteUser(Integer userId);

    /**
     * 转账操作
     * @param ownId
     * @param targetId
     * @param money
     */
    void transferMoney(Integer ownId, Integer targetId, double money);

}
