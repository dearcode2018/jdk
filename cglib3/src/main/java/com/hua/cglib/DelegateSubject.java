/**
 * DelegateSubject.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.cglib;

/**
 * DelegateSubject
 * 描述: 委托类 (被代理对象的类)
 * @author  qye.zheng
 */
public class DelegateSubject
{

	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @param key
	 * @return
	 */
	
	public String open(final Integer key)
	{
		System.out.println("DelegateSubject.open()");
		final String result = "key: " + key;
		
		return result;
	}

	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @param name
	 * @return
	 */
	
	public int status(final String name)
	{
		System.out.println("DelegateSubject.status()");
		final int status = name.hashCode();
		
		return status;
	}

	/**
	 * 描述: 
	 * @author  qye.zheng
	 */
	
	public void close()
	{
		System.out.println("DelegateSubject.close()");
	}

}
