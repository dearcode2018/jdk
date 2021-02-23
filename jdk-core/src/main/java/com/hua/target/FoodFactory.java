/**
  * @filename FoodFactory.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.target;

import com.hua.util.RandomUtil;

/**
 * @type FoodFactory
 * @description 食品工厂
 * @author qianye.zheng
 */
public class FoodFactory implements IFactory {

	/**
	 * @description 
	 * @param ticket
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Boolean entry(String ticket) {
		return false;
	}

	/**
	 * @description 
	 * @param typeId
	 * @author qianye.zheng
	 */
	@Override
	public void manufacture(int typeId) {
		System.out.println("一份食品，型号ID: " + typeId);
	}

	/**
	 * @description 
	 * @param typeId
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public double query(int typeId) {
		return Integer.hashCode(typeId) + RandomUtil.nextInt(50) * 2.0;
	}

}
