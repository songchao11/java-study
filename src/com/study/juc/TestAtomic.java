package com.study.juc;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * һ��i++��ԭ�������⣺i++�Ĳ���ʵ���Ϸ�Ϊ�������衰��-��-д��
 * 
 * ����ԭ�ӱ�����jdk1.5֮��java.util.concurrent.atomic�����ṩ�˳��õ�ԭ�ӱ�����
 * 	1.volatile ��֤�ڴ�ɼ���
 * 	2.CAS(Compare And Swap)�㷨��֤���ݵ�ԭ����
 * 		CAS�㷨��Ӳ�����ڲ��������������ݵ�֧��
 * 		CAS������������������
 * 		�ڴ�ֵ��A
 * 		Ԥ��ֵ��V
 * 		����ֵ��B
 * 		���ҽ���V == Aʱ��V = B,���򽫲����κβ���
 */
public class TestAtomic {
	public static void main(String[] args) {
		AtomicDemo ad = new AtomicDemo();
		for(int i = 0;i < 10;i++){
			new Thread(ad).start();
		}
	}
}

class AtomicDemo implements Runnable{

//	private volatile int serialNumber = 0;
	
	private AtomicInteger serialNumber = new AtomicInteger();
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
	}

	public int getSerialNumber() {
		return serialNumber.getAndIncrement();
	}
	
}