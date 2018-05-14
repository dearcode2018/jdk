/**
  * @filename MyResource.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.lombok;

 /**
 * @type MyResource
 * @description 
 * @author qianye.zheng
 */
public class MyResource
{
	
	
	/**
	 * 
	 * @description 关闭资源
	 * @author qianye.zheng
	 */
	public void close()
	{
		System.out.println("MyResource.close()");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void close2()
	{
		System.out.println("MyResource.close2()");
	}
}
