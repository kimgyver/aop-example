package com.jason.aopdemo.aspect;

import com.jason.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyLoginAspect {

//    @Before("execution(public void addAccount())")
//    @Before("execution(public void com.jason.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*(..))")
//    @Before("execution(* add*(.., com.jason.aopdemo.Account, ..))")
//    @Before("execution(* com.jason.aopdemo.dao.*.*(..))")
//    @Before("forDaoPackage()")
    @Before("com.jason.aopdemo.aspect.AopExpressions.forDaoPackageExceptGetterSetter()")
    public void aalogin(JoinPoint joinPoint) {
        System.out.println("==========> 3Login!");

        Signature signature = joinPoint.getSignature();
        System.out.println("* " + signature);

        Object[] args = joinPoint.getArgs();
        for (var arg : args) {
            System.out.println("*- " + arg);
            if (arg instanceof Account) {
                Account account = (Account)arg;
                System.out.println("*--" + account.getName() + " " + account.getLevel());
            }
        }
    }

    @AfterReturning(
            pointcut = "execution(* com.jason.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> result) {
        System.out.println("<========== after retuning!");
        System.out.println("joinPoint signature: " + joinPoint.getSignature());
        System.out.println("joinPoint args: " + joinPoint.getArgs());
        System.out.println("At AfterReturning level: " + result);

        convertAccountNamesToUpperCase(result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.jason.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("<========== After throwing!");
        System.out.println("joinPoint signature : " + joinPoint.getSignature());
        System.out.println("joinPoint args : " + joinPoint.getArgs());
        System.out.println("At AfterReturning level: " + exception.getLocalizedMessage());
    }

    @After("execution(* com.jason.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("<========== After");
        System.out.println("joinPoint signature : " + joinPoint.getSignature());
        System.out.println("joinPoint args : " + joinPoint.getArgs());
    }

    @Around("execution(* com.jason.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("========== Around");
        System.out.println("proceedingJoinPoint signature : " + proceedingJoinPoint.getSignature());
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exception) {
            System.out.println("Exception: " + exception.getMessage());
            result = "**********************";
            throw exception;
        }
        long end = System.currentTimeMillis();
        System.out.println("Duration : " + (end - begin) + " milliseconds");
        return result;
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (var account : result) {
            account.setName(account.getName().toUpperCase());
            account.setLevel(account.getLevel().toLowerCase());
        }
    }
}
