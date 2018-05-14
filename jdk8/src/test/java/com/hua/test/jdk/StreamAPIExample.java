/**
 * 描述: 
 * StreamAPIExample.java
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.Trader;
import com.hua.entity.Transaction;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * StreamAPIExample
 */
public final class StreamAPIExample extends BaseTest {

	List<Transaction> transactions = null;
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Before
	public void before() {
		try {
			Trader raoul = new Trader("Raoul", "Cambridge");
			Trader mario = new Trader("Mario", "Milan");
			Trader alan = new Trader("Alan", "Cambridge");
			Trader brian = new Trader("Brian", "Cambridge");
			
			transactions = Arrays.asList(
					new Transaction(brian, 2011, 300),
					new Transaction(raoul, 2012, 1000),
					new Transaction(raoul, 2011, 710),
					new Transaction(mario, 2012, 710),
					new Transaction(mario, 2012, 700),
					new Transaction(alan, 2012, 950)
					);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 找出2011年发生的所有交易，并按交易额升序
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test1() {
		try {
			transactions.stream().filter((x) -> x.getYear() == 2011).sorted((x, y) -> x.getValue()
					.compareTo(y.getValue())).forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("test1 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 交易员都在哪些不同城市工作过
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test2() {
		try {
			transactions.stream().map((x) -> x.getTrader().getCity()).distinct()
			.forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("test2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 查找所有来自剑桥的交易员，并按姓名排序
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test3() {
		try {
			transactions.stream().filter((x) -> x.getTrader().getCity().equals("Cambridge"))
			.map((x) -> x.getTrader().getName()).distinct()
			.sorted().forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("test3 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 返回所有交易员姓名的字符串，按字母排序
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test4() {
		try {
			Optional<String>optional = transactions.stream()
			.map((x) -> x.getTrader().getName()).sorted().reduce(String :: concat);
			//.sorted().forEach(System.out :: println);
			log.info("test4 =====> " + optional.get());
		} catch (Exception e) {
			log.error("test4 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 有没有交易员是在米兰工作的
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test5() {
		try {
			boolean flag = transactions.stream().anyMatch((x) -> x.getTrader().getCity().equals("Milan"));
			log.info("test5 =====> flag = " + flag);
		} catch (Exception e) {
			log.error("test5 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 找出在剑桥工作的交易员的所有交易额
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test6() {
		try {
			Optional<Integer> total = transactions.stream().filter((x) -> 
			x.getTrader().getCity().equals("Cambridge"))
			.map(Transaction :: getValue)
			//		.reduce((x, y) -> x + y);
			.reduce(Integer :: sum);
			
			log.info("test6 =====> total = " + total.get());
			
		} catch (Exception e) {
			log.error("test6 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 所有交易额中，最高交易是多少
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test7() {
		try {
			Optional<Integer> option = transactions.stream().map(Transaction :: getValue)
				//.max((x, y) -> x.compareTo(y));
					.max(Integer :: compare);
			log.info("test7 =====> maxValue = " + option.get());
		} catch (Exception e) {
			log.error("test7 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 找出交易额最小的交易
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test8() {
		try {
			Optional<Integer> option = transactions.stream().map(Transaction :: getValue)
					//	.min((x, y) -> x.compareTo(y));
					.min(Integer :: compare);
			log.info("test8 =====> minValue = " + option.get());
			
		} catch (Exception e) {
			log.error("test8 =====> ", e);
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
