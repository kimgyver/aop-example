package com.jason.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class MyAnalyticsAspect {
    @Before("com.jason.aopdemo.aspect.AopExpressions.forDaoPackageExceptGetterSetter()")
    public void bbpeformApiAnalytics() {
        System.out.println("=========> -1Performing API analytics");
    }
}
