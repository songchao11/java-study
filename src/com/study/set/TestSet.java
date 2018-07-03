package com.study.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestSet {
	
	/*
	 * Set:�洢��Ԫ���������,�����ظ���
	 * 1.������: ������ != �����.��������������ָԪ���ڵײ�洢��λ���������
	 * 2.�����ظ���:����Set����ӽ���ͬԪ�ص�ʱ��,��������������ӽ�ȥ
	 * 
	 * ˵��:Ҫ����ӽ�Set�е�Ԫ��������,һ��Ҫ��дequals()��hashCode()����.
	 * 
	 * Set�е�Ԫ����δ洢����?ʹ���˹�ϣ�㷨
	 * 
	 * ����Set����Ӷ���ʱ,���ȵ��ô˶����������hashCode()����,�������Ĺ�ϣֵ,
	 * �˹�ϣֵ�����˴˶�����Set�еĴ洢λ��.����λ��֮ǰû�ж���洢,���������ֱ�Ӵ洢����λ��.
	 * ����λ�����ж���洢,��ͨ��equals()�Ƚ������������Ƿ���ͬ.�����ͬ,��һ������Ͳ�������ӽ���
	 */
	@Test
	public void testHashSet(){
		Set set = new HashSet();
		set.add(777);
		set.add(35);
		set.add("AA");
		set.add(new String("AA"));
		set.add("CC");
		set.add(null);
		Person p1 = new Person("zhangsan", 22);
		Person p2 = new Person("lisi", 21);
		Person p3 = new Person("lisi", 21);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println(set.size());
		System.out.println(set);
	}
	
	/*
	 * LinkedHashSet:ʹ������ά����һ����ӽ������е�˳��.
	 * ���µ����Ǳ���LinkedHashSet����Ԫ��ʱ,�ǰ�����ӽ�ȥ��˳�������
	 */
	@Test
	public void testLinkedHashSet(){
		Set set = new LinkedHashSet();
		set.add(777);
		set.add(35);
		set.add("AA");
		set.add(new String("AA"));
		set.add("CC");
		set.add(null);
		System.out.println(set);
	}
	
	/*
	 * TreeSet:
	 * 1.��TreeSet����ӵ�Ԫ�ر�����ͬһ�����
	 * 2.���԰�����ӽ������е�Ԫ�ص�ָ����˳�����.��String,��װ���Ĭ�ϰ��մ�С�����˳�����
	 * 3.����TreeSet������Զ�����Ķ���ʱ,���������򷽷�:��Ȼ����   ��������
	 * 4.��Ȼ����:Ҫ���Զ�����ʵ��java.lang.Comparable�ӿڲ���д��compareTo����
	 * 5.��TreeSet�����Ԫ��ʱ,���Ȱ���compareTo���бȽ�.һ������0,��Ȼ�����������������ͬ,
	 * ���������Ϊ������������ͬ��,������һ�����󽫲��ܱ���ӽ���
	 */
	@Test
	public void testTreeSet(){
		Set set = new TreeSet();
		set.add(new Person("AA",21));
		set.add(new Person("GG",20));
		set.add(new Person("DD",25));
		set.add(new Person("MM",28));
		set.add(new Person("BB",23));
		for(Object p : set){
			System.out.println(p);
		}
	}

}
