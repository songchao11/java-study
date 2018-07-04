package com.study.thread;

/*
 * 此程序存在线程安全的问题:打印车票时,会出现重票,错票
 * 1.线程安全问题存在的原因?
 *   由于一个线程在操作共享数据的过程中,未执行完毕的情况下,另外的线程参与进来,导致共享数据存在了安全问题
 *   
 * 2.如何解决线程安全问题
 *   必须让一个线程操作共享数据完毕以后,其他线程才有机会参与共享数据的操作
 *   
 * 3.java如何实现线程安全:线程的同步机制
 * 	方式一:同步代码块
 * 		synchronized(同步监视器){
 * 			需要被同步的代码块(即为操作共享数据的代码)
 * 		}
 * 		①共享数据:多个线程共同操作的同一个数据(变量)
 * 		②同步监视器:由一个类的对象充当.哪个线程获取此监视器,谁就执行大括号里被同步的代码.俗称:锁
 * 		要求:所有的线程共用同一把锁
 * 	方式二:同步方法
 * 		将操作共享数据的方法声明为synchronized.即此方法为同步方法.能够保证当其中一个线程执行此方法时,
 * 		其他线程在外等待直至此线程执行完此方法
 * 4.线程同步的弊端:
 * 	由于同一时间只能有一个线程访问共享资源,效率降低
 */
class Window3 implements Runnable{

	int ticket = 100;
	Object obj = new Object();
	
	@Override
	public void run() {
		while(true){
			show();
		}
	}
	
	public synchronized void show(){
		if(ticket > 0){
			System.out.println(Thread.currentThread().getName()+":"+ticket);
			ticket--;
		}
	}
	
}

public class TestWindow3 {
	public static void main(String[] args) {
		Window3 w = new Window3();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
