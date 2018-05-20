/**
  * @filename MyAnnotation.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.jdk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

 /**
 * @type MyAnnotation
 * @description 
 * @author qianye.zheng
 */
// 重复注解，指定一个容器类型
@Repeatable(MyAnnotations.class)
@Target({ElementType.TYPE, ElementType.FIELD, 
	ElementType.METHOD, 
	// 类型参数，修饰方法的参数
	ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation
{
	
	
	String value() default "haha";
	
	
	
}
