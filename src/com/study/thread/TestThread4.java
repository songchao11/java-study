package com.study.thread;

/*
 * �������̵߳ķ�ʽ��:ͨ��ʵ�ֵķ�ʽ
 * 
 * �Ա�һ�¼̳еķ�ʽ��ʵ�ֵķ�ʽ
 * 1.��ϵ:public class Thread implements Runnable
 * 2.�ĸ���ʽ��?ʵ�ֵķ�ʽ���ڼ̳еķ�ʽ
 *  why?  �ٱ�����Java���̳еľ�����
 *  	  ���������߳�Ҫ����ͬһ����Դ,���ʺ�ʹ��ʵ�ֵķ�ʽ
 */
//1.����ʵ����Runnable�ӿڵ���
class PrintNum implements Runnable{

	//2.ʵ������󷽷�
	public void run() {
		//���߳�ִ�еĴ���
		for(int i = 1;i <= 100;i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
	
}

public class TestThread4 {

	public static void main(String[] args) {
		//3.����һ��Runnable�ӿ�ʵ����Ķ���
		PrintNum pn = new PrintNum();
		//Ҫ����һ���߳�,�������start()
		//4.���˶�����Ϊ�βδ��ݸ�Thread��Ĺ�����,����Thread��Ķ���,�˶���Ϊһ���߳�
		Thread t = new Thread(pn);
		t.start();
	}
}
