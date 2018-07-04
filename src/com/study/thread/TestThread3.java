package com.study.thread;

/*
 * 创建两个子线程,一个输出1-100之间的奇数,一个输出1-100之间的偶数
 */

class OddNumberThread extends Thread{
	public void run(){
		for(int i = 1;i <= 100;i++){
			if(i % 2 != 0){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
}

class EvenNumberThread extends Thread{
	public void run(){
		for(int i = 1;i <= 100;i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
}

public class TestThread3 {

	public static void main(String[] args) {
		OddNumberThread odd = new OddNumberThread();
		EvenNumberThread even = new EvenNumberThread();
		odd.setName("奇线程");
		even.setName("偶线程");
		odd.start();
		even.start();
	}
}
