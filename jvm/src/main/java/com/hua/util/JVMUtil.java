/**
 * JVMUtil.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import sun.misc.Unsafe;

/**
 * JVMUtil
 * 描述: 
 * @author  qye.zheng
 */
public final class JVMUtil
{

	/** 对象头部大小 */
	private static final int OBJECT_HEADER_SIZE = 8;
	
	/** 对象占用内存的最小值 */
	private static final int OBJECT_MINIMUM_SIZE = 8;
	
	/** 对象按多少字节的粒度进行对齐 */
	private static final int OBJECT_ALIGNMENT = 8;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	private JVMUtil()
	{
	}
	
	/**
	 * 
	 * @description 计算对象占用内存的大小
	 * 单位: 字节
	 * @param target
	 * @return
	 * @author qye.zheng
	 */
	public static final long sizeOf(final Object target)
	{
		if (null == target)
		{
			return -1L;
		}
		
		Unsafe unsafe = null;
		try {
			final Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
			unsafeField.setAccessible(true);
			unsafe = (Unsafe) unsafeField.get(null);
			// 判断是否为数组
			if (target.getClass().isArray())
			{ // 数组
				Class<?> clazz = target.getClass();
				final int base = unsafe.arrayBaseOffset(clazz);
				final int scale = unsafe.arrayIndexScale(clazz);
				long size = base + (scale * Array.getLength(target));
				if (0 != (size % OBJECT_ALIGNMENT))
				{
					size += OBJECT_ALIGNMENT - (size % OBJECT_ALIGNMENT);
				}
				
				return Math.max(OBJECT_MINIMUM_SIZE, size);
			} else
			{ // 非数组
				// 如果不是数组对象则迭代遍历该对象的父类，找到最后一个非静态字段的偏移量
				for (Class<?> clazz = target.getClass(); null != clazz; clazz = clazz.getSuperclass())
				{
					long lastFieldOffset = -1L;
					for (Field field : clazz.getDeclaredFields())
					{
						if (!Modifier.isStatic(field.getModifiers()))
						{ // 非静态
							lastFieldOffset = Math.max(lastFieldOffset, unsafe.objectFieldOffset(field));
						}
					}
					if (lastFieldOffset > 0L)
					{
						lastFieldOffset += 1L;
						if (0 != (lastFieldOffset % OBJECT_ALIGNMENT))
						{
							lastFieldOffset += OBJECT_ALIGNMENT - (lastFieldOffset - OBJECT_ALIGNMENT);
						}
						
						return Math.max(OBJECT_MINIMUM_SIZE, lastFieldOffset);
					}
				}
				
				// 该对象没有任何属性
				long size = OBJECT_HEADER_SIZE;
				if (0 != (size % OBJECT_ALIGNMENT))
				{
					size += OBJECT_ALIGNMENT - (size % OBJECT_ALIGNMENT);
				}
				
				  return Math.max(OBJECT_MINIMUM_SIZE, size);  
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0L;
	}

}
