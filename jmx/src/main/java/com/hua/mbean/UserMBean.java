/**
  * @filename UserMBean.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.mbean;

import java.sql.Timestamp;

import com.hua.constant.sys.UserType;

 /**
 * @type UserMBean
 * @description  
 * @author qianye.zheng
 */
public interface UserMBean {

	/**
	 * 有 get方法没有set方法 表示只读，通过get/set方法
	 * 来控制读写
	 * 原始Bean类名 + MBean
	 * 包含在MBean中的方法是可以被管理的.
	 */
	
	/**
	 * @return the username
	 */
	public String getUsername();

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username);

	/**
	 * @return the password
	 */
	public String getPassword();

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password);

	/**
	 * @return the type
	 */
	public UserType getType();

	/**
	 * @param type the type to set
	 */
	public void setType(UserType type);

	/**
	 * @return the lastLoginTime
	 */
	public Timestamp getLastLoginTime();

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Timestamp lastLoginTime);

	/**
	 * @return the lastLoginIp
	 */
	public String getLastLoginIp();

	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(String lastLoginIp);

	/**
	 * @return the nickname
	 */
	public String getNickname();

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname);

	/**
	 * @return the valid
	 */
	public boolean isValid();

	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid);
}
