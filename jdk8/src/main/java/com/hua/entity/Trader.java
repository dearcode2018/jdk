/**
  * @filename Trader.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

 /**
 * @type Trader
 * @description 交易员
 * @author qianye.zheng
 */
public class Trader
{
	
	private String name;
	
	private String city;

	/**
	 * @description 构造方法
	 * @param name
	 * @param city
	 * @author qianye.zheng
	 */
	public Trader(String name, String city)
	{
		super();
		this.name = name;
		this.city = city;
	}

	/**
	 * @return the name
	 */
	public final String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the city
	 */
	public final String getCity()
	{
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public final void setCity(String city)
	{
		this.city = city;
	}
	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String toString()
	{
		return "[name] = " + name + ", [city] = " + city;
	}
	
}
