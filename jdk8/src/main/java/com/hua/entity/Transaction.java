/**
  * @filename Transaction.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import lombok.Data;

/**
 * @type Transaction
 * @description 
 * @author qianye.zheng
 */
@Data
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
