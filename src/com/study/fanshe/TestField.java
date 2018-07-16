package com.study.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class TestField {

	/*
	 * ��ȡ��Ӧ����ʱ�������
	 */
	@Test
	public void test1(){
		Class clazz = Person.class;
		//1.getFields():ֻ�ܻ�ȡ������ʱ�༰�丸��������Ϊpublic������
		Field[] fields = clazz.getFields();
		for(int i = 0;i < fields.length;i++){
			System.out.println(fields[i]);
		}
		//2.getDeclaredFields():��ȡ����ʱ�౾����������������
		Field[] fields1 = clazz.getDeclaredFields();
		for(Field f : fields1){
			System.out.println(f);
		}
	}
	
	/*
	 * Ȩ�����η�  ��������  ������
	 * ��ȡ���Եĸ������ֵ�����
	 */
	@Test
	public void test2(){
		Class clazz = Person.class;
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields){
			//1.��ȡÿ�����Ե�Ȩ�����η�b
			int m = f.getModifiers();
			String modifier = Modifier.toString(m);
			System.out.println(modifier);
			//2.��ȡ���Եı�������
			Class type = f.getType();
			System.out.println(type.getName());
			//3.��ȡ������
		}
		
	}
	
	/*
	 * ��������ʱ����ָ��������
	 */
	@Test
	public void test3() throws Exception{
		Class clazz = Person.class;
		//1.��ȡָ��������
		//getField():��ȡָ������ʱ��������Ϊpublic����ΪfieldName������
		Field name = clazz.getField("name");
		//2.��������ʱ��Ķ���
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		//3.������ʱ������ָ�����Ը�ֵ
		name.set(p, "zhangsan");
		System.out.println(p);
		//getDeclaredField():��ȡָ������ʱ������ΪfieldName������
		Field age = clazz.getDeclaredField("age");
		//�������Ա�Ȩ�����η�������,Ϊ�˱�֤���Ը����Ը�ֵ,��Ҫ�ڲ���ǰʹ�ô����Կɱ�����
		age.setAccessible(true);
		age.set(p, 21);
		System.out.println(p);
	}
	
}
