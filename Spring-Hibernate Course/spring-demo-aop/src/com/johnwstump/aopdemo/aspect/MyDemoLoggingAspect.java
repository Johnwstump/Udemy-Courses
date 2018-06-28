package com.johnwstump.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.johnwstump.aopdemo.Account;
import com.johnwstump.aopdemo.Member;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.johnwstump.aopdemo.aspect.AOPExpressions.DAOPackageNotGetterOrSetter()")
	public void beforeAddAcountAdvice(JoinPoint joinPoint) {
		System.out.println("\n --->> Executing @Before advice with order 1");
		System.out.println("Retrieving method signature from joinpoint:");
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + signature);
	}
	
	
	@AfterReturning(pointcut ="execution(* com.johnwstump.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		System.out.println("\n --->> Executing @AfterReturning advice");
		String signature = joinPoint.getSignature().toShortString();
		System.out.println("Method: " + signature);
		
		System.out.println("Modifying return value: ");
		System.out.println("Return value is: " + result);
		convertAccountNamesToUpper(result);	
		System.out.println("After Modification return value is: " + result);
	}
	
	@AfterThrowing(pointcut ="execution(* com.johnwstump.aopdemo.dao.MembershipDAO.findMembers(..))", throwing="exception")
	public void afterThrpwomgFindAccountAdvice(JoinPoint joinPoint, Throwable exception) {
		System.out.println("Logging exception: " + exception.getMessage());
	}
	
	private void convertAccountNamesToUpper(List<Account> result) {
		for (Account a : result) {
			Member m = a.getMember();
			m.setFirstName(m.getFirstName().toUpperCase());
		}
	}
	
}
