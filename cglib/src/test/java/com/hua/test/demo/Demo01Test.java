/**
 * 描述: 
 * Demo01Test.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.demo;

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

import com.hua.demo01.BookService;
import com.hua.demo01.BookServiceCglibProxy;
import com.hua.demo01.BookServiceFactory;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * Demo01Test
 */
public final class Demo01Test extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testDemo01() {
		try {
			BookService service = BookServiceFactory.getInstance();
		
			// 方法调用
			service.create();
			service.delete();
			service.update();
			service.query();

		} catch (Exception e) {
			log.error("testDemo01 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCglibProxy01() {
		try {
			BookServiceCglibProxy cglibProxy = null;
			BookService service = null;
			
			cglibProxy = new BookServiceCglibProxy("haha");
			service = BookServiceFactory.getInstance(cglibProxy);
			// 方法调用
			service.create();
			service.delete();
			service.update();
			service.query();
			
			cglibProxy = new BookServiceCglibProxy("admin");
			service = BookServiceFactory.getInstance(cglibProxy);
			// 方法调用
			service.create();
			service.delete();
			service.update();
			service.query();

		} catch (Exception e) {
			log.error("testCglibProxy01 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCglibProxy02() {
		try {
			BookServiceCglibProxy cglibProxy = null;
			BookService service = null;
			
			cglibProxy = new BookServiceCglibProxy("haha");
			service = BookServiceFactory.getAuthInstance(cglibProxy);
			// 方法调用
			service.create();
			service.delete();
			service.update();
			service.query();
			
			//cglibProxy = new BookServiceCglibProxy("admin");
			//service = BookServiceFactory.getInstance(cglibProxy);
			// 方法调用
			//service.create();
			//service.delete();
			//service.update();
			//service.query();

		} catch (Exception e) {
			log.error("testCglibProxy02 =====> ", e);
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
