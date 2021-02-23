/**
  * @filename OneCommonInvocationHandler.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @type OneCommonInvocationHandler
 * @description 一个具有公共拦截逻辑的调用处理器
 * 凡是拦截逻辑相同的都可以使用此处理器
 * @author qianye.zheng
 */
public class OneCommonInvocationHandler implements InvocationHandler {

	private Object delegate;
	
	/**
	 * @description 构造方法
	 * @param delegate
	 * @author qianye.zheng
	 */
	public OneCommonInvocationHandler(Object delegate) {
		super();
		this.delegate = delegate;
	}

	/**
	 * @description 
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 * @author qianye.zheng
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// before call
		System.out.println("before call");
		final Object result = method.invoke(delegate, args);
		// after call
		System.out.println("after call");
		
		return result;
	}

}
