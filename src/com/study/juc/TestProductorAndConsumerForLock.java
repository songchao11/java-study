package com.study.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * �����ߺ������߰���
 */
public class TestProductorAndConsumerForLock {
	public static void main(String[] args) {
		Clerk1 clerk = new Clerk1();
		Productor1 p = new Productor1(clerk);
		Consumer1 c = new Consumer1(clerk);
		new Thread(p, "������A").start();
		new Thread(c, "������B").start();
		new Thread(p, "������C").start();
		new Thread(c, "������D").start();
	}
}
/*
 * ��Ա
 */
class Clerk1 {
	private int product = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	//����
	public void get(){
		lock.lock();
		try{
			while(product >= 1){//Ϊ�˱�����ٻ������⣬Ӧ������ʹ����ѭ����
				System.out.println("�ֿ�����");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" : "+ ++product);
			condition.signalAll();
		}finally{
			lock.unlock();
		}
		
		
	}
	//����
	public void sale(){
		lock.lock();
		try{
			while(product <= 0){
				System.out.println("ȱ��");
				try {
					condition.await();//ȱ���˾͵ȴ�
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" : "+ --product);
			condition.signalAll();//�����߳̽�������
		}finally{
			lock.unlock();
		}
		
	}
}
class Productor1 implements Runnable{

	private Clerk1 clerk;
	
	public Productor1(Clerk1 clerk){
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		for(int i = 0;i < 20;i++){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.get();
		}
	}
}

class Consumer1 implements Runnable{

	private Clerk1 clerk;
	
	public Consumer1(Clerk1 clerk){
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		for(int i = 0;i < 20;i++){
			clerk.sale();
		}
	}
	
}


