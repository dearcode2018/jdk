/**
 * GenericStudyUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.util.List;

/**
 * GenericStudyUtil
 * 描述: 
 * @author  qye.zheng
 */
public final class GenericStudyUtil
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private GenericStudyUtil()
	{
	}
	
	/**
	 * 
	 * 描述: ? extends MaxType
	 * @author  qye.zheng
	 * @param numberList
	 */
	public static void extendsRead(final List<? extends Number> numberList)
	{
		// 只读
	}
	
	/**
	 * 
	 * 描述: ? super MinType
	 * @author  qye.zheng
	 * @param numberList
	 */
	public static void superWrite(final List<? super Short> numberList)
	{
		// 只写
	}

}
