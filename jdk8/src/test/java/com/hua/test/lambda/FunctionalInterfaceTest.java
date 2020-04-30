/**
 * 描述: 
 * FunctionalInterfaceTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.lambda;

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

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.test.BaseTest;
import com.hua.util.RandomUtil;
import com.hua.view.UserVO;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FunctionalInterfaceTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class FunctionalInterfaceTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 函数型
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testFunction() {
		try {
			/**
			 * 第一个: 入参，第二个: 返回值
			 * Function<T,R>
			 * 
			 */
			Function<Integer, String> fun = x -> "name_" + x;
			System.out.println(fun.apply(1));
			System.out.println(fun.apply(2));
		} catch (Exception e) {
			log.error("testFunction =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 断定型
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testPredicate() {
		try {
			/*
			 * 入任意类型参数
			 * 返回值为布尔值
			 * 等效于 Function<T, Boolean>
			 */
			Predicate<String> predicate = x -> "yes".equals(x);
			System.out.println(predicate.test("yes"));
			System.out.println(predicate.test("no"));
		} catch (Exception e) {
			log.error("testPredicate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 消费者
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testConsumer() {
		try {
			/**
			 * 消费者 
			 * 输入入参
			 * 等效于 Function<T, Void>
			 * 
			 */
			Consumer<Integer> consumer1 = x -> System.out.println(x);
			consumer1.accept(2);
			
			// 只有一个参数，小括号可以省略不写
			Consumer<Integer> consumer2 = x -> System.out.println(x);
			consumer2.accept(2);
			
			
		} catch (Exception e) {
			log.error("testConsumer =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 生产者
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testSupplier() {
		try {
			/**
			 * 生产者(提供者)
			 * 输出返回值
			 * 等效于 Function<Void, T>
			 */
			// 写法1: 一行直接省略return关键字
			Supplier<Integer> producer1 = () -> RandomUtil.nextInt(200);
			System.out.println(producer1.get());
			
			// 写法2: 完整写法
			Supplier<Integer> producer2 = () -> {return RandomUtil.nextInt(200);};
			System.out.println(producer2.get());
			
			// 构造方法 也是一种Supplier函数式接口方法，无参构造则用Supplier，有参则用Function接口
			Supplier<UserVO> producer3 = UserVO :: new;
			
			
			
		} catch (Exception e) {
			log.error("testSupplier =====> ", e);
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
	public void testComparator() {
		try {
			Comparator<Integer> comparator = null;
			comparator = (x, y) -> x.compareTo(y);
			comparator = (x, y) -> Integer.compare(x, y);
		} catch (Exception e) {
			log.error("testComparator =====> ", e);
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
	public void testComparable() {
		try {
			Integer other = 1;
			Comparable<Integer> com = null;
		} catch (Exception e) {
			log.error("testComparable =====> ", e);
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
