/**
 * SystemException.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.exception.ext;

/**
 * SystemException
 * 描述: 系统 - 已检查 异常
 * @author  qye.zheng
 */
public final class SystemException extends Exception
{

	private static final long serialVersionUID = 1L;

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public SystemException()
	{
	}

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * @param message
	 */
	public SystemException(final String message)
	{
		super(message);
	}

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * @param cause
	 */
	public SystemException(final Throwable cause)
	{
		super(cause);
	}

	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 * @param message
	 * @param cause
	 */
	public SystemException(final String message, final Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * 
	 * 描述:  获取(第一个)触发点信息
	 * @author  qye.zheng
	 * @return
	 */
	public String getTriggerInfo()
	{
		final StackTraceElement first = getStackTrace()[0];
		
		return first.toString();
	}

}
