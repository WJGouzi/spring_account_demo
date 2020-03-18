package com.wj.account.annotation.dao;

import com.wj.account.annotation.domain.AccountBeanAnno;

import java.util.List;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.annotation.dao.impl
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
public interface AccountDaoAnno {

    /**
     * 找到所有的用户
     * @return
     */
    List<AccountBeanAnno> findAllUser();

    /**
     * 根据ID找寻用户
     * @return
     */
    AccountBeanAnno findUserById(Integer userId);

    /**
     * 添加用户
     * @param userInfo
     */
    void addUser(AccountBeanAnno userInfo);

    /**
     * 更新用户的信息
     * @param userInfo
     * @return
     */
    AccountBeanAnno updateUserInfo(AccountBeanAnno userInfo);

    /**
     * 删除用户的信息
     * @param
     */
    void deleteUser(Integer userId);
}
