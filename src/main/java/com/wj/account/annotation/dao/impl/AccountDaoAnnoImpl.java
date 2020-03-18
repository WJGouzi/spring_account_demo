package com.wj.account.annotation.dao.impl;

import com.wj.account.annotation.dao.AccountDaoAnno;
import com.wj.account.annotation.domain.AccountBeanAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.annotation.dao.impl
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
@Repository("accountDaoAnno")
public class AccountDaoAnnoImpl implements AccountDaoAnno {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<AccountBeanAnno> findAllUser() {
        try {
            String sql = "select * from t_account";
            List<AccountBeanAnno> beans = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AccountBeanAnno>(AccountBeanAnno.class));
            return beans;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AccountBeanAnno findUserById(Integer userId) {
        try {
            String sql = "select * from t_account where id = ?";
            AccountBeanAnno demoBean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<AccountBeanAnno>(AccountBeanAnno.class), userId);
            return demoBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addUser(AccountBeanAnno userInfo) {
        String sql = "insert into(name, balance) t_account values(?, ?)";
        jdbcTemplate.update(sql, userInfo.getName(), userInfo.getBalance());
    }

    public AccountBeanAnno updateUserInfo(AccountBeanAnno userInfo) {
        String sql = "update t_account set name = ? , balance = ? where id = ?";
        jdbcTemplate.update(sql, userInfo.getName(), userInfo.getBalance(), userInfo.getId());
        return this.findUserById(userInfo.getId());
    }

    public void deleteUser(Integer userId) {
        String sql = "delet * from t_account where id = ?";
        jdbcTemplate.update(sql, userId);
    }
}
