package com.johnwstump.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


	@Pointcut("execution(* com.johnwstump.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("execution(* get*(..))")
	private void isGetter() {}
	

	@Pointcut("execution(* set*(..))")
	private void isSetter() {}
	
	@Before("forDAOPackage() && !(isSetter() || isGetter())")
	public void beforeAddAcountAdvice() {
		System.out.println("\n --->> Executing @Before advice on addAccount()");
	}
	
	@Before("forDAOPackage()")
	public void performAPIAnalytics() {
		System.out.println("\n --->> Performing API analytics()");
	}
}
