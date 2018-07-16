package com.study.fanshe;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {

	@Test
	public void test() throws Exception{
		String className = "com.study.fanshe.Person";
		Class clazz = Class.forName(className);
		//������Ӧ������ʱ��Ķ���.ʹ��newInstance(),ʵ���Ͼ��ǵ���������ʱ��ĿղεĹ�����.
		//Ҫ���ܹ������ɹ�:��Ҫ���Ӧ������ʱ��Ҫ�пղεĹ��췽��;�ڹ��췽����Ȩ�����η���Ȩ��Ҫ�㹻
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		
	}
	
	@Test
	public void test1() throws Exception{
		String className = "com.study.fanshe.Person";
		Class clazz = Class.forName(className);
		Constructor[] cons = clazz.getDeclaredConstructors();
		for(Constructor c : cons){
			System.out.println(c);
		}
	}
	
	@Test
	public void test2() throws Exception{
		String className = "com.study.fanshe.Person";
		Class clazz = Class.forName(className);
		Constructor c = clazz.getDeclaredConstructor(String.class, int.class);
		c.setAccessible(true);
		Person p = (Person)c.newInstance("����", 22);
		System.out.println(p);
	}
	
}
