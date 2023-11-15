package com.jason.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + "DOING MY DB WORK : ADDING AN ACCOUNT - addAccount()");
    }

    @Override
    public boolean addSillyMember() {
        System.out.println(getClass() + "DOING MY DB WORK : ADDING AN ACCOUNT - addSillyMember()");
        return false;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + "I'm going to sleep now... - goToSleep()");
    }
}
