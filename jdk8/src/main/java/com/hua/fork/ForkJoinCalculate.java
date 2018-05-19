/**
  * @filename ForkJoinCalculate.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.fork;

import java.util.concurrent.RecursiveTask;

 /**
 * @type ForkJoinCalculate
 * @description 
 * @author qianye.zheng
 */
public class ForkJoinCalculate extends RecursiveTask<Long>
{

	private static final long serialVersionUID = 2696564560879639424L;

	private long start;
	
	private long end;
	
	/* 阈值 */
	private static final long THRESHOLD =  10000;
	
	/**
	 * @description 构造方法
	 * @param start
	 * @param end
	 * @author qianye.zheng
	 */
	public ForkJoinCalculate(long start, long end)
	{
		super();
		this.start = start;
		this.end = end;
	}
	
	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	protected Long compute()
	{
		long length = end - start;
		if (length <= THRESHOLD)
		{ // 小于阈值 不拆分
			long sum = 0L;
			for (long i = start; i <= end; i++)
			{
				sum += i;
			}
			
			return sum;
		} else
		{ // 拆分
			// 中位数
			long middle = (start + end) / 2;
			ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
			// 拆分子任务，加入子线程队列
			left.fork();
			// 
			ForkJoinCalculate right = new ForkJoinCalculate(middle, end);
			// 拆分子任务，加入子线程队列
			right.fork();
			
			// 任务组合
			return left.join() + right.join();
		}
	}

}
