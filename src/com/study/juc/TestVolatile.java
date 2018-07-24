package com.study.juc;

/*
 * һ��volatile�ؼ���:������߳̽��в�����������ʱ�����Ա�֤�ڴ��е����ݿɼ�
 *    volatile�����synchronized��һ�ֽ�Ϊ��������ͬ������
 *    
 *    ע�⣺
 *    1.volatile:���߱��������ԡ�
 *    2.volatile:���ܱ�֤�����ġ�ԭ���ԡ�
 *    
 */
public class TestVolatile {
	public static void main(String[] args) {
		ThreadDemo td = new ThreadDemo();
		new Thread(td).start();
		while(true){
			if(td.isFlag()){
				System.out.println("=======");
				break;
			}
		}
	}
}

class ThreadDemo implements Runnable{

	private volatile boolean flag = false;
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		flag = true;
		System.out.println("flag="+flag);
		
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}