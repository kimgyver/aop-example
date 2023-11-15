package com.jason.aopdemo.dao;

import com.jason.aopdemo.Account;

import java.util.List;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);
    boolean doWork();

    String getName();
    void setName(String name);
    String getServiceName();
    void setServiceName(String serviceName);
    List<Account> findAccounts();
    List<Account> findAccounts(boolean tripWire);
}
