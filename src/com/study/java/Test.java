package com.study.java;

import java.util.LinkedList;

public class Test {
	
	public static void main(String[] args) {
//		Singleton s1 = Singleton.getInstance();
//		Singleton s2 = Singleton.getInstance();
//		System.out.println(s1);
//		System.out.println(s2);
		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();
		System.out.println(s1);
		System.out.println(s2);
	}
}
