package com.johnwstump.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.johnwstump.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.johnwstump.aopdemo.aspect.AOPExpressions.DAOPackageNotGetterOrSetter()")
	public void beforeAddAcountAdvice(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + signature);
		
		Object[] args = joinPoint.getArgs();
		
		for (Object arg : args) {
			System.out.println("Arg: " + arg);
		}
		
		System.out.println("\n --->> Executing @Before advice");
	}
	
	
	@AfterReturning(pointcut ="execution(* com.johnwstump.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\n\n" + method);
		System.out.println("Result is: " + result);
		
		convertAccountNamesToUpper(result);
		
		System.out.println("After Modification Result is: " + result);
	}
	
	private void convertAccountNamesToUpper(List<Account> result) {
		for (Account a : result) {
			a.setName(a.getName().toUpperCase());
		}
	}
	
}
