/**
 * 描述: 
 * JdkTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.jdk;

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

import org.junit.Ignore;
import org.junit.Test;

import com.hua.constant.sys.UserType;
import com.hua.test.BaseTest;


/**
 * 描述: Java Develope Kit - 测试
 * 
 * @author qye.zheng
 * JdkTest
 */
public final class JdkTest extends BaseTest {

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
	public void testJdk() {
		try {
			
			
		} catch (Exception e) {
			log.error("testJdk =====> ", e);
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
			int[] arr = null;
			int a = arr.length;
			System.out.println(Math.round(11.5) + "," + Math.round(-11.5));
			// short s1 = 1; s1 += 1;
			//short s1 = 1; s1 = (short) (s1 + Short.valueOf("1").shortValue());
			// 错误
			//short s1 = 1; s1 = s1 + Short.valueOf("1").shortValue();
			//short s1 = 1; s1 = s1 + 2;
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
			// switch支持 byte/short/char/int/enum/String
			//byte b = 1;
			//long b = 1;
			//int b = 1;
			//b += 1;
			//short b =1;
			//char b = 'd';
			//String b = null;
			//Object b = null;
			//double b = 1.0;
			//float b = 1.0F;
			UserType b = null;
			char c = '海';
			switch (b) {
			
			}
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	abstract class A {
		abstract Object  a1();
		native void  a2();
		native synchronized void  a3();
		// Default methods are allowed only in 
		//default void b() {
		//}
		
	}
	
	
	abstract class B extends A {
		
		//final int i;
		
		{
			//i = 10;
		}
		
		public B () {
			this(1);
			//i = 11;
			int i = 10;
		}
		
		public B (int i) {
			
		}
		
		@Override
		String a1()
		{
			return "a";
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
