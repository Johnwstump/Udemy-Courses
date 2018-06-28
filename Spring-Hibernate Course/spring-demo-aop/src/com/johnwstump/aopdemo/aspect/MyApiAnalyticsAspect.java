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

	@Before("com.johnwstump.aopdemo.aspect.AOPExpressions.DAOPackageNotGetterOrSetter()")
	public void performAPIAnalytics(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		
		for (Object o : args) {
			if (o instanceof Account) {
				Account a = (Account)o;
				System.out.println("Account name: " + a.getName());
			}
		}
		System.out.println("\n --->> Performing API analytics()");
	}
	
}
