/**
 * 描述: 
 * BaseTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test;

// 静态导入
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.hua.entity.User;
import com.hua.log.BaseLog;

/**
 * 描述: 测试基类
 * 包含多个测试示例
 * 
 * @author qye.zheng
 * BaseTest
 */
//@RunWith()
public class BaseTest extends BaseLog {
	
	public String result;
	
	public static String className = User.class.getName();
	
	public static Class<?> clazz;
	
	public Class<?> superClazz;
	
	public Class<?>[] interfaces;
	
	public Field[] fields;
	
	public Field field;
	
	public Constructor<?>[] constructors;
	
	public Constructor<?> constructor;
	
	public Method[] methods;
	
	public Method method;
	
	public Object object;
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
		try
		{
			// 加载指定类
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}

}
