package com.study.juc;

/*
 * 线程八锁
 * 1.两个普通同步方法，两个线程，标准打印 ?  //one two
 * 2.新增Thread.sleep()给getOne()  //one two
 * 3.新增普通方法getThree() //three one two
 * 4.两个普通同步方法，两个number对象 //two one
 * 5.修改getOne()为静态同步方法 //two one
 * 6.修改两个方法均为静态同步方法 //one two
 * 7.一个静态同步方法，一个非静态同步方法，两个Number对象 //two one
 * 8.两个静态同步方法，两个Number对象 //one two
 * 
 * 线程八锁的关键：
 * ①非静态方法的锁默认为this，静态方法的锁为对应的Class实例
 * ②某一个时刻内，只能有一个线程持有锁，无论几个方法
 */
public class TestThread8Monitor {
	public static void main(String[] args) {
		Number n = new Number();
		Number n2 = new Number();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				n.getOne();
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
//				n.getTwo();
				n2.getTwo();
			}
		}).start();
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				n.getThree();
//			}
//		}).start();
		
	}
}

class Number{
	
	public static synchronized void getOne(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ONE");
	}
	
	public static synchronized void getTwo(){
		System.out.println("TWO");
	}
	
	public void getThree(){
		System.out.println("THREE");
	}
	
}
