/**
  * @filename BuilderExample.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import lombok.Builder;

/**
 * @type BuilderExample
 * @description 
 * @author qianye.zheng
 */
@Builder
public class BuilderExample
{
	/*
	 * @Builder
	 * 提供了推荐的构建值对象的方式
	 * 
	 *
	 */
	private String name;
	
	private String address;
	
}
