package com.study.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class TestMap {
	
	/*
	 * HashMap:
	 * 1.key是用Set来存放的,不可重复.value是用Collection来存放的,可重复
	 * 一个key-value对,是一个Entry.所有的Entry都是用Set存放的,也是不可重复的.
	 * 2.向HashMap中添加元素时,会调用key所在类的equals()方法,判断两个key是否相同,
	 * 若相同,则只能添加进后添加的那个元素
	 */
	@Test
	public void testHashMap(){
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("BB", 456);
		map.put("AA", 555);
		System.out.println(map.get("AA"));
	}
	
	@Test
	public void testTraverse(){
		Map map = new HashMap();
		map.put("AA", 123);
		map.put("BB", 456);
		map.put("CC", "SS");
		map.put("DD", "GG");
		map.put("EE", "CC");
		//遍历key
		Set keySet = map.keySet();
		for(Object obj : keySet){
			System.out.println(obj);
		}
		System.out.println("------------");
		//遍历value
		Collection c = map.values();
		Iterator it = c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("------------");
		//遍历entry
		Set entrySet = map.entrySet();
		for(Object obj : entrySet){
			Map.Entry entry = (Entry) obj;
			System.out.println(entry);
		}
		
	}

}
