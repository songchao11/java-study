package com.study.thread;


/*
 * 银行有一个账户,现在有两个储户分别向这个账户存3000元钱,每次存1000,分三次,存完打印余额
 */

class Account{

	private double balance;
	
	public synchronized void deposit(double amt){
		notify();
		balance += amt;
		System.out.println(Thread.currentThread().getName()+"存入"+amt+"元钱,账户余额为:"+balance+"元钱");
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
		Account a = new Account();//使用同一个Account对象
		Customer c1 = new Customer(a);
		Customer c2 = new Customer(a);
		c1.setName("张三");
		c2.setName("李四");
		c1.start();
		c2.start();
	}
}
