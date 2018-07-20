package com.study.juc;

/*
 * �����ߺ������߰���
 */
public class TestProductorAndConsumer {
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Productor p = new Productor(clerk);
		Consumer c = new Consumer(clerk);
		new Thread(p, "������A").start();
		new Thread(c, "������B").start();
		new Thread(p, "������C").start();
		new Thread(c, "������D").start();
	}
}
/*
 * ��Ա
 */
class Clerk {
	private int product = 0;
	
	//����
	public synchronized void get(){
		while(product >= 1){//Ϊ�˱�����ٻ������⣬Ӧ������ʹ����ѭ����
			System.out.println("�ֿ�����");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" : "+ ++product);
		this.notifyAll();
		
	}
	//����
	public synchronized void sale(){
		while(product <= 0){
			System.out.println("ȱ��");
			try {
				this.wait();//ȱ���˾͵ȴ�
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+" : "+ --product);
		this.notifyAll();//�����߳̽�������
		
	}
}
class Productor implements Runnable{

	private Clerk clerk;
	
	public Productor(Clerk clerk){
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

class Consumer implements Runnable{

	private Clerk clerk;
	
	public Consumer(Clerk clerk){
		this.clerk = clerk;
	}
	
	@Override
	public void run() {
		for(int i = 0;i < 20;i++){
			clerk.sale();
		}
	}
	
}


