package com.study.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * 一、创建线程的方式三：实现Callable接口。相较于Runnable接口的方式，方法可以有返回值，并且可以抛出异常
 * 
 * 二、执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果。FutureTask是Future接口的实现类
 */
public class TestCallable {

	public static void main(String[] args) {
		ThreadDemo1 td = new ThreadDemo1();
		//执行Callable
		FutureTask<Integer> result = new FutureTask<>(td);
		new Thread(result).start();
		//接收运算结果
		try {
			int sum = result.get();//FutureTask可用于闭锁
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