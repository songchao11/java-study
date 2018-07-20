package com.study.juc;

/*
 * �̰߳���
 * 1.������ͨͬ�������������̣߳���׼��ӡ ?  //one two
 * 2.����Thread.sleep()��getOne()  //one two
 * 3.������ͨ����getThree() //three one two
 * 4.������ͨͬ������������number���� //two one
 * 5.�޸�getOne()Ϊ��̬ͬ������ //two one
 * 6.�޸�����������Ϊ��̬ͬ������ //one two
 * 7.һ����̬ͬ��������һ���Ǿ�̬ͬ������������Number���� //two one
 * 8.������̬ͬ������������Number���� //one two
 * 
 * �̰߳����Ĺؼ���
 * �ٷǾ�̬��������Ĭ��Ϊthis����̬��������Ϊ��Ӧ��Classʵ��
 * ��ĳһ��ʱ���ڣ�ֻ����һ���̳߳����������ۼ�������
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
