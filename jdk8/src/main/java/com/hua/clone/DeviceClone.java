/**
  * @filename DeviceClone.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.clone;

import java.io.Serializable;

import lombok.Data;

/**
 * @type DeviceClone
 * @description 
 * @author qianye.zheng
 */
@Data
public class DeviceClone implements Serializable {

	/**
	 * 通过序列化、反序列化来实现对象克隆
	 */
	
	private static final long serialVersionUID = 1L;

	private int value;
	
}
