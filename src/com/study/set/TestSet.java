package com.study.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestSet {
	
	/*
	 * Set:存储的元素是无序的,不可重复的
	 * 1.无序性: 无序性 != 随机性.真正的无序性是指元素在底层存储的位置是无序的
	 * 2.不可重复性:当向Set中添加进相同元素的时候,后面的这个不能添加进去
	 * 
	 * 说明:要求添加进Set中的元素所在类,一定要重写equals()和hashCode()方法.
	 * 
	 * Set中的元素如何存储的呢?使用了哈希算法
	 * 
	 * 当向Set中添加对象时,首先调用此对象所在类的hashCode()方法,计算此类的哈希值,
	 * 此哈希值决定了此对象在Set中的存储位置.若此位置之前没有对象存储,则这个对象直接存储到此位置.
	 * 若此位置已有对象存储,再通过equals()比较这两个对象是否相同.如果相同,后一个对象就不能再添加进来
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
	 * LinkedHashSet:使用链表维护了一个添加进集合中的顺序.
	 * 导致当我们遍历LinkedHashSet集合元素时,是按照添加进去的顺序遍历的
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
	 * 1.向TreeSet中添加的元素必须是同一个类的
	 * 2.可以按照添加进集合中的元素的指定的顺序遍历.像String,包装类等默认按照从小到大的顺序遍历
	 * 3.当向TreeSet中添加自定义类的对象时,有两种排序方法:自然排序   定制排序
	 * 4.自然排序:要求自定义类实现java.lang.Comparable接口并重写其compareTo方法
	 * 5.向TreeSet中添加元素时,首先按照compareTo进行比较.一旦返回0,虽然是两个对象的属性相同,
	 * 但程序会认为两个对象是相同的,进而后一个对象将不能被添加进来
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
