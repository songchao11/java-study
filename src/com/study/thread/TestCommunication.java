package com.study.thread;

/*
 * 线程通信
 * 使用两个线程打印1-100,线程1 线程2交替打印
 * 注意:wait()  notify()  notifyAll() 这三个方法只有在synchronized代码块和synchronized方法中才能使用
 */
class PrintNum1 implements Runnable{
	int num = 1;
	@Override
	public void run() {
		while(num <= 100){
			synchronized (this) {
				notify();
				if (num <= 100) {
					System.out.println(Thread.currentThread().getName() + ":" + num++);
				} else {
					break;
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
public class TestCommunication {
	public static void main(String[] args) {
		PrintNum1 p = new PrintNum1();
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(p);
		t1.setName("甲");
		t2.setName("乙");
		t1.start();
		t2.start();
	}
}
