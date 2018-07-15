package com.johnwstump.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.johnwstump.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {

	@Before("com.johnwstump.aopdemo.aspect.AOPExpressions.DAOPackageNotGetterOrSetter() &&  com.johnwstump.aopdemo.aspect.AOPExpressions.inAccountDAO()")
	public void performAPIAnalytics(JoinPoint joinPoint) {
		System.out.println("--->> Executing @Before advice with order 2");
		
		Object[] args = joinPoint.getArgs();
		
		System.out.println("Retrieving argument from joinpoint: ");
		for (Object o : args) {
			if (o instanceof Account) {
				Account a = (Account)o;
				System.out.println("Account name: " + a.getMember().getFirstName());
			}
		}
		
	}
	
}
