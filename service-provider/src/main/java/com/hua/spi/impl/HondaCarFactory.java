/**
  * @filename HondaCarFactory.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.spi.impl;

import java.time.LocalDate;

import com.hua.entity.Car;
import com.hua.spi.CarFactory;

/**
 * @type HondaCarFactory
 * @description 本田汽车厂商
 * @author qianye.zheng
 */
public class HondaCarFactory implements CarFactory {

	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Car manufacture() {
		final Car car = new Car();
		car.setName("本田雅阁 1.8T");
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
	public void maintain(Car car) {
		System.out.println("东风本田汽车公司，保养汽车: " + car.getName());
	}

}
