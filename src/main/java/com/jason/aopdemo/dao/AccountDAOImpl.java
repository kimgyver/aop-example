package com.jason.aopdemo.dao;

import com.jason.aopdemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{
    private String name;
    private String serviceName;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT - addAccount()");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + " - doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + " - geName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " - setname()");
        this.name = name;
    }

    public String getServiceName() {
        System.out.println(getClass() + " - getServiceName()");
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        System.out.println(getClass() + " - setServiceName()");
        this.serviceName = serviceName;
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();
        myAccounts.add(new Account("John", "Smith"));
        myAccounts.add(new Account("Madhu", "Platinum"));
        myAccounts.add(new Account("Jason", "Kim"));
        return myAccounts;
    }
}
