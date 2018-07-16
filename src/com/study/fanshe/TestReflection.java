package com.study.fanshe;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

import org.junit.Test;

public class TestReflection {

	/*
	 * 在没有反射之前,如何创建一个类的对象,并调用其中的方法,属性
	 */
	@Test
	public void test1() throws Exception{
		Person p = new Person();
		p.setName("张三");
		p.setAge(21);
		System.out.println(p);
		p.show();
//		p.display("HK");
	}
	
	/*
	 * 有了反射之后,可以通过反射创建一个类的对象,并调用其中的结构
	 */
	@Test
	public void test2() throws Exception{
		Class clazz = Person.class;
		//1.创建clazz对应的运行时类Person类的对象
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		//2.通过反射类调用运行时类指定的属性
		//2.1
		Field f1 = clazz.getField("name");
		f1.set(p, "kaka");
		System.out.println(p);
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true);//可以访问私有属性
		f2.set(p, 21);
		System.out.println(p);
		//3.通过反射调用运行时类的指定方法
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);
		Method m2 = clazz.getMethod("display", String.class);
		m2.invoke(p, "HZ");
	}
	
	/*
	 * java.lang.Class:是反射的源头
	 * 我们创建了一个类,通过编译(javac.exe),生成对应的.class文件.之后我们
	 * 使用javac.exe加载(JVM的类加载器完成的)此.class文件.此.class文件加载到
	 * 内存以后,就是一个运行时类,存放在缓存区.那么这个运行时类本身就是一个Class的实例
	 * 1.每一个运行时类只加载一次
	 * 2.有了Class实例之后,我们才可以进行如下操作:
	 * 	1)创建对应的运行时类的对象
	 * 	2)获取对应的运行时类的完整结构(属性,方法,构造器,内部类,父类,所在的包,异常,注解.)
	 * 	3)调用对应的运行时类的指定结构(属性,方法,构造器)
	 * 	4)反射的应用:动态代理
	 */
	@Test
	public void test3(){
		Person p = new Person();
		//通过运行时类的对象,调用其getClass(),返回其运行时类
		Class clazz = p.getClass();
		System.out.println(clazz);
	}
	
	/*
	 * 如何获取Class的实例(三种)
	 */
	@Test
	public void test4() throws Exception{
		//1.调用运行时类本身的.class属性
		Class clazz1 = Person.class;
		System.out.println(clazz1);
		Class clazz2 = String.class;
		System.out.println(clazz2);
		//2.通过运行时类的对象获取
		Person p = new Person();
		Class clazz3 = p.getClass();
		System.out.println(clazz3);
		//3.通过Class的静态方法获取
		String className = "com.study.fanshe.Person";
		Class clazz4 = Class.forName(className);
		System.out.println(clazz4);
		//4.(了解)通过类的加载器
		ClassLoader cLoader = this.getClass().getClassLoader();
		Class clazz5 = cLoader.loadClass(className);
		System.out.println(clazz5);
	}
	
	/*
	 * 关于类的加载器.ClassLoader
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
		
		//掌握如下
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream is = loader.getResourceAsStream("com\\study\\fanshe\\jdbc.properties");
		Properties prop = new Properties();
		prop.load(is);
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	}
	
}
