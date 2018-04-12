/**
  * @filename BookServiceCglibProxyFilter.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.demo03;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

 /**
 * @type BookServiceCglibProxyFilter
 * @description 
 * @author qianye.zheng
 */
public class BookServiceCglibProxyFilter implements CallbackFilter
{

	/**
	 * @description 
	 * @param method 被代理的方法
	 * @return 返回值 对应 Enhancer.setCallbacks(new Callback[] {}); 数组里面的一一对应
	 * 代表执行哪个代理，NoOp.INSTANCE 表示不执行代理，放行的方法需要和此对应
	 * @author qianye.zheng
	 */
	public int accept(Method method)
	{
		// 过滤掉某些方法
		if ("query".equalsIgnoreCase(method.getName()))
		{ // query 方法放行
			
			return 0;
		}
		
		return 1;
	}

}
