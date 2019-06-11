/**
 * 描述: 
 * MethodReferenceTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.jdk;

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

import java.io.PrintStream;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.call.SomeThing;
import com.hua.entity.User;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * MethodReferenceTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class MethodReferenceTest extends BaseTest {

	/**
		方法引用
		1. 对象 :: 实例方法名
		2. 类 :: 静态方法
		3. 类 :: 实例方法名
		2个变量，第一个变量的方法是实例方法的调用者，第二个变量是实例方法的参数 即可采用 类 :: 实例方法
		
		构造器引用
		类 :: new
	 */
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testCallStaticMethod() {
		try {
			//Function<String, Boolean> fun = (x) -> {return StringUtil :: isEmpty(x);}
			//Function<String, Boolean> fun = (x) -> {return SomeThing::isFlag;};
			SomeThing some = new SomeThing();
			
			/*
			 * 实例方法名 :: 方法名
			 * 注意方法不带括号，方法体就是这个，参数和方法提都可以忽略
			 * 无返回，一个参数，消费型函数
			 * 因为其实就是一个方法调用，一个参数，因此直接省略了lambda表达式的常规写法.
			 * 
			 * 触发调用: Consumer.accept(T t)
			 */
			Consumer<String> consumer = some :: consume;
			consumer.accept("a");
			
			/*
			 * 类 :: 静态方法
			 * 一个返回一个参数，0返回一个参数，1个返回0个参数
			 * 
			 */
			// 生产型
			Supplier<Boolean> fun1 = SomeThing::isFlag;
			Boolean flag1 = fun1.get();
			
			// 消费型
			Consumer<String> fun2 = SomeThing::isFlag;
			fun2.accept("ac");
			
			// 函数式
			Function<String, Boolean> fun3 = SomeThing::isFlag;
			Boolean flag3 = fun3.apply("a");
			
			
			
			
		} catch (Exception e) {
			log.error("testCallStaticMethod =====> ", e);
		}
	}	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMethodRefConstructor2() {
		// 样式1
		Supplier<User> sup1 = () -> {return new User();};
		// 样式2
		Supplier<User> sup2 = () -> new User();
		// 样式3: 最简式
		Supplier<User> sup3 = User :: new;
		
		// 函数式
		Function<String, User> fun1 = (x) -> {return new User();};
		Function<String, User> fun2 = (x) -> new User();
		
	}
	
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
			// 方法的作用和返回值取决于使用的函数式接口
			biP2.test("gg", "xx");
			
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
