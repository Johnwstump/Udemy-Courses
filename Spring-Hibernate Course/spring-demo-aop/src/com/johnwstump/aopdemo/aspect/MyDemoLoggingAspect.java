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
	
	@Before("forDAOPackage()")
	public void beforeAddAcountAdvice() {
		System.out.println("\n --->> Executing @Before advice on addAccount()");
	}
}
