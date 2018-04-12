/**
 * 描述: 
 * User.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.entity;

import java.sql.Timestamp;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * User
 */
public final class User extends BaseEntity {

	/* 静态公开属性 */
	public static int staticInt;
	
	/* 实例公开属性 */
	public int number;
	
	/* default权限 */
	int defaultInt;
	
	/* protected权限 */
	protected int protectedInt;
	
	 /* long */
	private static final long serialVersionUID = 1L;
	
	/* 登录-用户名 (唯一) */
	private String username;
	
	/* 昵称 (用于显示) */
	private String nickname;
	
	/* 登录-密码 */
	private String password;
	
	/* 用户类型 */
	private UserType type;
	
	/* 用户状态 - 是否有效 默认 : 有效 */
	private boolean isValid = true;
	
	/* 上一次登录-时间 */
	private Timestamp lastLoginTime;
	
	/* 上一次登录-IP地址 */
	private String lastLoginIp;
	
	/** 无参构造方法 */
	public User() {}

	/**
	 * 
	 * 构造方法
	 * 描述: 
	 * @author qye.zheng
	 * @param username
	 * @param password
	 */
	public User(String username, String password)
	{
		super();
		this.username = username;
		this.password = password;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the type
	 */
	public UserType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(UserType type) {
		this.type = type;
	}

	/**
	 * @return the lastLoginTime
	 */
	public Timestamp getLastLoginTime()
	{
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Timestamp lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the lastLoginIp
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname()
	{
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	/**
	 * @return the isValid
	 */
	public boolean isValid()
	{
		return isValid;
	}

	/**
	 * @param isValid the isValid to set
	 */
	public void setValid(boolean isValid)
	{
		this.isValid = isValid;
	}
	
	/**
	 * 
	 * 描述: 静态公开方法
	 * @author  qye.zheng
	 */
	public static void publicStaticMethod()
	{
		System.out.println("User.publicStaticMethod()");
	}
	
	/**
	 * 
	 * 描述: default权限方法
	 * @author  qye.zheng
	 */
	 void staticMethod()
	{
		System.out.println("User.staticMethod()");
	}
	
	 /**
	  * 
	  * 描述: 保护权限方法
	  * @author  qye.zheng
	  */
	 protected void protectedMethod()
	 {
		 System.out.println("User.protectedMethod()");
	 }
	 
	/**
	 * 
	 * 描述: 静态私有方法 
	 * @author  qye.zheng
	 */
	@SuppressWarnings(value = {"unused"})
	private static void userStaticPrivateMethod()
	{
		
	}
	
	/**
	 * 
	 * 描述: 私有的有返回值的方法
	 * @author  qye.zheng
	 * @param one
	 * @param two
	 * @return
	 */
	@SuppressWarnings(value = {"unused"})
	private String privateStringMethod(final Integer one, final String two)
	{
		return two + ": " + one;
	}
	
	
}
