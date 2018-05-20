/**
  * @filename Good2.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.jdk;

 /**
 * @type Good2
 * @description 
 * @author qianye.zheng
 */
public class Good2 implements DefaultMethod, DefaultMethod2
{
	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String getName()
	{
		return DefaultMethod.super.getName();
	}
}
