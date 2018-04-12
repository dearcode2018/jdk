/**
 * ExtendsAbstractClassGenericOne.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.generic;

/**
 * ExtendsAbstractClassGenericOne
 * 描述: 当前类选择全部保持父类的泛型变量声明
 * @author  qye.zheng
 * @param <T>
 * @param <K>
 */
public class ExtendsAbstractClassGenericOne<T, K, P> 
extends AbstractClassGeneric<T, K> implements InterfaceGeneric<T, K, P>
{

	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @param k
	 * @return
	 */
	@Override
	public T print(K k)
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
	public T football(String id, K k)
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
	public K get(K k, T t)
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
