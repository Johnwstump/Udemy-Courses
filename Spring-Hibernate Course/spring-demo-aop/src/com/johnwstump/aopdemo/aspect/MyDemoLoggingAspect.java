package com.johnwstump.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.johnwstump.aopdemo.aspect.AOPExpressions.DAOPackageNotGetterOrSetter()")
	public void beforeAddAcountAdvice() {
		System.out.println("\n --->> Executing @Before advice on addAccount()");
	}
	
	
}
