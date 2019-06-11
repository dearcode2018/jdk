/**
 * SomeThing.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.call;

/**
 * SomeThing
 * 描述: 
 * @author  qye.zheng
 */
public final class SomeThing
{

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public SomeThing()
	{
	}
	
	/**
	 * 
	 * @description 函数式
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	public static final Boolean isFlag(final String value)
	{
		return false;
	}
	
	/**
	 * 
	 * @description 生产型
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	public static final Boolean isFlag()
	{
		return false;
	}
	
	/**
	 * 
	 * @description 消费型
	 * @param value
	 * @return
	 * @author qianye.zheng
	 */
	public static final void isFlag2(final String value)
	{
		System.out.println("SomeThing.isFlag2()");
	}
	
	/**
	 * 
	 * @description 
	 * @param value
	 * @author qianye.zheng
	 */
	public void consume(final String value)
	{
		System.out.println("SomeThing.consume()" + value);
	}

}
