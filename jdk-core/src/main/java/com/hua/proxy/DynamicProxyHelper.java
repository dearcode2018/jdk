/**
  * @filename DynamicProxyHelper.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.proxy;

import java.lang.reflect.Proxy;

import com.hua.target.IBuyService;
import com.hua.target.IFactory;

/**
 * @type DynamicProxyHelper
 * @description 
 * @author qianye.zheng
 */
public class DynamicProxyHelper {
	
	/**
	 * 
	 * @description 
	 * @param original
	 * @return
	 * @author qianye.zheng
	 */
	public static final IFactory newProxy(final IFactory original) {
		// original.getClass().getInterfaces() 传入该参数起始已经是生成所有接口的对象
		return (IFactory) Proxy.newProxyInstance(original.getClass().getClassLoader(), original.getClass().getInterfaces(), new OneCommonInvocationHandler(original));
	}
	
	/**
	 * 
	 * @description 
	 * @param original
	 * @return
	 * @author qianye.zheng
	 */
	public static final IBuyService newProxy(final IBuyService original) {
		return (IBuyService) Proxy.newProxyInstance(original.getClass().getClassLoader(), original.getClass().getInterfaces(), new OneCommonInvocationHandler(original));
	}
	
	/**
	 * 
	 * @description 生成基于目标所有接口的对象
	 * @param original
	 * @return
	 * @author qianye.zheng
	 */
	public static final Object newProxy(final Object original) {
		return Proxy.newProxyInstance(original.getClass().getClassLoader(), original.getClass().getInterfaces(), new OneCommonInvocationHandler(original));
	}
}
