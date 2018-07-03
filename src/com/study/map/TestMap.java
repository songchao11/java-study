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
	 * 1.key����Set����ŵ�,�����ظ�.value����Collection����ŵ�,���ظ�
	 * һ��key-value��,��һ��Entry.���е�Entry������Set��ŵ�,Ҳ�ǲ����ظ���.
	 * 2.��HashMap�����Ԫ��ʱ,�����key�������equals()����,�ж�����key�Ƿ���ͬ,
	 * ����ͬ,��ֻ����ӽ�����ӵ��Ǹ�Ԫ��
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
		//����key
		Set keySet = map.keySet();
		for(Object obj : keySet){
			System.out.println(obj);
		}
		System.out.println("------------");
		//����value
		Collection c = map.values();
		Iterator it = c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("------------");
		//����entry
		Set entrySet = map.entrySet();
		for(Object obj : entrySet){
			Map.Entry entry = (Entry) obj;
			System.out.println(entry);
		}
		
	}

}
