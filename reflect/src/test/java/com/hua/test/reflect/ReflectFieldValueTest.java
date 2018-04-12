/**
 * 描述: 
 * ReflectFieldValueTest.java
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

import java.lang.reflect.Field;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.bean.reflect.SearchBean;
import com.hua.test.BaseTest;
import com.hua.util.DateTimeUtil;
import com.hua.util.ReflectUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ReflectFieldValueTest
 */
public final class ReflectFieldValueTest extends BaseTest {

	private Class<?> clazz = SearchBean.class;
	
	private Field[] fields;
	
	private Field field;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReflectField() {
		try {
			SearchBean searchBean = new SearchBean();
			searchBean.setBt(new Byte((byte) 127));
			searchBean.setFl(102.5F);
			searchBean.setFlag(true);
			searchBean.setCh('a');
			searchBean.setDate(DateTimeUtil.getDate());
			searchBean.setDb(11.90);
			//searchBean.setI(23);
			searchBean.setId("216545ac");
			searchBean.setLon(22000L);
			searchBean.setSh((short) 20);
			searchBean.setIn(9876);
			searchBean.setDateTime(DateTimeUtil.getDateTime());
			
			// 
			fields = clazz.getDeclaredFields();
			for (int i = 0; i < fields.length; i++)
			{
				field = fields[i];
				// 给指定的属性设置值
				// 设置为可以访问(若不设置，则访问将抛异常)
				/*
				 java.lang.IllegalAccessException: Class com.hua.test.reflect.ReflectTest can not access a 
				 member of class com.hua.entity.User with modifiers "private"
				 */
				field.setAccessible(true);
				System.out.println(field.getName() + ": " + field.get(searchBean));
			}
			
		} catch (Exception e) {
			log.error("testReflectField =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testAlertSearch() {
		try {
			SearchBean searchBean = new SearchBean();
			searchBean.setBt(new Byte((byte) 127));
			searchBean.setFl(102.5F);
			//searchBean.setFlag(true);
			searchBean.setCh('a');
			searchBean.setDate(DateTimeUtil.getDate());
			searchBean.setDb(11.90);
			//searchBean.setI(23);
			//searchBean.setId("216545ac");
			searchBean.setLon(22000L);
			searchBean.setSh((short) 20);
			searchBean.setIn(9876);
			//searchBean.setDateTime(DateTimeUtil.getDateTime());
			ReflectUtil.alertSearch("testAlertSearch", searchBean, log);
			
		} catch (Exception e) {
			log.error("testAlertSearch =====> ", e);
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
