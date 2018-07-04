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
 * 4.�߳�ͬ���ı׶�:
 * 	����ͬһʱ��ֻ����һ���̷߳��ʹ�����Դ,Ч�ʽ���
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
		
		t1.setName("����1");
		t2.setName("����2");
		t3.setName("����3");
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
