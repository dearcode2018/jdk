/**
  * @filename CarFactory.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.spi;

import com.hua.entity.Car;

/**
 * @type CarFactory
 * @description 汽车工厂
 * @author qianye.zheng
 */
public interface CarFactory {

	
	/**
	 * 
	 * @description 制造汽车
	 * @return
	 * @author qianye.zheng
	 */
	Car manufacture();
	
	/**
	 * 
	 * @description 保养/维修汽车
	 * @param car
	 * @author qianye.zheng
	 */
	void maintain(final Car car);
	
}
