package com.study.thread;

/*
 * ģ���վ��Ʊ����,��������������Ʊ,��Ʊ��Ϊ100��
 */

class Window4 extends Thread{
	static int ticket = 100;
	static Object obj = new Object();
	
	public void run(){
		while(true){
			show();
		}
	}
	public synchronized void show(){//����ʵ��ͬ��,��Ϊ��ʱ�õ�����this,��new����������,������������һ��
		if(ticket > 0){
			System.out.println(Thread.currentThread().getName()+"��Ʊ,Ʊ��Ϊ:"+ticket);
			ticket--;
		}
	}
}

public class TestWindow4 {
	public static void main(String[] args) {
		
		Window4 w1 = new Window4();
		Window4 w2 = new Window4();
		Window4 w3 = new Window4();
		
		w1.setName("����1");
		w2.setName("����2");
		w3.setName("����3");
		
		w1.start();
		w2.start();
		w3.start();
		
	}
}
