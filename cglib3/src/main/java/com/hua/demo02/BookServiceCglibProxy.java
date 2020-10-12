/**
  * @filename BookServiceCglibProxy.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.demo02;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

 /**
 * @type BookServiceCglibProxy
 * @description 
 * @author qianye.zheng
 */
public class BookServiceCglibProxy implements MethodInterceptor
{
	
	private Enhancer enhancer = new Enhancer();
	
	private String name;
	
	/**
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	public BookServiceCglibProxy(final String name)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @description 
	 * @param superClass
	 * @return
	 * @author qianye.zheng
	 */
	public Object getPoxyObject(final Class<?> superClass)
	{
		enhancer.setSuperclass(superClass);
		// 回调对象为当前对象
		enhancer.setCallback(this);
		
		return enhancer.create();
	}

	/**
	 * @description 
	 * @param proxyedObj 被代理的对象
	 * @param proxyedMethod 被代理的方法
	 * @param args 参数
	 * @param proxy 方法代理对象
	 * @return
	 * @throws Throwable
	 * @author qianye.zheng
	 */
	@Override
	public Object intercept(final Object proxyedObj, final Method proxyedMethod, final Object[] args,
			final MethodProxy proxy) throws Throwable
	{
		System.out.println("调用的方法是: " + proxyedMethod.getName());
		if (!"admin".equals(name))
		{
			System.out.println("没有权限");
			
			return null;
		}
		// 调用父类的方法并获取方法的返回值
		final Object result = proxy.invokeSuper(proxyedObj, args);
		
		return result;
	}

}
