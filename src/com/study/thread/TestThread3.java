package com.study.thread;

/*
 * �����������߳�,һ�����1-100֮�������,һ�����1-100֮���ż��
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
		odd.setName("���߳�");
		even.setName("ż�߳�");
		odd.start();
		even.start();
	}
}
