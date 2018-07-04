package com.study.thread;

/*
 * Thread�ĳ��÷���:
 * 1.start():�����̲߳�ִ����Ӧ��run()����
 * 2.run():���߳�Ҫִ�еĴ������run()��
 * 3.currentThread():��̬��,��ȡ��ǰ�߳�
 * 4.getName():��ȡ���̵߳�����
 * 5.setName():���ô��̵߳�����
 * 6.yield():���ô˷������߳��ͷŵ�ǰCPU��ִ��Ȩ
 * 7.join():��A�߳��е���B�̵߳�join()����,��ʾ:��ִ�е��˷���,
 * A�߳�ִֹͣ��,ֱ��B�߳�ִ�����,A�߳��ٽ���join()֮��Ĵ���ִ��
 * 8.isAlive():�ж��߳��Ƿ񻹴��
 * 9.sleep(long time):��ʾ�����߳�˯��time����
 * 10.�߳�ͨ��: wait()  notify()  notifyAll()
 * 11.setPriority():�����̵߳����ȼ�
 * ע��:wait()  notify()  notifyAll() ����������ֻ����synchronized������synchronized�����в���ʹ��
 */
class SubThread2 extends Thread{
	public void run(){
		for(int i = 1;i <= 100;i++){
//			try {
//				sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
public class TestThread2 {
	public static void main(String[] args) {
		SubThread2 sub1 = new SubThread2();
		sub1.setPriority(Thread.MAX_PRIORITY);
		sub1.setName("���߳�1");
		sub1.start();
		Thread.currentThread().setName("=======���߳�=======");
		for(int i = 1;i <= 100;i++){
			System.out.println(Thread.currentThread().getName()+":"+i);
//			if(i % 10 == 0){
//				Thread.currentThread().yield();
//			}
//			if(i == 30){
//				try {
//					sub1.join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
		System.out.println(sub1.isAlive());
	}
}
