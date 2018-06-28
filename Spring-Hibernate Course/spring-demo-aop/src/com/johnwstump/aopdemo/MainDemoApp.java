package com.johnwstump.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.johnwstump.aopdemo.dao.AccountDAO;
import com.johnwstump.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// Read Spring config Java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// Get the bean from the Spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// Call the business method
		accountDAO.addAccount(new Account(new Member("Nathaniel", "Brick"), "Test"));
		
		// Call the business method
		accountDAO.addAccount(new Account(new Member("Dave", "Lowell"), "Bronze"));
				
		accountDAO.setName("Test");
		accountDAO.setServiceCode("Test");
		
		// Get the bean from the Spring container
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		membershipDAO.addAccount();
		
		List<Member> members;
		
		try{
			members = membershipDAO.findMembers();
		}
		catch (Exception ex) {
			System.out.println("Main Program .. caught exception: " + ex.getMessage());
		}
		
		List<Account> accounts = accountDAO.findAccounts();
		
		try {
			membershipDAO.addMember();
		} catch (Exception ex) {
			System.out.println("Main Program .. caught exception: " + ex.getMessage());
		}
		
		// Close the context
		context.close();
	}

}
