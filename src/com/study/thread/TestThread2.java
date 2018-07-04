package com.study.thread;

/*
 * Thread的常用方法:
 * 1.start():启动线程并执行相应的run()方法
 * 2.run():子线程要执行的代码放入run()中
 * 3.currentThread():静态的,调取当前线程
 * 4.getName():获取此线程的名字
 * 5.setName():设置此线程的名字
 * 6.yield():调用此方法的线程释放当前CPU的执行权
 * 7.join():在A线程中调用B线程的join()方法,表示:当执行到此方法,
 * A线程停止执行,直至B线程执行完毕,A线程再接着join()之后的代码执行
 * 8.isAlive():判断线程是否还存活
 * 9.sleep(long time):显示的让线程睡眠time毫秒
 * 10.线程通信: wait()  notify()  notifyAll()
 * 11.setPriority():设置线程的优先级
 * 注意:wait()  notify()  notifyAll() 这三个方法只有在synchronized代码块和synchronized方法中才能使用
 */
class SubThread2 extends Thread{
	public void run(){
		for(int i = 1;i <= 100;i++){
//			try {
//				sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
public class TestThread2 {
	public static void main(String[] args) {
		SubThread2 sub1 = new SubThread2();
		sub1.setPriority(Thread.MAX_PRIORITY);
		sub1.setName("子线程1");
		sub1.start();
		Thread.currentThread().setName("=======主线程=======");
		for(int i = 1;i <= 100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
//			if(i % 10 == 0){
//				Thread.currentThread().yield();
//			}
//			if(i == 30){
//				try {
//					sub1.join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
		System.out.println(sub1.isAlive());
	}
}
