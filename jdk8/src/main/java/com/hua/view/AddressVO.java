/**
  * @filename AddressVO.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.view;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @type AddressVO
 * @description 地址
 * @author qianye.zheng
 */
@Data
@EqualsAndHashCode(callSuper=false)
@Builder
public class AddressVO extends BaseVO
{

	/* 邮政编码 */
	private String postalcode;
	
	/* 简短地址值 */
	private String shortValue;
	
	/* 详细地址值 */
	private String detailValue;
	
}
