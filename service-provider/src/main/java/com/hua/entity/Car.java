/**
  * @filename Car.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import java.time.LocalDate;

import lombok.Data;

/**
 * @type Car
 * @description 
 * @author qianye.zheng
 */
@Data
public class Car {

	/* 名称 */
	private String name;
	
	/* 长度 */
	private double length;
	
	/* 宽度 */
	private double width;
	
	/* 重量 */
	private double weight;
	
	/* 出厂日期 */
	private LocalDate leaveFactoryDate;
	
	
}
