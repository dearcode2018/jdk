/**
 * 描述: 
 * OptionalTest.java
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

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.User;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * OptionalTest
 */
public final class OptionalTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOptional() {
		try {
			User user = new User();
			user.setNickname("haha");
			Optional<User> optional = Optional.of(user);
			
			System.out.println(optional.get().toString());
			
			// java.lang.NullPointerException
			optional = Optional.of(null);
			System.out.println(optional.get().toString());
			
		} catch (Exception e) {
			log.error("testOptional =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testEmpty() {
		try {
			Optional<User> optional = Optional.empty();
			
			//判断是否存在
			System.out.println(optional.isPresent());
			/*
			 * java.util.NoSuchElementException: No value present
			 */
			System.out.println(optional.get().toString());
		} catch (Exception e) {
			log.error("testEmpty =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOrElse() {
		try {
			Optional<User> optional = Optional.empty();
			/*
			 * 为空则取指定值
			 * 符合条件则返回指定的值，对原来Optional对象没有影响
			 */
			User newUser = optional.orElse(new User());
			//判断是否存在
			System.out.println(optional.isPresent());
			/*
			 * java.util.NoSuchElementException: No value present
			 */
			System.out.println(optional.get().toString());
			
			System.out.println(newUser.toString());
			
		} catch (Exception e) {
			log.error("testOrElse =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOfNullable() {
		try {
			Optional<User> optional = Optional.ofNullable(null);
			/*
			 * 为空则取指定值
			 * 符合条件则返回指定的值，对原来Optional对象没有影响
			 */
			User newUser = optional.orElse(new User());
			//判断是否存在
			System.out.println(optional.isPresent());
			/*
			 * java.util.NoSuchElementException: No value present
			 */
			System.out.println(optional.get().toString());
			
			System.out.println(newUser.toString());
			
		} catch (Exception e) {
			log.error("testOfNullable =====> ", e);
		}
	}
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testOrElseGet() {
		try {
			Optional<User> optional = Optional.ofNullable(null);
			User user = optional.orElseGet(() -> new User());
			System.out.println(user.toString());
			
		} catch (Exception e) {
			log.error("testOrElseGet =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMap() {
		try {
			User user = new User();
			user.setNickname("haha");
			Optional<User> optional = Optional.of(user); 
			Optional<String> nameOptional = optional.map((x) -> x.getNickname());
			log.info("testMap =====> " + nameOptional.get());
			
		} catch (Exception e) {
			log.error("testMap =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFlatMap() {
		try {
			User user = new User();
			user.setNickname("haha");
			Optional<User> optional = Optional.of(user); 
			// flagMap 需要再返回 Optional
			Optional<String> nameOptional = optional.flatMap((x) -> Optional.of(x.getNickname()));
			log.info("testFlatMap =====> " + nameOptional.get());
			
		} catch (Exception e) {
			log.error("testFlatMap =====> ", e);
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
