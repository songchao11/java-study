package com.study.fanshe;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class TestOthers {

	/*
	 * 获取运行时类的父类
	 */
	@Test
	public void test1(){
		Class clazz = Person.class;
		Class superClass = clazz.getSuperclass();
		System.out.println(superClass);
	}
	
	/*
	 * 获取带泛型的父类
	 */
	@Test
	public void test2(){
		Class clazz = Person.class;
		Type genericSuperClass = clazz.getGenericSuperclass();
		System.out.println(genericSuperClass);
	}
	
	/*
	 * 获取父类的泛型
	 */
	@Test
	public void test3(){
		Class clazz = Person.class;
		Type gener = clazz.getGenericSuperclass();
		ParameterizedType param = (ParameterizedType)gener;
		Type[] args = param.getActualTypeArguments();
		for(Type t : args){
			System.out.println(t);
		}
	}
	
	/*
	 * 获取实现的接口
	 */
	@Test
	public void test4(){
		Class clazz = Person.class;
		Class[] interfaces = clazz.getInterfaces();
		for(Class c : interfaces){
			System.out.println(c);
		}
	}
	
	/* 
	 * 获取所在的包
	 */
	@Test
	public void test5(){
		Class clazz = Person.class;
		Package p = clazz.getPackage();
		System.out.println(p);
	}
	
	/*
	 * 获取注解
	 */
	@Test
	public void test6(){
		Class clazz = Person.class;
		Annotation[] anns = clazz.getAnnotations();
		for(Annotation a : anns){
			System.out.println(a);
		}
	}
	
}
