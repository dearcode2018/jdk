/**
  * @filename MyAspect.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

 /**
 * @type MyAspect
 * @description 
 * @author qye.zheng
 */
// 声明一个切面
@Aspect
public class MyAspect {
	
	private static final String expression = "execution(* com.hua.service.**.*(..))";
	
	// 切入点
	// @Pointcut(value = "execution(* com.hua.service.**.*(..)) && execution(* com.hua.dao.**.*(..))")
	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	@Pointcut(value = expression)
	public void beforePointcut()
	{
		System.out.println("MyAspect.beforePointcut()");
	}
	
	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	@Pointcut(value = expression)
	public void afterPointcut()
	{
		System.out.println("MyAspect.afterPointcut()");
	}

	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	@Pointcut(value = expression)
	public void aroundPointcut()
	{
		System.out.println("MyAspect.aroundPointcut()");
	}

	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	@Pointcut(value = expression)
	public void afterThrowingPointcut()
	{
		System.out.println("MyAspect.aroundThrowingPointcut()");
	}
	
	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	@Pointcut(value = expression)
	public void afterReturningPointcut()
	{
		System.out.println("MyAspect.afterReturningPointcut()");
	}
	
	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	// 指定增强(切入点)
	@Before(value = "beforePointcut()")
	public void before(final JoinPoint point)
	{
		
	}
	
	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	@After(value = "afterPointcut()")
	public void after(final JoinPoint point)
	{
		
	}

	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	@Around(value = "aroundPointcut()")
	public void around(final ProceedingJoinPoint point)
	{
		
	}
	
	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	@AfterThrowing(pointcut = "afterThrowingPointcut()", throwing = "e")
	public void afterThrowing(final JoinPoint point, final Throwable e)
	{
		
	}
	
	/**
	 * 
	 * @description 
	 * @author qye.zheng
	 */
	@AfterReturning(pointcut = "afterReturningPointcut()", returning = "ret")
	public void afterReturning(final JoinPoint point, final Object ret)
	{
		
	}
}
