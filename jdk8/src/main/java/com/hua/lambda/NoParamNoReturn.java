/**
  * @filename NoParamNoReturn.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.lambda;

 /**
 * @type NoParamNoReturn
 * @description 
 * @author qianye.zheng
 */
//@FunctionalInterface
public interface NoParamNoReturn
{
	
	
	/**
	 * 
	 * @description 
	 * @author qianye.zheng
	 */
	void doSomething();
	
	
	public class A {
		
		public void f2() {
			f(() -> System.out.println("xx"));
		}
		
		
		public void f(NoParamNoReturn param)
		{
			
		};
	}
}
