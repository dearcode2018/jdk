/**
 * 描述: 
 * FunctionalInterfaceTest.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * FunctionalInterfaceTest
 */
public final class FunctionalInterfaceTest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testConsumer() {
		try {
			
			happy(1000.0, (x) -> System.out.print("consume: " + x));
			
			
		} catch (Exception e) {
			log.error("testConsumer =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param money
	 * @param consumer
	 * @author qianye.zheng
	 */
	public void happy(final Double money, Consumer<Double> consumer)
	{
		consumer.accept(money);
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSupplier() {
		try {
			List<Integer> result = getNumList(10, () ->(int) (Math.random() * 1000));
			result.stream().forEach(System.out:: println);
		} catch (Exception e) {
			log.error("testSupplier =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param num
	 * @param supplier
	 * @return
	 * @author qianye.zheng
	 */
	public List<Integer> getNumList(Integer num, Supplier<Integer> supplier)
	{
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < num; i++)
		{
			result.add(supplier.get());
		}
		
		return result;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testFunction() {
		try {
			System.out.println(length("hello", (x) -> x.length()));
			
		} catch (Exception e) {
			log.error("testFunction =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param value
	 * @param function
	 * @return
	 * @author qianye.zheng
	 */
	public Integer length(final String value, final Function<String, Integer> function)
	{
		return function.apply(value);
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testPredicate() {
		try {
			Integer[] ages = {34, 17, 43, 23, 8};
			Integer[] result = predicate(ages, (x) -> x > 20);
			
			System.out.println(result.length);
			
		} catch (Exception e) {
			log.error("testPredicate =====> ", e);
		}
	}
	
	public Integer[] predicate(final Integer[] values, final Predicate<Integer> predicate)
	{
		List<Integer> result = new ArrayList<>();
		for (Integer e : values)
		{
			if (predicate.test(e))
			{
				result.add(e);
			}
		}
		
		return result.toArray(new Integer[] {});
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
