package com.study.java;
/**
 * ����ģʽ(����ʽ)
 * @author song
 *
 */
public class Singleton1 {

	private Singleton1 (){}
	
	private static Singleton1 instance = null;
	
	public static Singleton1 getInstance(){
		if(instance == null){
			instance = new Singleton1();
		}
		return instance;
	}
}
