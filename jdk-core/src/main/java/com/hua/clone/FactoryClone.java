/**
  * @filename FactoryClone.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.clone;

import lombok.Data;

/**
 * @type FactoryClone
 * @description 
 * @author qianye.zheng
 */
@Data
public class FactoryClone implements Cloneable {

	
	private int value;
	
	/**
	 * @description 
	 * @return
	 * @throws CloneNotSupportedException
	 * @author qianye.zheng
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
