/**
 * AbstractClassGeneric.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.generic;

/**
 * AbstractClassGeneric
 * 描述: 
 * @author  qye.zheng
 */
public abstract class AbstractClassGeneric<T, K>
{
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @param k 参数为类型K
	 * @return 返回值类型 T
	 */
	public abstract T print(final K k);
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @param t 参数为类型T
	 * @param u 参数为当前方法声明的类型U
	 * @return 返回类型K
	 */
	@SuppressWarnings(value = {"unused"})
	public <U> K start(final T t, final U u)
	{
		K k = null;
		U hh = null;
		
		return k;
	}
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @param t 参数为类型T
	 * @param u 参数为当前方法声明的类型U
	 * @return 返回值为当前方法声明的类型U
	 */
	@SuppressWarnings(value = {"unused"})
	public <U> U make(final T t, final U u)
	{
		K k = null;
		U uu = null;
		
		return uu;
	}
	
	/**
	 * 
	 * 
	 * 描述: 静态方法只能使用自身声明的泛型变量
	 * 不能使用类或接口级声明的泛型变量
	 * @author  qye.zheng
	 * @param m 参数为当前方法声明的类型M
	 * @param u 参数为当前方法声明的类型U
	 * @return 返回值为当前方法声明的类型U
	 */
	@SuppressWarnings(value = {"unused"})
	public  static <U, M, N> U go(final M m, final U u)
	{
		N n = null;
		U uu = null;
		
		System.out.println("m = " + m);
		System.out.println("u = " + u);
		
		return uu;
	}
	
	/**
	 * 
	 * 描述: 根据接收方来实例化泛型变量
	 * @author  qye.zheng
	 * @param clazz 通过传入的class对象来创建对象
	 * @return
	 */
	public static <E> E returnType(final Class<E> clazz)
	{
		E e = null;
		try
		{
			e = clazz.newInstance();
		} catch (InstantiationException e1)
		{
			e1.printStackTrace();
		} catch (IllegalAccessException e1)
		{
			e1.printStackTrace();
		}
		
		return e;
	}
	
}
