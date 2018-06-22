package com.study.java;
/**
 * 单例模式(饿汉式)
 * @author song
 *
 */
public class Singleton {

	private Singleton(){}
	
	private static Singleton instance = new Singleton(){};
	
	public static Singleton getInstance(){
		return instance;
	}
	
}
