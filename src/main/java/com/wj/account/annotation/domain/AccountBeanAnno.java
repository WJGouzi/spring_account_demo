package com.wj.account.annotation.domain;

/**
 * @Project : spring_account_demo
 * @Package : com.wj.account.annotation.domain
 * @Author : Created By gouzi, Copyright © gouzi All Rights Reserved
 * @Date : 2020/3/18
 */
public class AccountBeanAnno {
    private Integer id;
    private String name;
    private Double balance;

    public AccountBeanAnno() {
    }

    public AccountBeanAnno(Integer id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
