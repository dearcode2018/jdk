/**
 * 描述: 
 * UserVO.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.view;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hua.constant.FormatConstant;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * UserVO
 */
@Data
@EqualsAndHashCode(callSuper=false)
public final class UserVO extends BaseVO implements Comparable<UserVO> {

	/* 登录-用户名 (唯一) */
	private String username;
	
	/* 昵称 (用于显示) */
	private String nickname;
	
	/* 年龄 */
	private Integer age;
	
	private AddressVO address;
	
	/* 登录-密码 */
	private String password;
	
	/* 用户状态 - 是否有效 默认 : 有效 */
	private Boolean valid;
	
	/* 上一次登录-时间 */
    @JsonFormat(pattern= FormatConstant.DATE_TIME_FORMAT_yyyy_MM_dd_HH_mm_ss, timezone = FormatConstant.TIME_ZONE)
	private LocalDateTime lastLoginTime;
	
	/* 登录-IP地址列表 */
	private List<String> lastLoginIps;
	
	private String remark;
	
	/** 无参构造方法 */
	public UserVO() {}

	/**
	 * @description 构造方法
	 * @param username
	 * @author qianye.zheng
	 */
	public UserVO(String username)
	{
		super();
		this.username = username;
	}
	
	/**
	 * 
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	public String getRemark()
	{
		remark = "id = " + getId() + ", username = " +username + ", age = " + age + ", valide = " + valid + ", address = " + address.getDetailValue();
		
		return remark;
	}

	/**
	 * @description 
	 * @param o
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int compareTo(UserVO o)
	{
		return this.getId().compareTo(o.getId());
	}
	
}
