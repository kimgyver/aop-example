package com.jason.aopdemo;

import com.jason.aopdemo.dao.AccountDAO;
import com.jason.aopdemo.dao.MembershipDAO;
import com.jason.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdvice(trafficFortuneService);
//			demoTheAfterAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheBeforeAdvice(accountDAO, membershipDAO);

		};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Calling fortune service");
		String fortune = trafficFortuneService.getFortune(true);
		System.out.println("My fortune is : " + fortune);
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) throws InterruptedException {
		System.out.println("Calling fortune service");
		String fortune = trafficFortuneService.getFortune();
		System.out.println("My fortune is : " + fortune);
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = new ArrayList<>();
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(true);
		} catch (Exception exception) {
			System.out.println("### Main prgoram: ... caught exception: " + exception);
		}
		System.out.println("At application level: " + accounts);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = new ArrayList<>();
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(true);
		} catch (Exception exception) {
			System.out.println("### Main prgoram: ... caught exception: " + exception);
		}
		System.out.println("At application level: " + accounts);
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts(true);
		System.out.println("At application level: " + accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		accountDAO.addAccount(new Account("account1", "level1"), true);

		accountDAO.doWork();
		accountDAO.getName();
		accountDAO.setName("AAA");
		accountDAO.getServiceName();
		accountDAO.setServiceName("bBBB");

		membershipDAO.addAccount();
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}

}
