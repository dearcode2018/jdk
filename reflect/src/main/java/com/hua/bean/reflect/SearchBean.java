/**
 * SearchBean.java
 * @author  qye.zheng
 * 	version 1.0
 */
package com.hua.bean.reflect;

import java.sql.Date;

/**
 * SearchBean
 * 描述: 搜索参数
 * @author  qye.zheng
 */
public class SearchBean
{

	private String id;
	
	private Boolean flag;
	
	private Byte bt;
	
	private Character ch;
	
	private Short sh;
	
	private Integer in;
	
	private Float fl;
	
	private Long lon;
	
	private Double db;
	
	private Date date;
	
	private java.util.Date dateTime;
	
	private int i;
	
	/**
	 * 构造方法
	 * 描述: 
	 * @author  qye.zheng
	 */
	public SearchBean()
	{
	}

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * @return the flag
	 */
	public Boolean getFlag()
	{
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(Boolean flag)
	{
		this.flag = flag;
	}

	/**
	 * @return the bt
	 */
	public Byte getBt()
	{
		return bt;
	}

	/**
	 * @param bt the bt to set
	 */
	public void setBt(Byte bt)
	{
		this.bt = bt;
	}

	/**
	 * @return the ch
	 */
	public Character getCh()
	{
		return ch;
	}

	/**
	 * @param ch the ch to set
	 */
	public void setCh(Character ch)
	{
		this.ch = ch;
	}

	/**
	 * @return the sh
	 */
	public Short getSh()
	{
		return sh;
	}

	/**
	 * @param sh the sh to set
	 */
	public void setSh(Short sh)
	{
		this.sh = sh;
	}

	/**
	 * @return the in
	 */
	public Integer getIn()
	{
		return in;
	}

	/**
	 * @param in the in to set
	 */
	public void setIn(Integer in)
	{
		this.in = in;
	}

	/**
	 * @return the fl
	 */
	public Float getFl()
	{
		return fl;
	}

	/**
	 * @param fl the fl to set
	 */
	public void setFl(Float fl)
	{
		this.fl = fl;
	}

	/**
	 * @return the lon
	 */
	public Long getLon()
	{
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(Long lon)
	{
		this.lon = lon;
	}

	/**
	 * @return the db
	 */
	public Double getDb()
	{
		return db;
	}

	/**
	 * @param db the db to set
	 */
	public void setDb(Double db)
	{
		this.db = db;
	}

	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}

	/**
	 * @return the i
	 */
	public int getI()
	{
		return i;
	}

	/**
	 * @param i the i to set
	 */
	public void setI(int i)
	{
		this.i = i;
	}

	/**
	 * @return the dateTime
	 */
	public java.util.Date getDateTime()
	{
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(java.util.Date dateTime)
	{
		this.dateTime = dateTime;
	}
	

}
