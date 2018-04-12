/**
 * 描述: 
 * UnsafeTest.java
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

import com.hua.bean.ManyData;
import com.hua.bean.ResultBean;
import com.hua.test.BaseTest;
import com.hua.util.JVMUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * UnsafeTest
 */
public final class UnsafeTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testUnsafe() {
		try {
			
			
			
		} catch (Exception e) {
			log.error("testUnsafe =====> ", e);
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
	public void testCalculateObject() {
		try {
			
			ResultBean resultBean = new ResultBean();
			ManyData data = new ManyData();
			data.setId1(8888888888888888888L);
			data.setId2(8888888888888888888L);
			data.setId3(8888888888888888888L);
			data.setId4(8888888888888888888L);
			resultBean.setData(data);
			resultBean.setMessage("public native boolean asfasdasfsadfasfsfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasf"
					+ "asfasdfadsfadsfasdfasfdddddddddddddddddddddddddddddddddfasdfasdfasdfasdfasdf"
					+ "asfasdfsadfasdfasfasdfasfasdfasdfasdfasdfasddfasdfasf"
					+ "asfasdfdsafasfasdfasdfgetBooleanVolatile(Object paramObject, long paramLong);");
			log.info("testCalculateObject =====> size = " + JVMUtil.sizeOf(resultBean));

			ResultBean resultBean2 = new ResultBean();
		
			resultBean2.setMessage("public native boolean asfasdasfsadfasfsfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasdfasf"
					+ "asfasdfadsfadsfasdfasfdddddddddddddddddddddddddddddddddfasdfasdfasdfasdfasdf"
					+ "asfasdfsadfasdfasfasdfasfasdfasdfasdfasdfasddfasdfasf"
					+ "asfasdfdsafasfasdfasdfgetBooleanVolatile(Object paramObject, long paramLong);");
			log.info("testCalculateObject =====> size = " + JVMUtil.sizeOf(resultBean2));			
			
			//Thread.sleep(100000);// 阻塞线程，为了使用jmap工具  
			
		} catch (Exception e) {
			log.error("testCalculateObject =====> ", e);
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
