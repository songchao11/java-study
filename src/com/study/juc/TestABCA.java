package com.study.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * ��дһ�����򣬿��������̣߳��������̵߳�Id�ֱ�ΪA B C��ÿ���߳̽��Լ���ID����Ļ�ϴ�ӡ10�飬Ҫ������Ľ�����밴˳����ʾ
 * �磺ABCABCABC...һ�εݹ�
 */
public class TestABCA {
	public static void main(String[] args) {
		AlternateDemo alter = new AlternateDemo();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 20; i++) {
					alter.loopA(i);
				}

			}
		}, "A").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 20; i++) {
					alter.loopB(i);
				}

			}
		}, "B").start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 20; i++) {
					alter.loopC(i);
				}

			}
		}, "C").start();
	}
}

class AlternateDemo {

	private int number = 1;// ��ǰ����ִ���̵߳ı��

	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();

	/*
	 * ��ӡA
	 */
	public void loopA(int totalLoop) {
		lock.lock();
		try {

			// 1.�ж�
			if (number != 1) {
				condition1.await();
			}
			// 2.��ӡ
			for (int i = 1; i <= 2; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}
			// 3.����
			number = 2;
			condition2.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/*
	 * ��ӡB
	 */
	public void loopB(int totalLoop) {
		lock.lock();
		try {

			// 1.�ж�
			if (number != 2) {
				condition2.await();
			}
			// 2.��ӡ
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}
			// 3.����
			number = 3;
			condition3.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/*
	 * ��ӡC
	 */
	public void loopC(int totalLoop) {
		lock.lock();
		try {

			// 1.�ж�
			if (number != 3) {
				condition3.await();
			}
			// 2.��ӡ
			for (int i = 1; i <= 3; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}
			// 3.����
			number = 1;
			condition1.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
