package com.johnwstump.aopdemo.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
		System.out.println("\n--->> Executing @Before advice with order 1");
		System.out.println("Retrieving method signature from joinpoint:");
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + signature);
	}
	
	@After("com.johnwstump.aopdemo.aspect.AOPExpressions.DAOPackageNotGetterOrSetter()")
	public void afterAddAcountAdvice(JoinPoint joinPoint) {
		System.out.println("--->> Executing @After advice");
	}
	
	@AfterReturning(pointcut ="execution(* com.johnwstump.aopdemo.dao.AccountDAO.findAccounts(..))", returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {
		System.out.println("\n--->> Executing @AfterReturning advice");
		String signature = joinPoint.getSignature().toShortString();
		System.out.println("Method: " + signature);
		
		System.out.println("Modifying return value: ");
		System.out.println("Return value is: " + result);
		convertAccountNamesToUpper(result);	
		System.out.println("After Modification return value is: " + result);
	}
	
	@AfterThrowing(pointcut ="execution(* com.johnwstump.aopdemo.dao.MembershipDAO.findMembers(..))", throwing="exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exception) {
		System.out.println("Logging exception: " + exception.getMessage());
	}
	
	private void convertAccountNamesToUpper(List<Account> result) {
		for (Account a : result) {
			Member m = a.getMember();
			m.setFirstName(m.getFirstName().toUpperCase());
		}
	}
	
	@Around("execution(* com.johnwstump.aopdemo.dao.MembershipDAO.addMember(..))")
	public Object aroundFindAccountAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("\n--->> Executing @Around advice");
		Object result;
		
		try {
			result = joinPoint.proceed();
		}
		catch (Exception ex){
			System.out.println("Exception caught. Setting default return");
			result = new Boolean(false);
		}
		
		return result;
	}
}
