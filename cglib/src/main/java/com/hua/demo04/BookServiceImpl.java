/**
  * @filename BookService.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.demo04;

 /**
 * @type BookService
 * @description 
 * @author qianye.zheng
 */
public class BookServiceImpl extends BaseBookServiceImpl implements BookService
{
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void create()
	{
		System.out.println("BookService.create()");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void delete()
	{
		System.out.println("BookService.delete()");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void update()
	{
		System.out.println("BookService.update()");
	}
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	@Override
	public void query()
	{
		System.out.println("BookService.query()");
	}
	
}
