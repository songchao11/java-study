package com.study.fanshe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {

	/*
	 * 获取运行时类的方法
	 */
	@Test
	public void test1(){
		Class clazz = Person.class;
		//1.getMethods():获取运行时类及其父类中所有声明为public的方法
		Method[] methods = clazz.getMethods();
		for(Method m : methods){
			System.out.println(m.getName());
		}
		System.out.println("----------");
		//2.getDeclaredMethods():获取运行时类本身声明的所有方法
		Method[] methods1 = clazz.getDeclaredMethods();
		for(Method m : methods1){
			System.out.println(m);
		}
	}
	
	/*
	 * 注解  权限修饰符  返回值类型  方法名  形参列表  异常
	 */
	@Test
	public void test2(){
		Class clazz = Person.class;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods){
			//1.注解
			Annotation[] ann = m.getAnnotations();
			for(Annotation a : ann){
				System.out.println(a);
			}
			//2.权限修饰符
			String modi = Modifier.toString(m.getModifiers());
			System.out.print(modi+ " ");
			//3.返回值类型
			Class returnType = m.getReturnType();
			System.out.print(returnType.getName()+ " ");
			//4.方法名
			System.out.print(m.getName()+" ");
			//5.形参列表
			System.out.print("(");
			Class[] parameters = m.getParameterTypes();
			for(int i = 0;i < parameters.length;i++){
				System.out.print(parameters[i].getName()+"--"+i);
			}
			System.out.print(")");
			//6.异常
			Class[] excs = m.getExceptionTypes();
			if(excs.length != 0){
				System.out.print(" throws ");
			}
			for(int i = 0;i < excs.length;i++){
				System.out.print(excs[i].getName()+" ");
			}
			
			System.out.println();
		}
		
	}
	
	/*
	 * 调用运行时类中指定的方法
	 */
	@Test
	public void test3() throws Exception{
		Class clazz = Person.class;
		//getMethod():获取名为methodName的public方法
		Method m1 = clazz.getMethod("show");
		Person p = (Person)clazz.newInstance();
		m1.invoke(p);
		Method m2 = clazz.getMethod("sayHello");
		m2.invoke(p);
		//getDeclaredMethod():获取名为methodName的方法
		Method m3 = clazz.getDeclaredMethod("display", String.class);
		//添加访问权限
		m3.setAccessible(true);
		m3.invoke(p, "新加坡");
	}
	
}
