package com.study.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {

	/*
	 * 获取对应运行时类的属性
	 */
	@Test
	public void test1(){
		Class clazz = Person.class;
		//1.getFields():只能获取到运行时类及其父类中声明为public的属性
		Field[] fields = clazz.getFields();
		for(int i = 0;i < fields.length;i++){
			System.out.println(fields[i]);
		}
		//2.getDeclaredFields():获取运行时类本身声明的所有属性
		Field[] fields1 = clazz.getDeclaredFields();
		for(Field f : fields1){
			System.out.println(f);
		}
	}
	
	/*
	 * 权限修饰符  变量类型  变量名
	 * 获取属性的各个部分的内容
	 */
	@Test
	public void test2(){
		Class clazz = Person.class;
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields){
			//1.获取每个属性的权限修饰符b
			int m = f.getModifiers();
			String modifier = Modifier.toString(m);
			System.out.println(modifier);
			//2.获取属性的变量类型
			Class type = f.getType();
			System.out.println(type.getName());
			//3.获取属性名
		}
		
	}
	
	/*
	 * 调用运行时类中指定的属性
	 */
	@Test
	public void test3() throws Exception{
		Class clazz = Person.class;
		//1.获取指定的属性
		//getField():获取指定运行时类中声明为public的名为fieldName的属性
		Field name = clazz.getField("name");
		//2.创建运行时类的对象
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		//3.将运行时类对象的指定属性赋值
		name.set(p, "zhangsan");
		System.out.println(p);
		//getDeclaredField():获取指定运行时类中名为fieldName的属性
		Field age = clazz.getDeclaredField("age");
		//由于属性被权限修饰符的限制,为了保证可以给属性赋值,需要在操作前使得此属性可被操作
		age.setAccessible(true);
		age.set(p, 21);
		System.out.println(p);
	}
	
}
