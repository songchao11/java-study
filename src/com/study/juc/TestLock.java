package com.study.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * һ�����ڽ�����̰߳�ȫ����ķ�ʽ��
 * synchronized ��ʽ����
 * 1.ͬ�������
 * 2.ͬ������
 * 
 * 3.ͬ����Lock
 * ע�⣺��һ����ʽ������Ҫͨ��Lock()��������������ͨ��unLock()��ʽ�����ͷ���
 * 
 */
public class TestLock {
	public static void main(String[] args) {
		Ticket t = new Ticket();
		new Thread(t, "һ�Ŵ���").start();
		new Thread(t, "���Ŵ���").start();
		new Thread(t, "���Ŵ���").start();
		
	}
}

class Ticket implements Runnable{

	private int tick = 100;
	private Lock lock = new ReentrantLock();
	@Override
	public void run() {
		while(true){
			lock.lock();
			try{
				if(tick > 0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"�ɹ�����һ��Ʊ����ƱΪ"+tick--);
				}
			}finally{
				lock.unlock();
			}
		}
	}
	
}
