/**
 * ExtendsAbstractClassGenericTwo.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.generic;

/**
 * ExtendsAbstractClassGenericTwo
 * 描述: 当前类选择[部分]实例化父类的泛型变量
 * @author  qye.zheng
 */
public class ExtendsAbstractClassGenericTwo<K, P> 
extends AbstractClassGeneric<String, K> implements InterfaceGeneric<String, K, P>
{

	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @param k
	 * @return
	 */
	@Override
	public String print(K k)
	{
		return null;
	}

	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @param id
	 * @param k
	 * @return
	 */
	@Override
	public String football(String id, K k)
	{
		return null;
	}

	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @param k
	 * @param t
	 * @return
	 */
	@Override
	public K get(K k, String t)
	{
		return null;
	}

	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @param u
	 * @return
	 */
	@Override
	public <U, M> M how(U u)
	{
		return null;
	}

	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @param k
	 * @return
	 */
	@Override
	public P you(K k)
	{
		return null;
	}

}
