package com.study.thread;

/*
 * 创建多线程的方式二:通过实现的方式
 * 
 * 对比一下继承的方式和实现的方式
 * 1.联系:public class Thread implements Runnable
 * 2.哪个方式好?实现的方式优于继承的方式
 *  why?  ①避免了Java单继承的局限性
 *  	  ②如果多个线程要操作同一份资源,更适合使用实现的方式
 */
//1.创建实现了Runnable接口的类
class PrintNum implements Runnable{

	//2.实现其抽象方法
	public void run() {
		//子线程执行的代码
		for(int i = 1;i <= 100;i++){
			if(i % 2 == 0){
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		}
	}
	
}

public class TestThread4 {

	public static void main(String[] args) {
		//3.创建一个Runnable接口实现类的对象
		PrintNum pn = new PrintNum();
		//要启动一个线程,必须调用start()
		//4.将此对象作为形参传递给Thread类的构造器,创建Thread类的对象,此对象即为一个线程
		Thread t = new Thread(pn);
		t.start();
	}
}
