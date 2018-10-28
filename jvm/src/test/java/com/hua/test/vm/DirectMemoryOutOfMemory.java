/**
  * @filename DirectMemoryOutOfMemory.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.test.vm;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * @type DirectMemoryOutOfMemory
 * @description 
 * @author qianye.zheng
 */
public class DirectMemoryOutOfMemory
{

	/**
	 * @description 
	 * VM参数: -XX:MaxDirectMemorySize=5M
	 * @param args
	 * @author qianye.zheng
	 */
	public static void main(String[] args)
	{
		int count = 0;
		try
		{
			Field field = Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			Unsafe unsafe = (Unsafe) field.get(null);
			while (true)
			{ // 1M
				unsafe.allocateMemory(1 * 1012 * 1024);
				count++;
			}
			
		} catch (Exception e)
		{
			System.out.println("Exception: instance create: " + count);
			e.printStackTrace();
		} catch (Error e)
		{
			System.out.println("Error: instance create: " + count);
			e.printStackTrace();
		}
	}

}
