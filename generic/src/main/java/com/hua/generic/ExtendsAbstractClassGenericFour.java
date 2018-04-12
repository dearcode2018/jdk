/**
 * ExtendsAbstractClassGenericFour.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.generic;

/**
 * ExtendsAbstractClassGenericFour
 * 描述: 当前类选择[全部]实例化父类的泛型变量
 * @author  qye.zheng
 */
public class ExtendsAbstractClassGenericFour extends
		AbstractClassGeneric<Integer, Short> implements InterfaceGeneric<Integer, Short, Byte>
{

	/**
	 * 描述: 
	 * @author  qye.zheng
	 * @param k
	 * @return
	 */
	@Override
	public Integer print(Short k)
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
	public Integer football(String id, Short k)
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
	public Short get(Short k, Integer t)
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
	public Byte you(Short k)
	{
		return null;
	}

}
