/**
 * 描述: 
 * GenericTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.generic;

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
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.generic.AbstractClassGeneric;
import com.hua.generic.ExtendsAbstractClassGenericOne;
import com.hua.test.BaseTest;
import com.hua.util.GenericStudyUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * GenericTest
 */
public final class GenericTest extends BaseTest {

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@SuppressWarnings(value = {"unused"})
	@Test
	public void testBasic() {
		try {
			
			/*
			 全部不实例化泛型参数 (没有实例化泛型变量，则默认使用Object来代替，
			 这种行为将导致类型不安全，不推荐这种做法)
			 */
			ExtendsAbstractClassGenericOne e1 =
					new ExtendsAbstractClassGenericOne();
			
			// 全部实例化泛型参数
			ExtendsAbstractClassGenericOne<String, Integer, Short> e2 =
					new ExtendsAbstractClassGenericOne<String, Integer, Short>();
			
			// public  static <U, M, N> U go(final M m, final U u)
			
			// 带泛型变量 - 静态方法调用 - 通过参数来实例化泛型变量
			AbstractClassGeneric.go(new Object(), new Object());
			
			// 带泛型变量 - 静态方法调用 - 通过参数来实例化泛型变量
			AbstractClassGeneric.go(new Integer(1), new String("d"));
			AbstractClassGeneric.go(new Integer(1), new String("d"));
			
		} catch (Exception e) {
			log.error("testBasic =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testGeneric() {
		try {
			
			String str1 = AbstractClassGeneric.returnType(String.class);
			
			log.info("testGeneric =====> str1 = " + str1);
			
			String str2 = new String("dd");
			
			
			
			
		} catch (Exception e) {
			log.error("testGeneric =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 测试问号
	 * @author qye.zheng
	 * 
	 */
	@Test
	@SuppressWarnings(value = {"unused"})
	public void testQuestionMark() {
		try {
			
			/**
			 java.lang.Object 
			 getClass 方法声明
			 public final native Class<?> getClass();
			 */
			
			// Class<java.lang.String> Xx.class
			Class<?> c1 = String.class;
			
			// Class<?> Object.getClass()
			Class<?> c2 = String.class.getClass();
			
			// Class<java.lang.String> Xx.class
			Class<String> c3 = String.class;
			
			// 不能实施强转 Class<?> -/-> Class<java.lang.String>
			//Class<String> c4 = (Class<String>) String.class.getClass();
			
			
			// 基本类型 泛型变量只能写引用类型
			Class<?> c5 = byte.class;
			Class<?> c6 = byte.class.getClass();
			
			Class<?> c7 = byte.class.getClass();
			// 无法强转
			//Class<Byte> c8 = (Class<Byte>) byte.class.getClass();
			Class<Byte> c9 = byte.class;
			
			Class<Byte> c10 = Byte.class;
			
		} catch (Exception e) {
			log.error("testQuestionMark =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testExtends() {
		try {
			
			/*
			 ? 与 extends 结合
			 ? 表示 任意的类型实例
			 ? extends MaxType 表示 可以接受的最大类型为 MaxType
			 通常 ? extends MaxType 使用在引用声明中，而不能使用
			 在类型的创建中，因为不明确的类型是无法初始化的
			 
			 ? extends MaxType 是只读型容器，返回的元素类型就是
			 MaxType.
			 ? extends MaxType 就是一个获取资源的限制条件
			 */
			
			
			 List<Integer> integerList = new ArrayList<Integer>();
			 integerList.add(11);
			 integerList.add(4);
			 integerList.add(2);
			 GenericStudyUtil.extendsRead(integerList);
			 //ArrayList<? extends Number> arr = null;
			
		} catch (Exception e) {
			log.error("testExtends =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSuper() {
		try {
			
			/**
			 ? super MinType 就是一个门槛，
			 入门的最低条件
			 
			 */
			List<Number> numberList = new ArrayList<Number>();
			 GenericStudyUtil.superWrite(numberList);
			
		} catch (Exception e) {
			log.error("testSuper =====> ", e);
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
			// Class<java.lang.String>
			Class<?> clazz = String.class;
			
			// Class<?> Object.getClass()
			clazz = String.class.getClass();
			
			
			// 对象 Class<?> Object.getClass()
			clazz = "".getClass();
			
			List<Integer> list = Arrays.asList(1, 2, 3);
			
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
	public void testClass() {
		try {
			
			
			/*
			 
			 public final class java.lang.Class<T>
			 */
			
			/**
			 每个类加载后，都有一个名称为class的属性，
			 Class<Type> class;
			 Object 有一个 getClass() 方法 返回 Class<?>，而Class也是Object对象
			 因此，可以 Type.class 返回的是Class<Type>
			 而Type.class.getClass() 则返回Class<?> 类型，
			 使用的是Object的getClass()方法
			 */
			
			Class<String> c1 = String.class;
			Class<?> c2 = String.class.getClass();
			
			
			String str = c1.newInstance();
			Object obj = c2.newInstance();
			
		} catch (Exception e) {
			log.error("testClass =====> ", e);
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
	 * 描述: 普通测试方法
	 ,@Test注解 不带参数
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testNormal() {
		System.out.println("testNormal()");
	}
	
	/**
	 * 
	 * 描述: 期望发生异常-测试方法
	 ,@Test注解 异常
	 * @author qye.zheng
	 * 
	 */
	@Test(expected=NullPointerException.class)
	@SuppressWarnings("all")
	public void testException() {
		String str = null;
		System.out.println(str.length());
	}
	
	/**
	 * 
	 * 描述: 超时测试方法
	 ,@Test注解 指定运行时间 (单位 : 毫秒)
	 * @author qye.zheng
	 * 
	 */
	@Test(timeout=3000)
	public void testTimeOut() {
		System.out.println("testTimeOut()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Ignore("暂时忽略的方法")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
	}
	
	/**
	 * 
	 * 描述: [所有测试]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@After
	public void afterMethod() {
		System.out.println("afterMethod()");
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
