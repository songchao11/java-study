package com.study.thread;

/*
 * �˳�������̰߳�ȫ������:��ӡ��Ʊʱ,�������Ʊ,��Ʊ
 * 1.�̰߳�ȫ������ڵ�ԭ��?
 *   ����һ���߳��ڲ����������ݵĹ�����,δִ����ϵ������,������̲߳������,���¹������ݴ����˰�ȫ����
 *   
 * 2.��ν���̰߳�ȫ����
 *   ������һ���̲߳���������������Ժ�,�����̲߳��л�����빲�����ݵĲ���
 *   
 * 3.java���ʵ���̰߳�ȫ:�̵߳�ͬ������
 * 	��ʽһ:ͬ�������
 * 		synchronized(ͬ��������){
 * 			��Ҫ��ͬ���Ĵ����(��Ϊ�����������ݵĴ���)
 * 		}
 * 		�ٹ�������:����̹߳�ͬ������ͬһ������(����)
 * 		��ͬ��������:��һ����Ķ���䵱.�ĸ��̻߳�ȡ�˼�����,˭��ִ�д������ﱻͬ���Ĵ���.�׳�:��
 * 		Ҫ��:���е��̹߳���ͬһ����
 * 	��ʽ��:ͬ������
 * 		�������������ݵķ�������Ϊsynchronized.���˷���Ϊͬ������.�ܹ���֤������һ���߳�ִ�д˷���ʱ,
 * 		�����߳�����ȴ�ֱ�����߳�ִ����˷���
 * 
 */
class Window2 implements Runnable{

	int ticket = 100;
	Object obj = new Object();
	
	@Override
	public void run() {
		while(true){
			synchronized(obj){
				if(ticket > 0){
					System.out.println(Thread.currentThread().getName()+":"+ticket);
					ticket--;
				}else{
					break;
				}
			}
		}
	}
}

public class TestWindow2 {
	public static void main(String[] args) {
		Window2 w = new Window2();
		Thread t1 = new Thread(w);
		Thread t2 = new Thread(w);
		Thread t3 = new Thread(w);
		
		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
