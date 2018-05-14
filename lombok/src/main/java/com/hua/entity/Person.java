/**
  * @filename Person.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import java.sql.Timestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @type Person
 * @description 
 * @author qianye.zheng
 */
/*
 * @ToString() 生成 该类的toString方法
 * 默认格式为 ClassName(filedName=filedValue, ...)
 * exclude 忽略的字段数组
 */
@ToString(callSuper = true, exclude = {"username"})
/*
 * @EqualsAndHashCode 注解
 * 
 */
@EqualsAndHashCode(callSuper = false, exclude = {"nickname"})
// 无参是默认存在的，因此无需加注解，除非只有无参构造方法
//@NoArgsConstructor
// 指定参数
@RequiredArgsConstructor()
// 全部参数
@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@Data
public class Person extends BaseEntity
{
	
	/*
	 * @Data 注解就是其他注解的集合，
	 */
	
/**
 * 通过
 * 	@Getter
	@Setter
	注解来省略getter/setter方法
 */
	
	/*
	 * @NoArgsConstructor 无参构造器
	 * @RequiredArgsConstructor 指定参数构造器
	 * @AllArgsConstructor 包含所有参数构造器
	 * 
	 * RequiredArgsConstructor 和 AllArgsConstructor 可以并存
	 */
	
	private static final long serialVersionUID = 3266226087762001717L;

	@Getter
	@Setter
	/* 登录-用户名 (唯一) */
	private String username;
	
	@Getter
	@Setter
	/* 昵称 (用于显示) */
	private String nickname;
	
	@Getter
	@Setter
	/* 登录-密码 */
	private String password;
	
	@Getter
	@Setter
	/* 用户类型 */
	private UserType type;
	
	@Getter
	@Setter
	/* 用户状态 - 是否有效 默认 : 有效 */
	private boolean valid = true;
	
	@Getter
	@Setter
	/* 上一次登录-时间 */
	private Timestamp lastLoginTime;
	
	@Getter
	@Setter
	/* 上一次登录-IP地址 */
	private String lastLoginIp;
	
	@Getter
	@Setter
	/* 年龄 */
	private Integer age;
	
}
