/**
  * @filename CarFactory.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.target;

import com.hua.util.RandomUtil;

/**
 * @type CarFactory
 * @description 汽车工厂
 * @author qianye.zheng
 */
public class CarFactory implements IFactory, IBuyService {

	/**
	 * @description 
	 * @param ticket
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public Boolean entry(String ticket) {
		return true;
	}

	/**
	 * @description 
	 * @param typeId
	 * @author qianye.zheng
	 */
	@Override
	public void manufacture(int typeId) {
		System.out.println("一辆汽车，型号ID: " + typeId);
	}

	/**
	 * @description 
	 * @param typeId
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public double query(int typeId) {
		return Integer.hashCode(typeId) + RandomUtil.nextInt(1000) * 4.0;
	}

	/**
	 * @description 
	 * @param typeId
	 * @param price
	 * @author qianye.zheng
	 */
	@Override
	public void buy(int typeId, double price) {
		System.out.println("购买: " + typeId + ", 价格: " + price);
	}

}
