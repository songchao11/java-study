package com.study.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 编写一个程序，开启三个线程，这三个线程的Id分别为A B C，每个线程将自己的ID在屏幕上打印10遍，要求输出的结果必须按顺序显示
 * 如：ABCABCABC...一次递归
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

	private int number = 1;// 当前正在执行线程的标记

	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();

	/*
	 * 打印A
	 */
	public void loopA(int totalLoop) {
		lock.lock();
		try {

			// 1.判断
			if (number != 1) {
				condition1.await();
			}
			// 2.打印
			for (int i = 1; i <= 2; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}
			// 3.唤醒
			number = 2;
			condition2.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/*
	 * 打印B
	 */
	public void loopB(int totalLoop) {
		lock.lock();
		try {

			// 1.判断
			if (number != 2) {
				condition2.await();
			}
			// 2.打印
			for (int i = 1; i <= 5; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}
			// 3.唤醒
			number = 3;
			condition3.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/*
	 * 打印C
	 */
	public void loopC(int totalLoop) {
		lock.lock();
		try {

			// 1.判断
			if (number != 3) {
				condition3.await();
			}
			// 2.打印
			for (int i = 1; i <= 3; i++) {
				System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + totalLoop);
			}
			// 3.唤醒
			number = 1;
			condition1.signal();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
