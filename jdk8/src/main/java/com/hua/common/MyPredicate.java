/**
  * @filename MyPredicate.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.common;

import com.hua.entity.User;

 /**
 * @type MyPredicate
 * @description 
 * @author qianye.zheng
 */
// 标注为函数式接口，编译器会检查
@FunctionalInterface
public interface MyPredicate
{
	
	/**
	 * 
	 * @description 
	 * @param user
	 * @return
	 * @author qianye.zheng
	 */
	boolean test(final User user);
	
	
	//boolean test2(final User user);
}
