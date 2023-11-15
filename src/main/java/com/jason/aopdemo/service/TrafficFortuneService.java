package com.jason.aopdemo.service;

public interface TrafficFortuneService {
    String getFortune() throws InterruptedException;
    String getFortune(boolean tripWire);
}
