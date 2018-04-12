/**
  * @filename SubjectProxy.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

 /**
 * @type SubjectProxy
 * @description 
 * @author qye.zheng
 */
public class SubjectProxy implements MethodInterceptor {

	/* 委托对象 */
	private Object delegate;
	
	/**
	 * 
	 * @description 构造方法
	 * @param delegate
	 * @author qye.zheng
	 */
	public SubjectProxy(Object delegate) {
		super();
		this.delegate = delegate;
	}

	/**
	 * 
	 * @description 获取代理对象
	 * @return
	 * @author qye.zheng
	 */
	public Object getProxy()
	{
		// 增强对象
		Enhancer enhancer = new Enhancer();
		// 设置代理兑现的父类 为 委托类
		enhancer.setSuperclass(delegate.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		Object proxy = enhancer.create();
		
		return proxy;
	}
	
	/**
	 * @description 
	 * @param obj
	 * @param method
	 * @param args
	 * @param proxy
	 * @return
	 * @throws Throwable
	 * @author qye.zheng
	 */
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("SubjectProxy.intercept 调用前");
		
		// 拦截过滤调用 (调用父类 - 委托类对象)
		Object result = proxy.invokeSuper(obj, args);
		
		System.out.println("SubjectProxy.intercept 调用后");
		
		return result;
	}

}
