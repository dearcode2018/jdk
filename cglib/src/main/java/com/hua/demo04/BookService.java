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
public interface BookService extends BaseBookService
{

	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void create();
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void delete();
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void update();
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	public void query();
}
