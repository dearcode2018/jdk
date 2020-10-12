/**
  * @filename IBuyService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.target;

 /**
 * @type IBuyService
 * @description 
 * @author qianye.zheng
 */
public interface IBuyService {

	/**
	 * 
	 * @description 购买
	 * @param typeId 商品类型ID
	 * @param price 价格
	 * @author qianye.zheng
	 */
	void buy(final int typeId, final double price);
	
}
