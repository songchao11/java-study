package com.study.thread;

/*
 * 模拟火车站售票窗口,开启三个窗口售票,总票数为100张
 */

class Window4 extends Thread{
	static int ticket = 100;
	static Object obj = new Object();
	
	public void run(){
		while(true){
			show();
		}
	}
	public synchronized void show(){//不能实现同步,因为此时用的锁是this,但new了三个对象,所以三把锁不一样
		if(ticket > 0){
			System.out.println(Thread.currentThread().getName()+"售票,票号为:"+ticket);
			ticket--;
		}
	}
}

public class TestWindow4 {
	public static void main(String[] args) {
		
		Window4 w1 = new Window4();
		Window4 w2 = new Window4();
		Window4 w3 = new Window4();
		
		w1.setName("窗口1");
		w2.setName("窗口2");
		w3.setName("窗口3");
		
		w1.start();
		w2.start();
		w3.start();
		
	}
}
