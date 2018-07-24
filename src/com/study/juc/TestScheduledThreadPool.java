package com.study.juc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * һ���̳߳أ��ṩ��һ���̶߳��У������б��������еȴ�״̬���̣߳������˴����������̵߳Ķ��⿪�� ���������Ӧ�ٶ�
 * 
 * �����̳߳ص���ϵ�ṹ��
 * 	java.util.concurrent.Executor: �����̵߳�ʹ������ȵĸ��ӿ�
 * 		|--ExecutorService �ӽӿڣ� �̳߳ص���Ҫ�ӿ�
 * 			|--ThreadPoolExecutor �̳߳ص�ʵ����
 * 			|--ScheduledExecutorService :�����̵߳��ȵ��ӽӿ�
 * 				|--ScheduledThreadPoolExecutor :�̳���ThreadPoolExecutor��ʵ����ScheduledExecutorService
 * ���������ࣺExecutors
 * 	ExecutorService newFixedThreadPool(): �����̶���С���̳߳�
 * 	ExecutorService newCachedThreadPool(): �����̳߳أ��̳߳��������̶������Ը��������Զ��ĸ�������
 * 	ExecutorService newSingleThreadExecutor(): ���������̳߳أ��̳߳���ֻ��һ���߳�
 * 	
 * 	ScheduledExecutorService newScheduledThreadPool(): �����̶���С���̣߳������ӳٻ�ʱ��ִ������
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


