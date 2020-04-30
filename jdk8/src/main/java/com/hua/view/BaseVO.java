/**
  * @filename BaseVO.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.view;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hua.constant.FormatConstant;

import lombok.Data;

/**
 * @type BaseVO
 * @description 
 * @author qianye.zheng
 */
@Data
public abstract class BaseVO
{
	
	/* ID */
	private String id;
	
	/* 更新日期时间 */
    @JsonFormat(pattern= FormatConstant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss, timezone = FormatConstant.TIME_ZONE)
	private LocalDateTime gmtUpdate;
	
	/* 创建日期时间 */
    @JsonFormat(pattern= FormatConstant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss, timezone = FormatConstant.TIME_ZONE)
	private LocalDateTime gmtCreate;
	
	
	
}
