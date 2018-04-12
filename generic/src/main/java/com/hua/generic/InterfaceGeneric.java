/**
 * InterfaceGeneric.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.generic;

/**
 * InterfaceGeneric
 * 描述: 
 * @author  qye.zheng
 */
public interface InterfaceGeneric<T, K, P>
{
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @param id
	 * @param k 使用类级声明的类型
	 * @return
	 */
	public T football(final String id, final K k);
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @param k 使用类级声明的类型
	 * @param t 使用类级声明的类型
	 * @return
	 */
	public K get(final K k, final T t);
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @param u
	 * @return 使用方法自身申明的类型
	 */
	public <U, M> M how(final U u);
	
	/**
	 * 
	 * 描述: 
	 * @author  qye.zheng
	 * @param k
	 * @return
	 */
	public P you(final K k);
	
	
}
