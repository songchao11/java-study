package com.study.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
public class TestThreadPool {
	
	public static void main(String[] args) {
		//1.����ָ����С���̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(5);
		
		CallPoolDemo callPoolDemo = new CallPoolDemo();
		
		Future future = pool.submit(callPoolDemo);
		
//		ThreadPoolDemo tpd = new ThreadPoolDemo();
//		
//		//2.Ϊ�̳߳��е��̷߳�������
//		pool.submit(tpd);
//		
		//3.�ر��̳߳�
		pool.shutdown();
		try {
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

class ThreadPoolDemo implements Runnable{

	
	@Override
	public void run() {
		for(int i = 0;i < 100;i++){
			System.out.println(i);
		}
	}
	
}

class CallPoolDemo implements Callable<Integer>{
	private int sum = 0;
	@Override
	public Integer call() throws Exception {
		for(int i = 0;i < 100;i++){
			sum += i;
		}
		return sum;
	}
	
}
