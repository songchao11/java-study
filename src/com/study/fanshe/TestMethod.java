package com.study.fanshe;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestMethod {

	/*
	 * ��ȡ����ʱ��ķ���
	 */
	@Test
	public void test1(){
		Class clazz = Person.class;
		//1.getMethods():��ȡ����ʱ�༰�丸������������Ϊpublic�ķ���
		Method[] methods = clazz.getMethods();
		for(Method m : methods){
			System.out.println(m.getName());
		}
		System.out.println("----------");
		//2.getDeclaredMethods():��ȡ����ʱ�౾�����������з���
		Method[] methods1 = clazz.getDeclaredMethods();
		for(Method m : methods1){
			System.out.println(m);
		}
	}
	
	/*
	 * ע��  Ȩ�����η�  ����ֵ����  ������  �β��б�  �쳣
	 */
	@Test
	public void test2(){
		Class clazz = Person.class;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m : methods){
			//1.ע��
			Annotation[] ann = m.getAnnotations();
			for(Annotation a : ann){
				System.out.println(a);
			}
			//2.Ȩ�����η�
			String modi = Modifier.toString(m.getModifiers());
			System.out.print(modi+ " ");
			//3.����ֵ����
			Class returnType = m.getReturnType();
			System.out.print(returnType.getName()+ " ");
			//4.������
			System.out.print(m.getName()+" ");
			//5.�β��б�
			System.out.print("(");
			Class[] parameters = m.getParameterTypes();
			for(int i = 0;i < parameters.length;i++){
				System.out.print(parameters[i].getName()+"--"+i);
			}
			System.out.print(")");
			//6.�쳣
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
	 * ��������ʱ����ָ���ķ���
	 */
	@Test
	public void test3() throws Exception{
		Class clazz = Person.class;
		//getMethod():��ȡ��ΪmethodName��public����
		Method m1 = clazz.getMethod("show");
		Person p = (Person)clazz.newInstance();
		m1.invoke(p);
		Method m2 = clazz.getMethod("sayHello");
		m2.invoke(p);
		//getDeclaredMethod():��ȡ��ΪmethodName�ķ���
		Method m3 = clazz.getDeclaredMethod("display", String.class);
		//��ӷ���Ȩ��
		m3.setAccessible(true);
		m3.invoke(p, "�¼���");
	}
	
}
