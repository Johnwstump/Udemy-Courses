package com.johnwstump.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

	@Pointcut("execution(* com.johnwstump.aopdemo.dao.*.*(..))")
	public void forDAOPackage() {}
	
	@Pointcut("execution(* get*(..))")
	public void isGetter() {}
	

	@Pointcut("execution(* set*(..))")
	public void isSetter() {}
	
	@Pointcut("forDAOPackage() && !(isSetter() || isGetter())")
	public void DAOPackageNotGetterOrSetter() {}
	
	@Pointcut("execution(* com.johnwstump.aopdemo.dao.AccountDAO.* (..))")
	public void inAccountDAO() {}
}
