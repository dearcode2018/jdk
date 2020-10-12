/**
 * 描述: 
 * StreamAPITest.java
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.call.SomeThing;
import com.hua.test.BaseTest;
import com.hua.util.EmptyUtil;
import com.hua.view.AddressVO;
import com.hua.view.UserVO;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * StreamAPITest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final  class StreamAPITest extends BaseTest {

	private List<UserVO> vos;
	
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
		vo.setId("20191202");
		vo.setAge(37);
		vo.setUsername("张三");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(true);
		vo.setAddress(AddressVO.builder().detailValue("广东省深圳市龙岗区").postalcode("25485").build());
		vo.setLastLoginIps(Arrays.asList("192.168.1.2", "192.168.1.3"));
		vos.add(vo);
		
		vo = new UserVO();
		vo.setId("20191201");
		vo.setAge(20);
		vo.setUsername("李四");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(true);
		vo.setAddress(AddressVO.builder().detailValue("广西省桂林市阳朔县").postalcode("12456").build());
		vo.setLastLoginIps(Arrays.asList("192.168.1.4", "192.168.1.5"));
		vos.add(vo);
		
		vo = new UserVO();
		vo.setId("20191204");
		vo.setAge(41);
		vo.setUsername("王五");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(false);
		vo.setAddress(AddressVO.builder().detailValue("浙江省杭州市余杭区").postalcode("85822").build());
		vo.setLastLoginIps(Arrays.asList("192.168.1.0", "192.168.1.1"));
		vos.add(vo);
		
		vo = new UserVO();
		vo.setId("20191209");
		vo.setAge(26);
		vo.setUsername("赵六");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(true);
		vo.setAddress(AddressVO.builder().detailValue("广东省湛江市霞山区").postalcode("57422").build());
		vo.setLastLoginIps(Arrays.asList("192.168.1.7", "192.168.1.8"));
		vos.add(vo);
		
		vo = new UserVO();
		vo.setId("20191203");
		vo.setAge(39);
		vo.setUsername("武松");
		vo.setGmtCreate(LocalDateTime.now());
		vo.setGmtUpdate(LocalDateTime.now());
		vo.setValid(true);
		vo.setAddress(AddressVO.builder().detailValue("江西赣州市龙锦路102号").postalcode("258755").build());
		vo.setLastLoginIps(Arrays.asList("192.168.1.9", "192.168.1.10"));
		vos.add(vo);
	}
	
	/**
	 * 
	 * 描述: 过滤
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testFilter() {
		try {
			/**
			 * 过滤指定属性，Predicate返回false的会被过滤掉不会再输出
			 * 
			 */
			/* age大于20 */
			System.out.println("=================== age 大于20");
			vos.stream().filter(x -> {return x.getAge() > 20;}).forEach(x -> {System.out.println(x.getRemark());});
			
			// 地址在 广东省
			System.out.println("=================== 地址在 广东省");
			vos.stream().filter(x -> {return x.getAddress().getDetailValue().startsWith("广东省");}).forEach(x -> {System.out.println(x.getRemark());});
			
			// 
	
			
		} catch (Exception e) {
			log.error("testFilter =====> ", e);
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
	public void testMap() {
		try {
			/*
			 * map 收集指定字段
			 */
			List<String> ids = vos.stream().map(x -> x.getId()).collect(Collectors.toList());
			
			ids.forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("testMap =====> ", e);
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
	public void testMapToInt() {
		try {
			/*
			 * mapToInt 转换成int
			 */
			IntStream stream = vos.stream().mapToInt(UserVO :: getAge);
			stream.forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("testMap =====> ", e);
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
	public void testMapToLong() {
		try {
			/*
			 * mapToLong 转换成long
			 */
			LongStream stream = vos.stream().mapToLong(UserVO :: getAge);
			stream.forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("testMapToLong =====> ", e);
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
	public void testMapToDouble() {
		try {
			/*
			 * mapToLong 转换成long
			 */
			DoubleStream stream = vos.stream().mapToDouble(UserVO :: getAge);
			stream.forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("testMapToDouble =====> ", e);
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
	public void testFlatMap() {
		try {
			/**
			 * flat: 使扁平化，将一个流拉平了
			 * 原先流中某个字段存在stream结构的话，可以通过这个方法拉平.
			 * 将列表中的列表 全部连接起来，输出一个完整列表
			 */
			Stream<String> values = vos.stream().flatMap(x -> x.getLastLoginIps().stream());
			values.forEach(System.out :: println);
			
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
	public void testFlatMapToInt() {
		try {
			/**
			 * 将列表中的列表 全部连接起来，输出一个完整列表
			 */
			List<Integer> ids1 = Arrays.asList(1, 2, 4, 7);
			List<Integer> ids2 = Arrays.asList(10, 21, 42, 17);
			List<Integer> ids3 = Arrays.asList(23, 26, 40, 56);
			final List<List<Integer>> nestValues = Arrays.asList(ids1, ids2, ids3);
			// 将列表中的列表连接起来
			IntStream stream = nestValues.stream().flatMapToInt(x -> x.stream().flatMapToInt(y -> IntStream.of(y)));
			stream.forEach(System.out :: println);
		} catch (Exception e) {
			log.error("testFlatMapToInt =====> ", e);
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
	public void testFlatMapToLong() {
		try {
			/**
			 * 将列表中的列表 全部连接起来，输出一个完整列表
			 */
			List<Long> ids1 = Arrays.asList(1L, 2L, 4L, 7L);
			List<Long> ids2 = Arrays.asList(10L, 21L, 42L, 17L);
			List<Long> ids3 = Arrays.asList(23L, 26L, 40L, 56L);
			final List<List<Long>> nestValues = Arrays.asList(ids1, ids2, ids3);
			// 将列表中的列表连接起来
			LongStream stream = nestValues.stream().flatMapToLong(x -> x.stream().flatMapToLong(y -> LongStream.of(y)));
			stream.forEach(System.out :: println);
		} catch (Exception e) {
			log.error("testFlatMapToLong =====> ", e);
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
	public void testFlatMapToDouble() {
		try {
			/**
			 * 将列表中的列表 全部连接起来，输出一个完整列表
			 */
			List<Double> ids1 = Arrays.asList(1D, 2D, 4D, 7D);
			List<Double> ids2 = Arrays.asList(10D, 21D, 42D, 17D);
			List<Double> ids3 = Arrays.asList(23D, 26D, 40D, 56D);
			final List<List<Double>> nestValues = Arrays.asList(ids1, ids2, ids3);
			// 将列表中的列表连接起来
			DoubleStream stream = nestValues.stream().flatMapToDouble(x -> x.stream().flatMapToDouble(y -> DoubleStream.of(y)));
			stream.forEach(System.out :: println);
		} catch (Exception e) {
			log.error("testFlatMapToDouble =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 去重
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testDistinct() {
		try {
			List<String> values = Arrays.asList("1", "2", "3", "1", "3", "34", "43", "3");
			values.stream().distinct().forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("testDistinct =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 排序
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testSorted() {
		try {
			List<Integer> values = Arrays.asList(2, 1, 3, 1, 3, 34, 43, 12);
			values.stream().sorted().forEach(System.out :: println);
			System.out.println("==============");
			// 先去重再排序
			values.stream().distinct().sorted().forEach(System.out :: println);
		} catch (Exception e) {
			log.error("testSorted =====> ", e);
		}
	}	

	/**
	 * 
	 * 描述: 排序
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testSortedWithComparator() {
		try {
			vos.stream().sorted((x, y) -> x.getId().compareTo(y.getId())).forEach(x -> System.out.println(x.getRemark()));
			System.out.println("==============");
			Stream<String> ids = vos.stream().sorted((x, y) -> x.getId().compareTo(y.getId())).map(x -> x.getId());
			ids.forEach(System.out :: println);
		} catch (Exception e) {
			log.error("testSortedWithComparator =====> ", e);
		}
	}		
	
	/**
	 * 
	 * 描述: 查看第一个
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testPeek() {
		try {
			/*
			 * peek: 顾名思义，窥视、偷看，在某个stream之间插入干预
			 * peek设计为调试用的方法，必须进行一次处理，然后生成新的流
			 */
			//vos.stream().peek(System.out :: println);
			//vos.stream().filter(UserVO :: getValid).peek(e -> System.out.println(e));
			// 正常的: 
			Stream.of("one", "two", "three", "four").filter(x -> x.length() > 3).map(String :: toUpperCase).forEach(System.out :: println);
			// 调试的: 
			Stream.of("one", "two", "three", "four").filter(x -> x.length() > 3).peek(System.out :: println).map(String :: toUpperCase).forEach(System.out :: println);
		} catch (Exception e) {
			log.error("testPeek =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 截取指定长度数据
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testLimit() {
		try {
			vos.stream().limit(2).forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("testLimit =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 跳过指定长度的
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testSkip() {
		try {
			// 等于0 表示不跳过
			//vos.stream().skip(0).forEach(System.out :: println);
			vos.stream().skip(2).forEach(System.out :: println);
		} catch (Exception e) {
			log.error("testSkip =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 迭代处理
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testForEach() {
		try {
			/*
			 * 使用消费者型函数
			 */
			vos.stream().forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 迭代处理
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testForEachOrderd() {
		try {
			/*
			 * 使用消费者型函数 TODO 用法尚未明确
			 */
			vos.stream().forEachOrdered(System.out :: println);
			
		} catch (Exception e) {
			log.error("testForEachOrderd =====> ", e);
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
	public void testToArray() {
		try {
			Object[] arr1 = vos.stream().toArray();
			for (Object e : arr1)
			{
				System.out.println(e);
			}
			
		} catch (Exception e) {
			log.error("testToArray =====> ", e);
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
	public void testToArray2() {
		try {
			/*
			 * IntFunction 填充多个元素，返回一个数组
			 */
			UserVO[] arr = vos.stream().toArray(UserVO[] :: new);
			System.out.println(arr.length);
			
		} catch (Exception e) {
			log.error("testToArray2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 两两比较，整合输出结果
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testReduce1() {
		try {
			// reduce: 归纳、汇总
			vos.stream().reduce((x, y) -> {
				if (x.getAge() > y.getAge())
				{
					return x;
				}
				
				return y;
			}).ifPresent(System.out :: println);
			
		} catch (Exception e) {
			log.error("testReduce1 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 两两比较，整合输出结果
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testReduce2() {
		try {
			UserVO vo = new UserVO();
			vo.setId("20191201");
			vo.setAge(20);
			vo.setUsername("李四");
			vo.setGmtCreate(LocalDateTime.now());
			vo.setGmtUpdate(LocalDateTime.now());
			vo.setValid(true);
			vo.setAddress(AddressVO.builder().detailValue("广西省桂林市阳朔县").postalcode("12456").build());
			vo.setLastLoginIps(Arrays.asList("192.168.1.4", "192.168.1.5"));
			UserVO vo2 = vos.stream().reduce(vo, (x, y) -> {
				if (x.getAge() > vo.getAge())
				{
					return x;
				}
				
				return y;
			});
			System.out.println(vo2);
			
		} catch (Exception e) {
			log.error("testReduce2 =====> ", e);
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
	public void testCollect() {
		try {
			List<UserVO> vos2 = vos.stream().collect(Collectors.toList());
			List<String> ids = vos.stream().map(UserVO :: getId).collect(Collectors.toList());
			ids.forEach(System.out :: println);
			
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
	//@DisplayName("test")
	@Test
	public void testCollect2() {
		try {
			// TODO
			List<UserVO> vos2 = vos.stream().collect(Collectors.toList());
			//List<String> ids = vos.stream().map(UserVO :: getId).collect(UserVO :: new, (x, y) -> {}, (x, y) -> {});
			//ids.forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("testCollect2 =====> ", e);
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
	public void testMin() {
		try {
			
			vos.stream().min((x, y) -> x.getAge() - y.getAge()).ifPresent(System.out :: println);
			
		} catch (Exception e) {
			log.error("testMin =====> ", e);
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
	public void testMax() {
		try {
			vos.stream().max((x, y) -> x.getAge() - y.getAge()).ifPresent(System.out :: println);
		} catch (Exception e) {
			log.error("testMax =====> ", e);
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
	public void testFindAny() {
		try {
			Optional<UserVO> optional = vos.stream().findAny();
			optional.ifPresent(x -> System.out.println(x.getRemark()));
			
		} catch (Exception e) {
			log.error("testFindAny =====> ", e);
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
	public void testFindFirst() {
		try {
			Optional<UserVO> optional = vos.stream().findFirst();
			optional.ifPresent(x -> System.out.println(x.getRemark()));
			
		} catch (Exception e) {
			log.error("testFindFirst =====> ", e);
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
	public void testMapToList() {
		try {
			List<String> ids = vos.stream().map(x -> x.getId()).collect(Collectors.toList());
			
			
		} catch (Exception e) {
			log.error("testMapToList =====> ", e);
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
	public void testCount() {
		try {
			System.out.println(vos.stream().count());
			
		} catch (Exception e) {
			log.error("testCount =====> ", e);
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
	public void testEmpty() {
		try {
			Stream<SomeThing> emptyStream =  Stream.empty();
			System.out.println(emptyStream.count());
			
		} catch (Exception e) {
			log.error("testEmpty =====> ", e);
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
	public void testOf() {
		try {
			Stream<Integer> stream1 = Stream.of(2);
			Stream<Integer> streams = Stream.of(2, 3);
			
		} catch (Exception e) {
			log.error("testOf =====> ", e);
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
	public void testGenerate() {
		try {
			Stream<UserVO> stream1 = Stream.generate(() -> new UserVO());
			Stream<UserVO> stream2 = Stream.generate(UserVO :: new);
			
		} catch (Exception e) {
			log.error("testGenerate =====> ", e);
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
	public void testConcat() {
		try {
			Stream<Integer> stream1 = Stream.of(2);
			Stream<Integer> streams = Stream.of(2, 3);
			
			Stream<Integer> stream2 = Stream.concat(stream1, streams);
			List<Integer> list = stream2.collect(Collectors.toList());
			
			list.forEach(System.out :: println);
			
		} catch (Exception e) {
			log.error("testConcat =====> ", e);
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
	public void testAllMatch() {
		try {
			//System.out.println(vos.stream().allMatch(x -> x.getValid()));
			
			System.out.println(vos.stream().allMatch(UserVO :: getValid));
			
			//System.out.println(vos.stream().allMatch(EmptyUtil :: isEmpty));
			
			//System.out.println(vos.stream().allMatch());
			
		} catch (Exception e) {
			log.error("testAllMatch =====> ", e);
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
	public void testNoneMatch() {
		try {
			//System.out.println(vos.stream().noneMatch(x -> x.getValid()));
			
			//System.out.println(vos.stream().noneMatch(UserVO :: getValid));
			
			System.out.println(vos.stream().noneMatch(EmptyUtil :: isEmpty));
			
			//System.out.println(vos.stream().allMatch());
			
		} catch (Exception e) {
			log.error("testAllMatch =====> ", e);
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
