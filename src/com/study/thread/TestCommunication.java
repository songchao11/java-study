package com.study.thread;

/*
 * �߳�ͨ��
 * ʹ�������̴߳�ӡ1-100,�߳�1 �߳�2�����ӡ
 * ע��:wait()  notify()  notifyAll() ����������ֻ����synchronized������synchronized�����в���ʹ��
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
		t1.setName("��");
		t2.setName("��");
		t1.start();
		t2.start();
	}
}
