package com.study.agency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * ��̬�����ʹ��	
 */

interface Subject{
	void action();
}

//��������
class RealSubject implements Subject{
	@Override
	public void action() {
		System.out.println("���Ǳ�������");
	}
}

class MyInvocationHandler implements InvocationHandler{
	Object obj;//ʵ���˽ӿڵı�������Ķ��������
	//����:�ٸ���������Ķ���ʵ���� �ڷ���һ��������Ķ���
	public Object blind(Object obj){
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	//��ͨ��������Ķ�����Ա���д�ķ�������ʱ,����ת��Ϊ������invoke�����ĵ���
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//method�����ķ���ֵ
		Object returnVal = method.invoke(obj, args);
		return returnVal;
	}
	
}

public class TestProxy {
	public static void main(String[] args) {
		//1.��������Ķ���
		RealSubject real = new RealSubject();
		//2.����һ��ʵ����InvocationHandler�ӿڵ���Ķ���
		MyInvocationHandler handler = new MyInvocationHandler();
		//3.����blind()����,��̬�ķ���һ��ͬ��ʵ����real������ʵ�ֵĽӿ�Subject�Ĵ��������
		Object obj = handler.blind(real);
		Subject sub = (Subject)obj;//��ʱsub���Ǵ��������
		sub.action();//ת����InvacationHandler�ӿڵ�ʵ�����invoke()�����ĵ���
		
	}
}
