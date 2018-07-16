package com.study.fanshe;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class TestConstructor {

	@Test
	public void test() throws Exception{
		String className = "com.study.fanshe.Person";
		Class clazz = Class.forName(className);
		//创建对应的运行时类的对象.使用newInstance(),实际上就是调用了运行时类的空参的构造器.
		//要想能够创建成功:①要求对应的运行时类要有空参的构造方法;②构造方法的权限修饰符的权限要足够
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
		Person p = (Person)c.newInstance("张三", 22);
		System.out.println(p);
	}
	
}
