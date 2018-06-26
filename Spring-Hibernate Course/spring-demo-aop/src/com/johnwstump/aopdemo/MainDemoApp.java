package com.johnwstump.aopdemo;

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
		accountDAO.addAccount();
		
		// Call the business method
		accountDAO.addAccount();
				
		// Get the bean from the Spring container
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		membershipDAO.addAccount();
		
		// Close the context
		context.close();
	}

}
