/**
 * 描述: 
 * StreamAPITest.java
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
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

import com.hua.entity.User;
import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * StreamAPITest
 */
public final class StreamAPITest extends BaseTest {

	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testStream() {
		try {
			/**
			 * 获取Stream的方式
			 */
			// 1.集合对象方法
			List<String> list = new ArrayList<>();
			Stream<String> stream1 = list.stream();
			
			// 2.工具方法
			Arrays.stream(new String[] {});
			
			// 3.Stream
			Stream stream3 = Stream.of("a", "d");
			
			// 4.无限流
			Stream<Integer> stream4 = Stream.iterate(0, (x) -> x +2);
			stream4.limit(10).forEach(System.out :: println);
			
			// 5. 生成
			Stream.generate(Math :: random).limit(10).forEach(System.out :: println);;
			
		} catch (Exception e) {
			log.error("testStream =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testStream2() {
		try {
			/*
			 * 没有终止操作，则没有中间操作
			 * 
			 */			
			/**
			 * 短路: 找到符合条件的之后就不会再继续执行
			 */
			List<User> users = new ArrayList<User>();
			User e = null;
			
			e = new User();
			e.setNickname("a");
			e.setValid(false);
			users.add(e);
			
			e = new User();
			e.setNickname("b");
			e.setValid(true);
			users.add(e);
			
			e = new User();
			e.setNickname("c");
			e.setValid(false);
			users.add(e);
			
			Stream<User> stream = users.stream().filter((x) -> {
				System.out.println("有终止操作才有中间操作");
				
				return x.isValid();
			});
			
			/*
			 * 终止操作，若注释掉终止操作，则没有中间操作
			 * 相当于只能由终止操作去触发中间操作
			 * 这样称为 惰性求值、延迟加载
			 */
			stream.forEach(System.out :: println);
			
			/**
			 * 找到符合条件的之后就不会再继续执行
			 */
			Stream<User> stream2 = users.stream().filter((x) -> {
				System.out.println("有终止操作才有中间操作2");
				
				return x.isValid();
			}).limit(1);
			// 外部迭代
			Iterator<User> iterator = stream2.iterator();
			while (iterator.hasNext())
			{
				System.out.println(iterator.next());
			}
			
			/**
			 * skip(n) 丢弃前n个元素
			 * distinct() 去重，根据hashCode()和equals()方法去重
			 */
			
		} catch (Exception e) {
			log.error("testStream2 =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testStreamMap() {
		try {
		/**
		 * map: 接收lambda，将元素转换成其他形式或提取信息
		 * 接收一个函数作为参数，该函数应用到每个元素上，映射成一个新元素
		 * flatMap: 以函数作为参数，将流中每个值替换成另一个流，然后把所有流合并为一个.	
		 */
			List<String> list = Arrays.asList("aa", "cc", "kduow", "wes3", "sewerz");
			Stream<String> stream = list.stream().map((x) -> x.toUpperCase());
			stream.forEach(System.out :: println);
			
			List<User> users = new ArrayList<User>();
			User e = null;
			
			e = new User();
			e.setNickname("a");
			e.setValid(false);
			users.add(e);
			
			e = new User();
			e.setNickname("b");
			e.setValid(true);
			users.add(e);
			
			e = new User();
			e.setNickname("c");
			e.setValid(false);
			users.add(e);
			users.stream().map(User :: getNickname).forEach(System.out :: println);
			
			System.out.println("-----------------");
			
			/*
			 * 一般场景，用flatMap可以简化如下场景
			 */
			Stream<Stream<Character>> stream2 = list.stream().map(StreamAPITest :: filterCharacter);
			stream2.forEach((x) -> {
				x.forEach(System.out :: println);
			});
			System.out.println("-----------------");
			// 用flatMap简化上面的场景
			Stream<Character> stream3 = list.stream().flatMap(StreamAPITest :: filterCharacter);
			stream3.forEach(System.out :: println);
		} catch (Exception e) {
			log.error("testStreamMap =====> ", e);
		}
	}
	
	/**
	 * 
	 * @description 
	 * @param str
	 * @return
	 * @author qianye.zheng
	 */
	public static Stream<Character> filterCharacter(String str)
	{
		List<Character> list = new ArrayList<>();
		for (Character ch : str.toCharArray())
		{
			list.add(ch);
		}
		
		return list.stream();
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testStreamFind() {
		try {
			/**
			 * 查找和匹配
			 * allMatch - 是否匹配所有元素
			 * anyMatch - 至少匹配一个元素
			 * noneMatch - 是否没有匹配所有元素
			 * findFirst - 返回第一个元素
			 * findAny - 返回任意一个元素
			 * count - 流的元素总数
			 * max - 返回流中最大值
			 * min - 返回流中最小值
			 * 
			 */
			List<User> users = new ArrayList<User>();
			User e = null;
			
			e = new User();
			e.setNickname("a");
			e.setValid(false);
			users.add(e);
			
			e = new User();
			e.setNickname("b");
			e.setValid(true);
			users.add(e);
			
			e = new User();
			e.setNickname("c");
			e.setValid(false);
			users.add(e);
			
			boolean flag = false;
			flag = users.stream().allMatch((x) -> true == x.isValid());
			log.info("testStreamFind =====> flag = " + flag);
			
			flag = users.stream().anyMatch((x) -> true == x.isValid());
			log.info("testStreamFind =====> flag = " + flag);			
			
			flag = users.stream().noneMatch((x) -> true == x.isValid());
			log.info("testStreamFind =====> flag = " + flag);
			
			Optional<User> optional1 = users.stream().findFirst();
			System.out.println(optional1.get().getNickname());
			
			
			Optional<User> optional2 = users.stream().findAny();
			System.out.println(optional2.get().getNickname());
			
			System.out.println(users.stream().count());
			
			// 最大最小 传入比较器函数 
			//System.out.println(users.stream().max);
			
		} catch (Exception e) {
			log.error("testStreamFind =====> ", e);
		}
	}

	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testReduce() {
		try {
			/*
			 * 归约
			 */
			List<Integer> list = Arrays.asList(1 ,2 ,3, 4, 5, 6, 7, 8);
			// 求和
			Optional<Integer> sum2 = list.stream().reduce(Integer :: sum);
			System.out.println(sum2.get());	
			
			/*
			 * x 作为起始值，y为流中的元素; 第二次以后x为流中的元素
			 * 
			 */
			Integer sum = list.stream().reduce(0, (x, y) -> x + y);
			System.out.println(sum);
			
		} catch (Exception e) {
			log.error("testReduce =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testCollect() {
		try {
			/*
			 * 收集
			 */
			List<User> users = new ArrayList<User>();
			User e = null;
			
			e = new User();
			e.setNickname("a");
			e.setValid(false);
			e.setAge(12);
			users.add(e);
			
			e = new User();
			e.setNickname("b");
			e.setValid(true);
			e.setAge(44);
			users.add(e);
			
			e = new User();
			e.setNickname("c");
			e.setValid(false);
			e.setAge(34);
			users.add(e);
			
			List<String> names = users.stream().map(User :: getNickname).collect(Collectors.toList());
			names.forEach(System.out :: println);
			
			Map<Boolean, List<User>> map = users.stream().collect(Collectors.groupingBy(User :: isValid));
			System.out.println(map);
			
			IntSummaryStatistics iss = users.stream().collect(Collectors.summarizingInt(User :: getAge));
			System.out.println(iss.getAverage());
			
		} catch (Exception e) {
			log.error("testCollect =====> ", e);
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
