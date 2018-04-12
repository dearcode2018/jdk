/**
 * ExceptionHandler.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.exception;



/**
 * ExceptionHandler
 * 描述: 
 * @author  qye.zheng
 */
public final class ExceptionHandler
{

	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @throws StartException
	 */
	public void start() throws StartException
	{
		/*
		 调用其他方法，捕获相应的异常，然后再用该异常对象
		 封装为新异常，然后再抛出
		 */
		System.out.println("ExceptionHandler.start()");
		try
		{
			first();
		} catch (FirstException e)
		{
			final StartException startException = new StartException("start exception", e);
			
			throw startException;
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @throws FirstException
	 */
	public void first() throws FirstException
	{
		/*
		 调用其他方法，捕获相应的异常，然后再用该异常对象
		 封装为新异常，然后再抛出
		 */
		System.out.println("ExceptionHandler.first()");
		try
		{
			second();
		} catch (SecondException e)
		{
			final FirstException firstException = new FirstException("first exception", e);
			
			throw firstException;
		}

	}
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @throws SecondException
	 */
	public void second() throws SecondException
	{
		System.out.println("ExceptionHandler.second()");
		final SecondException secondException = new SecondException("second exception");
		
		throw secondException;
	}
	
}
