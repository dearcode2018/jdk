/**
 * 描述: 
 * MethodAreaOutOfMemory.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.vm;

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

import java.lang.reflect.Method;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MethodAreaOutOfMemory
 */
public final class MethodAreaOutOfMemory extends BaseTest {

	
	/**
	 * 
	 * @description 方法区内存溢出
	 * -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=10M
	 * @param args
	 * @author qianye.zheng
	 */
	public static void main(String[] args)
	{
		int i = 0;
		try
		{
			while (true)
			{
				i++;
				Enhancer enhancer = new Enhancer();
				enhancer.setSuperclass(BaseTest.class);
				enhancer.setUseCache(false);
				enhancer.setCallback(new MethodInterceptor () {
					
					/**
					 * @description 
					 * @param obj
					 * @param method
					 * @param args
					 * @param proxy
					 * @return
					 * @throws Throwable
					 * @author qianye.zheng
					 */
					@Override
					public Object intercept(Object obj, Method method, Object[] args,
							MethodProxy proxy) throws Throwable
					{
						return proxy.invokeSuper(obj, args);
					}
				});
				enhancer.create();
			}
		} catch (Exception e)
		{
			System.out.println("excepton happen in: " + i);
			e.printStackTrace();
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
