/**
  * @filename IFactory.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.target;

/**
 * @type IFactory
 * @description 
 * @author qianye.zheng
 */
public interface IFactory {

	/**
	 * 
	 * @description 进入工厂
	 * @param ticket 凭证
	 * @return 是否允许进入
	 * @author qianye.zheng
	 */
	Boolean entry(final String ticket);
	
	/**
	 * 
	 * @description 生产
	 * @param typeId 商品类型ID
	 * @author qianye.zheng
	 */
	void manufacture(final int typeId);
	
	/**
	 * 
	 * @description 查询商品价格
	 * @param typeId 商品类型ID
	 * @return 商品价格
	 * @author qianye.zheng
	 */
	double query(final int typeId);
}
