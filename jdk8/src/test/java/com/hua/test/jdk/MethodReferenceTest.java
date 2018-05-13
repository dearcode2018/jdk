/**
 * 描述: 
 * MethodReferenceTest.java
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

import java.io.PrintStream;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.User;
import com.hua.test.BaseTest;


/**
 * 描述: 方法引用
 * 
 * @author qye.zheng
 * MethodReferenceTest
 */
public final class MethodReferenceTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMethodRef() {
		try {
			PrintStream ps1 = System.out;
			Consumer<String> con1 = (x) -> ps1.println(x);
			
			PrintStream ps = System.out;
			Consumer<String> con2 = ps :: println;
			con2.accept("ps");
			
			User user = new User();
			user.setNickname("haha");
			Supplier<String> sup = () -> user.getNickname();
			System.out.println(sup.get());
			Supplier<String> sup2 = user :: getNickname;
			System.out.println(sup2.get());
			
			Supplier<Double> sup3 = Math :: random;
			System.out.println(sup3.get());
			
			/*
			 * 对象 :: 实例方法名
			 * 类 :: 实例方法名
			 */
			BiPredicate<String, String> biP = (x, y) -> x.equals(y);
			// 2个变量，第一个变量的方法是实例方法的调用者，第二个变量是实例方法的参数 即可采用 类 :: 实例方法
			BiPredicate<String, String> biP2 = String :: equals;
			
		} catch (Exception e) {
			log.error("testMethodRef =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMethodRefConstructor() {
		try {

			// 构造器引用 - 无参
			Supplier<User> sup1 = () -> new User(); // 常规方式
			Supplier<User> sup2 = User :: new; // 构造器引用

			/*
			 * 构造器引用 - 有参
			 * 调用哪个构造方法，取决于函数式接口的方法的参数
			 */
			Function<String, User> fun1 = (x) -> new User(x); // 常规方式
			User user1 = fun1.apply("hehe");
			log.info("testMethodRefConstructor =====> " + user1.getUsername());
			Function<String, User> fun2 = User :: new;
			User user2 = fun2.apply("哈哈");
			log.info("testMethodRefConstructor =====> " + user2.getUsername());			
		} catch (Exception e) {
			log.error("testMethodRefConstructor =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMethodRefArray() {
		try {
			Function<Integer, String[]> fun1 = (x) -> new String[x];
			String[] strs1 = fun1.apply(10);
			
			Function<Integer, String[]> fun2 = String[] :: new;
			String[] strs2 = fun2.apply(10);
			
		} catch (Exception e) {
			log.error("testMethodRefArray =====> ", e);
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
