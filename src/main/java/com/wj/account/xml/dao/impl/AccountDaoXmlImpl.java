package com.wj.account.xml.dao.impl;

import com.wj.account.xml.dao.AccountDaoXml;
import com.wj.account.xml.domain.AccountInfoXml;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.xml.dao.impl
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
public class AccountDaoXmlImpl implements AccountDaoXml {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<AccountInfoXml> findAllUser() {
        try {
            String sql = "select * from t_account";
            List<AccountInfoXml> beans = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AccountInfoXml>(AccountInfoXml.class));
            return beans;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }    }

    public AccountInfoXml findUserById(Integer userId) {
        try {
            String sql = "select * from t_account where id = ?";
            AccountInfoXml demoBean = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<AccountInfoXml>(AccountInfoXml.class), userId);
            return demoBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addUser(AccountInfoXml userInfo) {
        String sql = "insert into(name, balance) t_account values(?, ?)";
        jdbcTemplate.update(sql, userInfo.getName(), userInfo.getBalance());
    }

    public AccountInfoXml updateUserInfo(AccountInfoXml userInfo) {
        String sql = "update t_account set name = ? , balance = ? where id = ?";
        jdbcTemplate.update(sql, userInfo.getName(), userInfo.getBalance(), userInfo.getId());
        return this.findUserById(userInfo.getId());
    }

    public void deleteUser(Integer userId) {
        String sql = "delet * from t_account where id = ?";
        jdbcTemplate.update(sql, userId);
    }
}
