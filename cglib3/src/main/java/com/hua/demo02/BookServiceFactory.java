/**
  * @filename BookServiceFactory.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.demo02;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

 /**
 * @type BookServiceFactory
 * @description 
 * @author qianye.zheng
 */
public class BookServiceFactory
{
	
	private static final BookService service = new BookServiceImpl();
	
	/**
	 * 
	 * @description 构造方法
	 * @author qianye.zheng
	 */
	private BookServiceFactory()
	{
	}
	
	/**
	 * 
	 * @description 获取实例
	 * @return
	 * @author qianye.zheng
	 */
	public static final BookService getInstance()
	{
		return service;
	}
	
	/**
	 * 
	 * @description 
	 * @param cglibProxy
	 * @return
	 * @author qianye.zheng
	 */
	public static final BookService getInstance(final BookServiceCglibProxy cglibProxy)
	{
		// 返回生成代理实例
		return (BookService) cglibProxy.getPoxyObject(BookService.class);
	}
	
	/**
	 * 
	 * @description 
	 * @param cglibProxy
	 * @return
	 * @author qianye.zheng
	 */
	public static final BookService getAuthInstance(final BookServiceCglibProxy cglibProxy)
	{
		final Enhancer enhancer = new Enhancer();
		// 设置被代理对象
		enhancer.setSuperclass(BookServiceImpl.class);
		/*
		 * 设置多个回调(代理)，代理数组，其下标和callbackFilter.accept()返回值一一对应
		 * 表示使用哪个回调
		 */
		enhancer.setCallbacks(new Callback[] {NoOp.INSTANCE, cglibProxy});
		// 使用代理数组就必须指定回调拦截器
		enhancer.setCallbackFilter(new BookServiceCglibProxyFilter());
		
		// 生成代理实例
		final BookService service = (BookService) enhancer.create();
		
		return service;
	}
}
