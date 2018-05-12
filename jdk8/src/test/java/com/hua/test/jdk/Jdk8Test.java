/**
 * 描述: 
 * Jdk8Test.java
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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.common.MyPredicate;
import com.hua.common.Operation;
import com.hua.entity.User;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * Jdk8Test
 */
public final class Jdk8Test extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testType() {
		try {
			/*
			 * 类型推断
			 */
			// 右侧无需声明类型
			List<Integer> list = new ArrayList<>();
			
			
		} catch (Exception e) {
			log.error("testType =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLambdaExpress() {
		try {
			/*
			 * Lambda表达式
			 */
			Comparator<Integer> comp = (x, y) -> Integer.compare(x, y);
			
			// 多条语句
			Comparator<Integer> comp2 = (x, y) -> {
				System.out.println("hha");
				// 返回值
				return Integer.compare(x, y);
			};
			
			Comparator<Integer> comp3 = (x, y) -> {return Integer.compare(x, y);};
			
			// 参数类型若声明一个，其他的也要声明；否则可以全部不写
			Comparator<Integer> comp4 = (Integer x, Integer y) -> {return Integer.compare(x, y);};
			//Comparator<Integer> comp = null;
			
			
		} catch (Exception e) {
			log.error("testLambdaExpress =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLambdaExpress2() {
		try {
			/*
			 * Lambda表达式
			 */
			List<User> users = new ArrayList<User>();
			User e = null;
			
			e = new User();
			e.setNickname("a");
			e.setValid(false);
			users.add(e);
			
			e = new User();
			e.setNickname("b");
			e.setValid(true);
			users.add(e);
			
			e = new User();
			e.setNickname("c");
			e.setValid(false);
			users.add(e);
			
			List<User> result = find(users, (x) -> x.isValid());
			for (User e2 : result)
			{
				System.out.println(e2.getNickname());
			}
			
			
			//Comparator<Integer> comp = null;
			
			
		} catch (Exception e) {
			log.error("testLambdaExpress2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLambdaExpress3() {
		try {
			/*
			 * Lambda表达式
			 * stream api
			 */
			List<User> users = new ArrayList<User>();
			User e = null;
			
			e = new User();
			e.setNickname("a");
			e.setValid(false);
			users.add(e);
			
			e = new User();
			e.setNickname("b");
			e.setValid(true);
			users.add(e);
			
			e = new User();
			e.setNickname("c");
			e.setValid(false);
			users.add(e);
			
			//users.stream().filter((x) -> x.isValid()).forEach(System.out::println);
			users.stream().filter((x) -> x.isValid()).forEach((x) -> System.out.println(x.getNickname()));
			users.stream().filter((x) -> x.isValid()).limit(2).forEach((x) -> System.out.println(x.getNickname()));
			users.stream().filter((x) -> x.isValid()).limit(2).map(User :: getNickname).forEach(System.out::println);
			//Comparator<Integer> comp = null;
			
			
		} catch (Exception e) {
			log.error("testLambdaExpress3 =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param users
	 * @param predicate
	 * @return
	 * @author qianye.zheng
	 */
	public List<User> find(final List<User> users, final MyPredicate predicate)
	{
		List<User> result = new ArrayList<User>();
		for (User e : users)
		{
			if (predicate.test(e))
			{
				result.add(e);
			}
		}
		
		return result;
	}
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLambda4() {
		try {
			Integer number = operation(10, (x) -> x * 10);
			log.info("testLambda4 =====> " + number);
			
			
		} catch (Exception e) {
			log.error("testLambda4 =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param number
	 * @param operation
	 * @return
	 * @author qianye.zheng
	 */
	public Integer operation(final Integer number, final Operation<Integer> operation)
	{
		
		return operation.getValue(number);
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
