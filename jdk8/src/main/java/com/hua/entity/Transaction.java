/**
  * @filename Transaction.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

 /**
 * @type Transaction
 * @description 
 * @author qianye.zheng
 */
public class Transaction
{

	private Trader trader;
	
	private Integer year;
	
	private Integer value;

	/**
	 * @description 构造方法
	 * @param trader
	 * @param year
	 * @param value
	 * @author qianye.zheng
	 */
	public Transaction(Trader trader, Integer year, Integer value)
	{
		super();
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	/**
	 * @return the trader
	 */
	public final Trader getTrader()
	{
		return trader;
	}

	/**
	 * @param trader the trader to set
	 */
	public final void setTrader(Trader trader)
	{
		this.trader = trader;
	}

	/**
	 * @return the year
	 */
	public final Integer getYear()
	{
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public final void setYear(Integer year)
	{
		this.year = year;
	}

	/**
	 * @return the value
	 */
	public final Integer getValue()
	{
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public final void setValue(Integer value)
	{
		this.value = value;
	}
	
	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String toString()
	{
		return trader.toString() + ", [year] = " + year + ", [value] = " + value;
	}
	
}
