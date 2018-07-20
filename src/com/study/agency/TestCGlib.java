package com.study.agency;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/*
 * ��̬����ĵڶ��ַ�ʽ:CGlib
 * cglib���������ʵ�ִ����,ԭ���Ƕ�ָ����ҵ��������һ������,����������ҵ�񷽷�ʵ�ִ���.
 * ��Ϊ���õ��Ǽ̳�,���Բ��ܶ�final���ε�����д���
 */

/*
 * 1.���ȶ���ҵ����,����ʵ�ֽӿ�(��Ȼʵ�ֽӿ�Ҳ�ǿ��Ե�,��Ӱ��)
 */
class BookImpl{
	public void addBook(){
		System.out.println("�����鼮");
	}
}
/*
 * ʵ��MethodInterceptor��������ӿ�,����������
 */
class BookCGlib implements MethodInterceptor{
	private Object target;//ҵ�������,���������н���������ҵ�񷽷�����
	
	//�൱��jdk��̬�����еİ�
	public Object getInstance(Object target){
		this.target = target;//��ҵ�񷽷���ֵ
		//������ǿ��,����������̬������
		Enhancer enhancer = new Enhancer();
		//Ϊ��ǿ��ָ��Ҫ�����ҵ����(��:Ϊ�������ɵĴ�����ָ������)
		enhancer.setSuperclass(this.target.getClass());
		//���ûص�:���ڴ����������з����ĵ���,�������CallBack,��CallBack����Ҫʵ��intercept()������������
		enhancer.setCallback(this);
		return enhancer.create();
	}

	//ʵ�ֻص�����
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("-----Ԥ����-------");
		proxy.invokeSuper(obj, args);//����ҵ����(�����еķ���)
		System.out.println("-----���ú����-----");
		return null;
	}
	
} 
/*
 * ����ҵ����ʹ��������,Ȼ��ͨ�����������.getInstance(ҵ�������)����һ����̬���������(����ҵ���������,
 * ������ҵ��������ָ����.���ͨ����̬�����������з�������)
 */
public class TestCGlib {
	public static void main(String[] args) {
		BookImpl bookImpl = new BookImpl();
		BookCGlib cglib = new BookCGlib();
		BookImpl bookCGlib = (BookImpl) cglib.getInstance(bookImpl);
		bookCGlib.addBook();
	}
}
