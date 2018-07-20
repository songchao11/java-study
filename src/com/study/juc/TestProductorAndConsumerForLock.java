package com.study.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 生产者和消费者案例
 */
public class TestProductorAndConsumerForLock {
	public static void main(String[] args) {
		Clerk1 clerk = new Clerk1();
		Productor1 p = new Productor1(clerk);
		Consumer1 c = new Consumer1(clerk);
		new Thread(p, "生产者A").start();
		new Thread(c, "消费者B").start();
		new Thread(p, "生产者C").start();
		new Thread(c, "消费者D").start();
	}
}
/*
 * 店员
 */
class Clerk1 {
	private int product = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	//进货
	public void get(){
		lock.lock();
		try{
			while(product >= 1){//为了避免虚假唤醒问题，应该总是使用在循环中
				System.out.println("仓库已满");
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
	//卖货
	public void sale(){
		lock.lock();
		try{
			while(product <= 0){
				System.out.println("缺货");
				try {
					condition.await();//缺货了就等待
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+" : "+ --product);
			condition.signalAll();//唤醒线程进行生产
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


