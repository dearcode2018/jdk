/**
 * 描述: 
 * ReflectTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.reflect;

// 静态导入
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.User;
import com.hua.test.BaseTest;


/**
 * 描述: 反射 - 测试
 * 
 * @author qye.zheng
 * ReflectTest
 */
public final class ReflectTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReflect() {
		try {
			
			
		} catch (Exception e) {
			log.error("testReflect =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testModifier() {
		try {
			int modifier = clazz.getModifiers();
			log.info("testModifier =====> modifier =" + modifier);
			
			// 输出类修饰符 Modifier.toString(int)
			result = Modifier.toString(modifier);
			System.out.println(result);
			
		} catch (Exception e) {
			log.error("testModifier =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testField() {
		try {
			/*
			 获取所有字段
			 或者根据字段名称，或者字段
			 getField(String)
			 */
			/*
			 获取包括所有父类(直到Object类)在内的所有public静态或实例属性
			 如果一个类及其父类的属性是private/protected/default
			 的属性则无法列出
			 */
			fields = clazz.getFields();
			log.info("testField =====> " + fields.length);
			for (int i = 0; i < fields.length; i++)
			{
				field = fields[i];
				System.out.print(field.getName() + ", ");
			}
			System.out.println();
			
		} catch (Exception e) {
			log.error("testField =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeclaredField() {
		try {
			/*
			 获取一个类所有声明的属性，只要是该类声明的，
			 无论任何权限，都可以获取到.
			 */
			fields = clazz.getDeclaredFields();
			log.info("testDeclaredField =====> " + fields.length);
			for (int i = 0; i < fields.length; i++)
			{
				field = fields[i];
				System.out.print(field.getName() + ", ");
			}
			System.out.println();
			
		} catch (Exception e) {
			log.error("testDeclaredField =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testConstructor() {
		try {
			constructors = clazz.getConstructors();
			for (int i = 0; i < constructors.length; i++)
			{
				constructor = constructors[i];
				System.out.print(constructor.getParameterTypes().length + ", ");
			}
			System.out.println();
			
			// 根据构造方法的参数，获取指定的构造方法
			// 获取无参构造方法
			constructor = clazz.getConstructor();
			// 获取指定的参数的构造方法
			constructor = clazz.getConstructor(String.class, String.class);
			
		} catch (Exception e) {
			log.error("testConstructor =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMethod() {
		try {
			
			/*
			 获取包括父类(直到Object类)在内的public静态或实例方法
			 */
			methods = clazz.getMethods();
			for (int i = 0; i < methods.length; i++)
			{
				method = methods[i];
				System.out.print(method.getName() + ", ");
			}
			System.out.println();
			
		} catch (Exception e) {
			log.error("testMethod =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDeclaredMethod() {
		try {
			/*
			 获取类声明的所有方法
			 */
			methods = clazz.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++)
			{
				method = methods[i];
				System.out.print(method.getName() + ", ");
			}
			System.out.println();
			
		} catch (Exception e) {
			log.error("testDeclaredMethod =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testParent() {
		try {
			// 获取直接父类
			superClazz = clazz.getSuperclass();
			
			log.info("testParent =====> " + superClazz.getName());
			
		} catch (Exception e) {
			log.error("testParent =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInterface() {
		try {
			/*
			 获取当前类实现的接口，不包括父类实现的接口(这点需要注意)
			 */
			interfaces = clazz.getInterfaces();
			Class<?> c = null;
			for (int i = 0; i < interfaces.length; i++)
			{
				c = interfaces[i];
				System.out.println(c.getName() + ", ");
			}
		} catch (Exception e) {
			log.error("testInterface =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSetValue() {
		try {
			/*
			 获取一个类所有声明的属性，只要是该类声明的，
			 无论任何权限，都可以获取到.
			 给指定的属性设置值
			 */
			/*
			 注意: 操作属性，是针对一个存在的对象去操作的，
			 而不是操作一个类，这点需要特别清醒.
			 操作属性: 
			① 首先设置可以访问
			setAccessible(true)
			② 针对指定对象，设定该属性值 
			set(Object, Object value)
			③ 针对指定对象，获取该属性值
			get(obj)
			 */
			// 实例对象，一会针对该对象操作其属性
			User user = new User();
			user.setOid(201333L);
			user.setUsername("zhangsan");
			user.setNickname("天河公园");
			user.setPassword("88888888");
			String fieldName = "username";
			fields = clazz.getDeclaredFields();
			log.info("testSetValue =====> " + fields.length);
			for (int i = 0; i < fields.length; i++)
			{
				field = fields[i];
				if (fieldName.equals(field.getName()))
				{
					// 给指定的属性设置值
					// 设置为可以访问(若不设置，则访问将抛异常)
					/*
					 java.lang.IllegalAccessException: Class com.hua.test.reflect.ReflectTest can not access a 
					 member of class com.hua.entity.User with modifiers "private"
					 */
					field.setAccessible(true);
					// 获取属性值
					log.info("testSetValue =====> getValue = " + field.get(user));
					
					// 设置属性
					field.set(user, "lisi");
					log.info("testSetValue =====> getValue = " + field.get(user));
				}
			}
			
		} catch (Exception e) {
			log.error("testSetValue =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testInvoke() {
		try {
			/*
				针对某个对象的某个方法执行调用
				细节问题: 调用权限/静态或实例方法/
				方法参数/返回值接收
				
				Object invoke(Object obj, Object... params)
			 */
			// 实例对象，一会针对该对象操作其方法
			User user = new User();
			user.setOid(201333L);
			user.setUsername("zhangsan");
			user.setNickname("天河公园");
			user.setPassword("88888888");
			String methodName = "privateStringMethod";
			// 参数
			Object paramOne = null;
			Object paramTwo = null;
			// 返回值
			Object returnObject = null;
			/*
			 获取类声明的所有方法
			 */
			methods = clazz.getDeclaredMethods();
			for (int i = 0; i < methods.length; i++)
			{
				method = methods[i];
				if (methodName.equals(method.getName()))
				{
					// 设置方法可访问 (防止私有方法无法访问)
					method.setAccessible(true);
					paramOne = new Integer(1);
					paramTwo = "two";
					// 操作指定的方法
					returnObject = method.invoke(user, paramOne, paramTwo);
					// 方法返回值
					log.info("testInvoke =====> returnObject = " + returnObject);
				}
			}
			
		} catch (Exception e) {
			log.error("testInvoke =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNewInstance() {
		try {
			/*
			 通过 newInstance() 方法构造对象，要求
			 目标类必须提供一个默认的构造方法
			 */
			object = clazz.newInstance();
			// 强转为指定类型
			if (object instanceof User)
			{
				User user = (User) object;
				log.info("testNewInstance =====> " + user.getUsername());
			}
				
			
			
		} catch (Exception e) {
			log.error("testNewInstance =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 普通测试方法
	 ,@Test注解 不带参数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNormal() {
		System.out.println("testNormal()");
	}
	
	/**
	 * 
	 * 描述: 期望发生异常-测试方法
	 ,@Test注解 异常
	 * @author qye.zheng
	 * 
	 */
	@Test(expected=NullPointerException.class)
	@SuppressWarnings("all")
	public void testException() {
		String str = null;
		System.out.println(str.length());
	}
	
	/**
	 * 
	 * 描述: 超时测试方法
	 ,@Test注解 指定运行时间 (单位 : 毫秒)
	 * @author qye.zheng
	 * 
	 */
	@Test(timeout=3000)
	public void testTimeOut() {
		System.out.println("testTimeOut()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Ignore("暂时忽略的方法")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@After
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@Ignore("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(message, expecteds, actuals);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(message, true);
		assertTrue(message, true);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(message, expecteds, actuals);
		assertNotSame(message, expecteds, actuals);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(message, actuals);
		assertNotNull(message, actuals);
		
		assertThat(null, null);
		assertThat(null, null, null);
		
		fail();
		fail("Not yet implemented");
		
	}

}
