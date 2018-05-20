/**
  * @filename MyAnnotations.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.jdk;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

 /**
 * @type MyAnnotations
 * @description 
 * @author qianye.zheng
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotations
{
	MyAnnotation[] value();
}
