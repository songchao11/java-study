package com.study.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * һ�������̵߳ķ�ʽ����ʵ��Callable�ӿڡ������Runnable�ӿڵķ�ʽ�����������з���ֵ�����ҿ����׳��쳣
 * 
 * ����ִ��Callable��ʽ����ҪFutureTaskʵ�����֧�֣����ڽ�����������FutureTask��Future�ӿڵ�ʵ����
 */
public class TestCallable {

	public static void main(String[] args) {
		ThreadDemo1 td = new ThreadDemo1();
		//ִ��Callable
		FutureTask<Integer> result = new FutureTask<>(td);
		new Thread(result).start();
		//����������
		try {
			int sum = result.get();//FutureTask�����ڱ���
			System.out.println(sum);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}

class ThreadDemo1 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 0;i <= 100;i++){
			sum += i;
		}
		return sum;
	}
	
}