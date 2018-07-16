package com.study.agency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{
	void info();
	void fly();
}
class SuperMan implements Human{
	 public void info(){
		 System.out.println("I am SuperMan");
	 }
	 public void fly(){
		 System.out.println("I can Fly");
	 }
}
class HumanUtil{
	public void method1(){
		System.out.println("method1");
	}
	public void method2(){
		System.out.println("method2");
	}
}
 
class MyInvocationHandler1 implements InvocationHandler{
	 Object obj;//����������������
	
	 public void setObject(Object obj){
		 this.obj = obj;
	 }
	 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		HumanUtil hu = new HumanUtil();
		hu.method1();
		
		Object returnVal = method.invoke(obj, args);
		hu.method2();
		return returnVal;
	}
}
class MyProxy{
	//��̬�Ĵ���һ�����������
	public static Object getProxyInstance(Object obj){
		MyInvocationHandler1 handler = new MyInvocationHandler1();
		handler.setObject(obj);
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), handler);
	}
}

public class TestAOP {
	public static void main(String[] args) {
		SuperMan sMan = new SuperMan();//����һ����������Ķ���
		Object obj = MyProxy.getProxyInstance(sMan);//����һ�����������
		Human hu = (Human)obj;
		hu.info();//ͨ��������Ķ��������д�ĳ��󷽷�
		System.out.println();
		hu.fly();
		
		NickClothFactory nick = new NickClothFactory();
		Object obj1 = MyProxy.getProxyInstance(nick);
		ClothFactory cf = (ClothFactory)obj1;
		cf.productCloth();
		
	}
}
