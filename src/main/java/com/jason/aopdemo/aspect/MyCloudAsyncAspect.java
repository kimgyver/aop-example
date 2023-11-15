package com.jason.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(50)
public class MyCloudAsyncAspect {
    @Before("com.jason.aopdemo.aspect.AopExpressions.forDaoPackageExceptGetterSetter()")
    public void cclogToCloudAsync() {
        System.out.println("=========> 50 Logging to Cloud in async fashion");
    }
}
