package com.study.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 一、用于解决多线程安全问题的方式：
 * synchronized 隐式锁：
 * 1.同步代码块
 * 2.同步方法
 * 
 * 3.同步锁Lock
 * 注意：是一个显式锁，需要通过Lock()方法上锁，必须通过unLock()方式进行释放锁
 * 
 */
public class TestLock {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		new Thread(t, "一号窗口").start();
		new Thread(t, "二号窗口").start();
		new Thread(t, "三号窗口").start();
		
	}
}

class Ticket implements Runnable{

	private int tick = 100;
	private Lock lock = new ReentrantLock();
	@Override
	public void run() {
		while(true){
			lock.lock();
			try{
				if(tick > 0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"成功出售一张票，余票为"+tick--);
				}
			}finally{
				lock.unlock();
			}
		}
	}
	
}
