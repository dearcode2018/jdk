/**
  * @filename ToyotaCarFactory.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.spi.impl;

import java.time.LocalDate;

import com.hua.entity.Car;
import com.hua.spi.CarFactory;

/**
 * @type ToyotaCarFactory
 * @description 丰田汽车厂商
 * @author qianye.zheng
 */
public class ToyotaCarFactory implements CarFactory {

	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Car manufacture() {
		final Car car = new Car();
		car.setName("丰田凯美瑞 2.0T");
		car.setWidth(2.5d);
		car.setLength(4.0d);
		car.setWeight(2.5d);
		car.setLeaveFactoryDate(LocalDate.now());
		
		return car;
	}

	/**
	 * @description 
	 * @param car
	 * @author qianye.zheng
	 */
	@Override
	public void maintain(final Car car) {
		System.out.println("一汽丰田汽车公司，保养汽车: " + car.getName());
	}

}
