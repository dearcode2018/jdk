/**
 * 描述: 
 * ThrowableTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.exception;

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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.exception.ExceptionHandler;
import com.hua.test.BaseTest;
import com.hua.util.ExceptionUtil;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * ThrowableTest
 */
public final class ThrowableTest extends BaseTest {

	
	/*
	 异常踪迹
	 类似于: (有多少行就代表 StackTraceElement[] getStackTrace()的长度是多少)
	 第一个异常踪迹是最开始的调用处抛出的，此时可以第一时间获取异常的发生未知.
	at com.hua.test.exception.ThrowableTest.testThrowable(ThrowableTest.java:51)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:50)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:38)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:467)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:683)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:390)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:197)	 
	 
	 
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testThrowable() {
		try {
			
			throwable = new Throwable("异常消息，呵呵");
			
			log.info("testThrowable =====> " + throwable.getLocalizedMessage());
			log.info("testThrowable =====> " + throwable.getMessage());
			// 异常踪迹()
			log.info("testThrowable =====> " + throwable.getStackTrace().length);
			log.info("testThrowable =====> " + throwable.getCause());
			log.info("testThrowable =====> " + throwable.getSuppressed().length);
			
			// 输出(默认就是System.err)
			 throwable.printStackTrace(System.err);
			 throwable.printStackTrace(System.out);
		} catch (Exception e) {
			log.error("testThrowable =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testMessage() {
		try {
			
			
		} catch (Exception e) {
			log.error("testMessage =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testStackTrace() {
		try {
			throwable = new Throwable("异常消息，呵呵");
			StackTraceElement[] ste = throwable.getStackTrace();
			StackTraceElement first = ste[0];
			/*
			 StackTraceElement 对象可以获取文件名/类名/方法名/行号/是否是本地方法/
			 */
			// 获取异常的第一发生位置信息，调用其toString方法输出
			System.out.println(first);
			// java.lang.Throwable.printStackTrace 方法只是在每个StackTraceElement输出信息前面加上 at
		} catch (Exception e) {
			log.error("testStackTrace =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPrintStackTrace() {
		try {
			
			
		} catch (Exception e) {
			log.error("testPrintStackTrace =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCause() {
		try {
			/*
			 加上 cause 之后，调用当前的异常对象
			 的printStackTrace 将输出 Caused by: xx
			 */
			cause = new Throwable("引发消息，哈哈");
			
			throwable = new Throwable("异常消息，呵呵", cause);
			
			throwable.printStackTrace();
			
		} catch (Exception e) {
			log.error("testCause =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSuppressed() {
		try {
			
			/*
			 加上 cause 之后，调用当前的异常对象
			 的printStackTrace 将输出 Caused by: xx
			 */
			cause = new Throwable("引发消息，哈哈");
			
			throwable = new Throwable("异常消息，呵呵", cause);
			throwable.addSuppressed(throwable);
			
			throwable.printStackTrace();
			
		} catch (Exception e) {
			log.error("testSuppressed =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 异常链
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testExceptionChain() {
		try {
			ExceptionHandler exceptionHandler = new ExceptionHandler();
			
			exceptionHandler.start();
			
			
		} catch (Exception e) {
			/*
			 类似于 StackTraceElement[] getStackTrace() 第一个元素
			 就是异常链上的第一个，以此类推
			 */
			//log.error("testExceptionChain =====> ", e);
			// 获取异常链上的 上一个 异常
			Throwable e1 = e.getCause();
			System.out.println(e1.toString());
			// 继续往下获取，直到为空
			Throwable e2 = e1.getCause();
			System.out.println(e2.toString());
		}
	}
	
	/**
	 * 
	 * 描述: 异常链
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testExceptionUtil() {
		try {
			ExceptionHandler exceptionHandler = new ExceptionHandler();
			
			exceptionHandler.start();
			
			
		} catch (Exception e) {
			/*
			 类似于 StackTraceElement[] getStackTrace() 第一个元素
			 就是异常链上的第一个，以此类推
			 */
			//log.error("testExceptionChainUtil =====> ", e);
			// 获取异常链上的 上一个 异常
			System.out.println(ExceptionUtil.getAllCauseInfo(e));
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
