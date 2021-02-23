/**
 * 描述: 
 * JdkProxyTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.jdk;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.lang.reflect.Proxy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.proxy.DynamicProxyHelper;
import com.hua.proxy.OneCommonInvocationHandler;
import com.hua.target.CarFactory;
import com.hua.target.IBuyService;
import com.hua.target.IFactory;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * JdkProxyTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class JdkProxyTest extends BaseTest {

	public static void main(String[] args) {
		// 生成代理类的字节码，在工程根目录下可以看，只能在main方法下执行才有效，junit方法不能看
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
		// 原生对象
		Object originalFactory = new CarFactory();
		
		IFactory proxyFactory = (IFactory) DynamicProxyHelper.newProxy(originalFactory);
		proxyFactory.manufacture(123);
		
		/*
		 * 1) 实现了参数interfaces所有的接口，且继承了java.lang.reflect.Proxy
		 * 2) 使用父类的构造函数 Proxy(InvocationHandler) 构造一个代理类的实例
		 * 3) 
		 */
		assertTrue(proxyFactory.getClass().getSuperclass() == Proxy.class);
		
		IBuyService proxyBuy = (IBuyService) DynamicProxyHelper.newProxy(originalFactory);
		proxyBuy.buy(12, 20311.22);
		
		assertTrue(proxyFactory != proxyBuy);
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testJdkProxy() {
		try {
			// 原生对象
			IFactory originalFactory = new CarFactory();
			// 代理之后的对象
			//IFactory proxyFactory = (IFactory) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[] {IFactory.class}, new OneCommonInvocationHandler(originalFactory));
			IFactory proxyFactory = (IFactory) Proxy.newProxyInstance(originalFactory.getClass().getClassLoader(), originalFactory.getClass().getInterfaces(), new OneCommonInvocationHandler(originalFactory));
			assertTrue(originalFactory != proxyFactory);
			//originalFactory.manufacture(123);
			proxyFactory.manufacture(123);
			
		} catch (Exception e) {
			log.error("testJdkProxy =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testDynamicProxyHelper() {
		try {
			// 原生对象
			CarFactory originalFactory = new CarFactory();
			
			IFactory proxyFactory = DynamicProxyHelper.newProxy((IFactory) originalFactory);
			proxyFactory.manufacture(123);
			
			IBuyService proxyBuy = DynamicProxyHelper.newProxy((IBuyService) originalFactory);
			proxyBuy.buy(12, 20311.22);
			
			assertTrue(proxyFactory != proxyBuy);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testDynamicProxyHelper2() {
		try {
			// 原生对象
			Object originalFactory = new CarFactory();
			
			IFactory proxyFactory = (IFactory) DynamicProxyHelper.newProxy(originalFactory);
			proxyFactory.manufacture(123);
			
			/*
			 * 1) 实现了参数interfaces所有的接口，且继承了java.lang.reflect.Proxy
			 * 2) 使用父类的构造函数 Proxy(InvocationHandler) 构造一个代理类的实例
			 * 3) 每个代理的方法中用 InvocationHandler调用invoke(Object this, Method, Object[] params)方法 (反编译代理.class可看到)
			 */
			assertTrue(proxyFactory.getClass().getSuperclass() == Proxy.class);
			
			IBuyService proxyBuy = (IBuyService) DynamicProxyHelper.newProxy(originalFactory);
			proxyBuy.buy(12, 20311.22);
			
			assertTrue(proxyFactory != proxyBuy);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testTemp")
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
	@DisplayName("testCommon")
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
	@DisplayName("testSimple")
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
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
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
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
		dynamicTest(null, null);
		
		assumeFalse(false);
		assumeTrue(true);
		assumingThat(true, null);
	}

}
