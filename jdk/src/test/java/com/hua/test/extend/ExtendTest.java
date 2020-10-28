/**
 * 描述: 
 * ExtendTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.extend;

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
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.clone.FactoryClone;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ExtendTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class ExtendTest extends BaseTest {

	
	
	final int a;
	{
		a = 1;
	}
	static {
		// 不能访问非静态成员
		//a = 1;
	}
	
	{
		//throw new RuntimeException();
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testExtend() {
		try {
			Parent obj1 = new Child();
			//obj1.say();
			obj1.go();
		} catch (Exception e) {
			log.error("testExtend =====> ", e);
		}
	}
	
	class Parent {
		public Parent() {
			//this.say();
		}
		void say() {
			System.out.println("ExtendTest.Parent.say()");
		}
		
		void go() {
			System.out.println("ExtendTest.Parent.go()");
		}
		
		int val() {
			try {
				//System.exit(0);
				return 1;
			} catch (Exception e) {
				return 2;
			} finally {
				// 覆盖try/catch 中的return
				return 3;
			}
		}
	}
	
	class Child extends Parent {
		/**
		 * @description 
		 * @author qianye.zheng
		 */
		@Override
		void say() {
			super.say();
			System.out.println("ExtendTest.Child.say()");
		}
		
		/**
		 * @description 
		 * @author qianye.zheng
		 */
		@Override
		void go() {
			super.say();
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
	public void testTryFinally() {
		try {
			Parent o = new Parent();
			System.out.println(o.val());
			
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
	//@DisplayName("test")
	@Test
	public void testArray() {
		try {
			boolean[] bols = new boolean[2];
			assertFalse(bols[0]);
			
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
	//@DisplayName("test")
	@Test
	public void testCallVariableParam() {
		try {
			// 0个参数
			variableParam();
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	void variableParam(int... params) {
		
	}
	
	protected static abstract interface In {
		void a();
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testSwitchCase() {
		try {
			int i = 9;
			switch (i) {
			default:
				System.out.println("");
				break;
			case 0:
				System.out.println("1");
				break;
			}
			
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
	//@DisplayName("test")
	@Test
	public void testContinue() {
		try {
			outer: for (int i = 0;i < 3; i++) {
				inner: for (int j = 0; j < 2; j++) {
					if (1 == j) {
						// 继续指定的循环
						continue outer;
					}
					System.out.println(j + " and " + i);
				}
			}
			
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
	//@DisplayName("test")
	@Test
	public void testInteger() {
		try {
			// 构造出来的
			Integer i1 = new Integer(1);
			Integer i2 = 1;
			assertFalse(i1 == i2);
			
			
			/*
			 * Integer 和 int类型进行 等值判断，Integer会自动拆箱 然后进行值的比较
			 * 
			 * 字面值在-128 - 127之间，直接用IntegerCache，Integer类型用==比较为true
			 * 超出则为false
			 */
			Integer i3 = 128;
			int i4 = 128;
			assertTrue(i3 == i4);
			
			// 方法内的内部类
			abstract class A {
				//synchronized  void a() {}
			}
			final class B {
				
			}
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	private class MK {
		
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testClone1() {
		try {
			FactoryClone f1 = new FactoryClone();
			f1.setValue(2);
			
			FactoryClone f2 = (FactoryClone) f1.clone();
			assertTrue(f2.getValue() == f1.getValue());
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
			String str = null;
			Integer val = null;
			// Incompatible operand types String and Integer
			//System.out.println(str == val);
			assertTrue(Math.round(-11.5) == -11);
			assertTrue('a' + 1 == 98);
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
