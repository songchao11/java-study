package com.study.thread;


/*
 * ������һ���˻�,���������������ֱ�������˻���3000ԪǮ,ÿ�δ�1000,������,�����ӡ���
 */

class Account{

	private double balance;
	
	public synchronized void deposit(double amt){
		notify();
		balance += amt;
		System.out.println(Thread.currentThread().getName()+"����"+amt+"ԪǮ,�˻����Ϊ:"+balance+"ԪǮ");
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

class Customer extends Thread{
	Account account;
	
	public Customer(Account account){
		this.account = account;
	}
	
	public void run(){
		for(int i = 0;i < 3;i++){
			account.deposit(1000);
		}
	}
}

public class TestAccount {
	public static void main(String[] args) {
		Account a = new Account();//ʹ��ͬһ��Account����
		Customer c1 = new Customer(a);
		Customer c2 = new Customer(a);
		c1.setName("����");
		c2.setName("����");
		c1.start();
		c2.start();
	}
}
