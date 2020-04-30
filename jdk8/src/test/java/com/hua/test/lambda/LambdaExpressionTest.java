/**
 * 描述: 
 * LambdaExpressionTest.java
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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.test.BaseTest;
import com.hua.util.RandomUtil;
import com.hua.view.AddressVO;
import com.hua.view.UserVO;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * LambdaExpressionTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class LambdaExpressionTest extends BaseTest {

	
	private List<UserVO> vos;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testExpression() {
		try {
			
			
		} catch (Exception e) {
			log.error("testExpression =====> ", e);
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
			 * 
			 * 
			 */
			Consumer<Integer> consumer1 = (x) -> System.out.println(x);
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
			 */
			// 写法1: 一行直接省略return关键字
			Supplier<Integer> producer1 = () -> RandomUtil.nextInt(200);
			System.out.println(producer1.get());
			
			// 写法2: 完整写法
			Supplier<Integer> producer2 = () -> {return RandomUtil.nextInt(200);};
			System.out.println(producer2.get());
			
			
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
		vos = new ArrayList<>();
		UserVO vo = null;
		
		vo = new UserVO();
		vo.setId("20191201");
		vo.setAge(37);
		vo.setUsername("张三");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(true);
		vo.setAddress(AddressVO.builder().detailValue("广东省深圳市龙岗区").postalcode("25485").build());
		vos.add(vo);
		
		vo = new UserVO();
		vo.setId("20191201");
		vo.setAge(20);
		vo.setUsername("李四");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(true);
		vo.setAddress(AddressVO.builder().detailValue("广西省桂林市阳朔县").postalcode("12456").build());
		vos.add(vo);
		
		vo = new UserVO();
		vo.setId("20191204");
		vo.setAge(41);
		vo.setUsername("王五");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(true);
		vo.setAddress(AddressVO.builder().detailValue("浙江省杭州市余杭区").postalcode("85822").build());
		vos.add(vo);
		
		vo = new UserVO();
		vo.setId("20191209");
		vo.setAge(26);
		vo.setUsername("赵六");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(true);
		vo.setAddress(AddressVO.builder().detailValue("广东省湛江市霞山区").postalcode("57422").build());
		vos.add(vo);
		
		vo = new UserVO();
		vo.setId("20191856");
		vo.setAge(39);
		vo.setUsername("武松");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(true);
		vo.setAddress(AddressVO.builder().detailValue("江西赣州市龙锦路102号").postalcode("258755").build());
		vos.add(vo);
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
