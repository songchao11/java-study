package com.study.fanshe;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class TestReflection {

	/*
	 * ��û�з���֮ǰ,��δ���һ����Ķ���,���������еķ���,����
	 */
	@Test
	public void test1() throws Exception{
		Person p = new Person();
		p.setName("����");
		p.setAge(21);
		System.out.println(p);
		p.show();
//		p.display("HK");
	}
	
	/*
	 * ���˷���֮��,����ͨ�����䴴��һ����Ķ���,���������еĽṹ
	 */
	@Test
	public void test2() throws Exception{
		Class clazz = Person.class;
		//1.����clazz��Ӧ������ʱ��Person��Ķ���
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		//2.ͨ���������������ʱ��ָ��������
		//2.1
		Field f1 = clazz.getField("name");
		f1.set(p, "kaka");
		System.out.println(p);
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);//���Է���˽������
		f2.set(p, 21);
		System.out.println(p);
		//3.ͨ�������������ʱ���ָ������
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);
		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p, "HZ");
	}
	
	/*
	 * java.lang.Class:�Ƿ����Դͷ
	 * ���Ǵ�����һ����,ͨ������(javac.exe),���ɶ�Ӧ��.class�ļ�.֮������
	 * ʹ��javac.exe����(JVM�����������ɵ�)��.class�ļ�.��.class�ļ����ص�
	 * �ڴ��Ժ�,����һ������ʱ��,����ڻ�����.��ô�������ʱ�౾�����һ��Class��ʵ��
	 * 1.ÿһ������ʱ��ֻ����һ��
	 * 2.����Classʵ��֮��,���ǲſ��Խ������²���:
	 * 	1)������Ӧ������ʱ��Ķ���
	 * 	2)��ȡ��Ӧ������ʱ��������ṹ(����,����,������,�ڲ���,����,���ڵİ�,�쳣,ע��.)
	 * 	3)���ö�Ӧ������ʱ���ָ���ṹ(����,����,������)
	 * 	4)�����Ӧ��:��̬����
	 */
	@Test
	public void test3(){
		Person p = new Person();
		//ͨ������ʱ��Ķ���,������getClass(),����������ʱ��
		Class clazz = p.getClass();
		System.out.println(clazz);
	}
	
	/*
	 * ��λ�ȡClass��ʵ��(����)
	 */
	@Test
	public void test4() throws Exception{
		//1.��������ʱ�౾���.class����
		Class clazz1 = Person.class;
		System.out.println(clazz1);
		Class clazz2 = String.class;
		System.out.println(clazz2);
		//2.ͨ������ʱ��Ķ����ȡ
		Person p = new Person();
		Class clazz3 = p.getClass();
		System.out.println(clazz3);
		//3.ͨ��Class�ľ�̬������ȡ
		String className = "com.study.fanshe.Person";
		Class clazz4 = Class.forName(className);
		System.out.println(clazz4);
		//4.(�˽�)ͨ����ļ�����
		ClassLoader cLoader = this.getClass().getClassLoader();
		Class clazz5 = cLoader.loadClass(className);
		System.out.println(clazz5);
	}
	
	/*
	 * ������ļ�����.ClassLoader
	 */
	@Test
	public void test5() throws Exception{
		ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
		System.out.println(classLoader1);
		ClassLoader classLoader2 = classLoader1.getParent();
		System.out.println(classLoader2);
		ClassLoader classLoader3 = classLoader2.getParent();
		System.out.println(classLoader3);
		Class clazz1 = Person.class;
		ClassLoader loader1 = clazz1.getClassLoader();
		System.out.println(loader1);
		String className = "java.lang.Object";
		Class clazz2 = Class.forName(className);
		ClassLoader loader2 = clazz2.getClassLoader();
		System.out.println(loader2);
		
		//��������
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream is = loader.getResourceAsStream("com\\study\\fanshe\\jdbc.properties");
		Properties prop = new Properties();
		prop.load(is);
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	}
	
}
