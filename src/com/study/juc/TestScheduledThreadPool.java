package com.study.juc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * 一、线程池：提供了一个线程队列，队列中保存着所有等待状态的线程，避免了创建与销毁线程的额外开销 ，提高了响应速度
 * 
 * 二、线程池的体系结构：
 * 	java.util.concurrent.Executor: 负责线程的使用与调度的根接口
 * 		|--ExecutorService 子接口： 线程池的主要接口
 * 			|--ThreadPoolExecutor 线程池的实现类
 * 			|--ScheduledExecutorService :负责线程调度的子接口
 * 				|--ScheduledThreadPoolExecutor :继承了ThreadPoolExecutor，实现了ScheduledExecutorService
 * 三、工具类：Executors
 * 	ExecutorService newFixedThreadPool(): 创建固定大小的线程池
 * 	ExecutorService newCachedThreadPool(): 缓存线程池，线程池数量不固定，可以根据需求自动的更改数量
 * 	ExecutorService newSingleThreadExecutor(): 创建单个线程池，线程池中只有一个线程
 * 	
 * 	ScheduledExecutorService newScheduledThreadPool(): 创建固定大小的线程，可以延迟或定时的执行任务
 * 	
 */
public class TestScheduledThreadPool {
	public static void main(String[] args) {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
		
		for(int i = 0;i < 5;i++){
			
			Future future = pool.schedule(new Callable(){
				
				@Override
				public Object call() throws Exception {
					int num = new Random().nextInt(100);
					System.out.println(Thread.currentThread().getName()+" : "+num);
					return num;
				}
				
			}, 1, TimeUnit.SECONDS);
			try {
				System.out.println(future.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		pool.shutdown();
		
	}
}


