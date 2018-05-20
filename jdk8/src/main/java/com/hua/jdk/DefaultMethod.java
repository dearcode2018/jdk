/**
  * @filename DefaultMethod.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.jdk;

 /**
 * @type DefaultMethod
 * @description 
 * @author qianye.zheng
 */
public interface DefaultMethod
{
	
	/**
	 * 接口默认方法-类优先原则:
	 * 若一个接口定义了一个默认方法，而另外一个父类或接口中又定义了一个同名
	 * 方法时:
	 * 1) 选择父类中的方法
	 * 2) 接口冲突
	 */
		
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	default String getName()
	{
		return "DefaultMethod hahax";
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public static void show()
	{
		System.out.println("DefaultMethod.show()");
	}
	
}
