package com.wj.account.xml.dao;

import com.wj.account.xml.domain.AccountInfoXml;

import java.util.List;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.xml.dao
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
public interface AccountDaoXml {
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
}
