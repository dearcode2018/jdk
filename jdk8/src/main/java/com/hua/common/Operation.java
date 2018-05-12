/**
  * @filename Operation.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.common;

 /**
 * @type Operation
 * @description 
 * @author qianye.zheng
 */
@FunctionalInterface
public interface Operation<T>
{
	
	/**
	 * 
	 * @description 
	 * @param num
	 * @return
	 * @author qianye.zheng
	 */
	Integer getValue(final Integer num);
}
