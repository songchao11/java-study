package com.study.java;
/**
 * 单例模式(懒汉式)
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
