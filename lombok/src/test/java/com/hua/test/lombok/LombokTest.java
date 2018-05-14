/**
 * 描述: 
 * LombokTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.lombok;

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

import java.util.HashSet;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.BuilderExample;
import com.hua.entity.Person;
import com.hua.entity.BuilderExample.BuilderExampleBuilder;
import com.hua.lombok.MyResource;
import com.hua.test.BaseTest;

import lombok.Builder;
import lombok.Cleanup;
import lombok.NonNull;
import lombok.val;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * LombokTest
 */
public final class LombokTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testLombok() {
		try {
			
			
		} catch (Exception e) {
			log.error("testLombok =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testVal() {
		try {
			/*
			 * val 可以将变量声明是final类型
			 * 省略了 final 和 类型声明，通过右侧类型来推断声明类型.
			 */
			// 等同于 final Set<String> setVar = new HashSet<>();
			val setVar = new HashSet<String>();
			
		} catch (Exception e) {
			log.error("testVal =====> ", e);
		}
	}
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNonNull() {
		try {
			/*
			 * @NonNull 注解
			 * 可以为方法的参数提供非空检查
			 */
			//printName(null);
			printName("");
			printName("zhangsan");
		} catch (Exception e) {
			log.error("testNonNull =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param name
	 * @author qianye.zheng
	 */
	public final void printName(@NonNull String name)
	{
		/*
		 * 只判断 null的情况，对String没有判断空字符串的情况
		 * @NonNull String name 等同于 final String name 
		 * if (null != name)
		 * { 
		 * } else
		 * { 
		 *  throw new NullPointerException("null");
		 * }
		 * 
		 */
		log.info("getName =====> name = " + name);
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCleanup() {
		try {
			/*
			 * @Cleanup 注解
			 * 自动释放资源, 自动调用对象的close()方法，也可以指定对象调用关闭资源的方法，默认是close
			 * 自定义一个资源
			 * close的方法没有参数
			 */
			/*
			 * 相当于
			 * try
			 * {
			 * MyResource myResource = new MyResource();
			 * }
			 *finally
			 *{
			 * if (null != myResource)
			 * {
			 *   myResource.close();
			 * }
			 * }
			 */
			@Cleanup MyResource myResource = new MyResource();
			
			// 自定义关闭的方法
			@Cleanup("close2") MyResource myResource2 = new MyResource();
			
		} catch (Exception e) {
			log.error("testCleanup =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testClassAnnotation() {
		try {
			/*
			 * 类注解
			 * @Getter/@Setter/@ToString
			 */
			Person p = new Person();
			p.setNickname("xx");
			p.setAge(12);
			
			System.out.println(p.toString());
			
			Person p2 = new Person();
			
		} catch (Exception e) {
			log.error("testClassAnnotation =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testBuilder() {
		try {
			/*
			 * @Builder 注解 辅助生成了 构建对象的代码
			 */
			BuilderExample example = BuilderExample.builder().build();
		} catch (Exception e) {
			log.error("testBuilder", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSynchronized() {
		try {
			/*
			 * @Synchronized 注解 相当于 synchronized关键字
			 * 使用注解可以隐藏同步锁
			 */
			
		} catch (Exception e) {
			log.error("testSynchronized =====> ", e);
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
