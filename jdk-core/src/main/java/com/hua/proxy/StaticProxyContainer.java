/**
  * @filename StaticProxyContainer.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.proxy;

 /**
 * @type StaticProxyContainer
 * @description 静态代理
 * @author qianye.zheng
 */
public final class StaticProxyContainer {

	/**
	 * 静态代理
	 * 1) 定义一个接口、对应的实现类
	 * 2) 定义一个代理类，继承接口，并持有真正实现类的对象
	 * 3) 在代理类中，具体方法植入具体的代理逻辑
	 * 
	 * 动态代理: 相比静态代理，省略了在每个方法中植入逻辑，而是通过调用处理器来统一处理
	 * 静态代理是在编译时实现的，而动态代理是在运行时通过反射来实现.
	 * 静态代理 方法数量多时想统一逻辑就得每个方法写一遍，代码显得多余和臃肿.
	 * 
	 */
	
	/**
	 * 
	 * @type Movie
	 * @description 电影
	 * @author qianye.zheng
	 */
	public static interface Movie {
		/**
		 * 
		 * @description 播放
		 * @author qianye.zheng
		 */
		void play();
	}
	
	/**
	 * 
	 * @type RealMovie
	 * @description 电影实现
	 * @author qianye.zheng
	 */
	public static final class RealMovie implements Movie {
		/**
		 * @description 
		 * @author qianye.zheng
		 */
		@Override
		public void play() {
			System.out.println("正在播放 《楚汉争霸》 电影...");
		}
	}
	
	/**
	 * 
	 * @type Cinema
	 * @description 电影院
	 * @author qianye.zheng
	 */
	public static final class Cinema implements Movie {
		private Movie delegate;
		
		/**
		 * @description 构造方法
		 * @param delegate
		 * @author qianye.zheng
		 */
		public Cinema(Movie delegate) {
			super();
			this.delegate = delegate;
		}


		/**
		 * @description 
		 * @author qianye.zheng
		 */
		@Override
		public void play() {
			System.out.println("电影播放前 do something");
			// 真实播放电影
			delegate.play();
			System.out.println("电影播放结束后 do something");
		}
	}
}
