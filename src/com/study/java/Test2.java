package com.study.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Test2 {

	public static void main(String[] args) {
		List<String> strs = new LinkedList<String>();
		strs.add("AA");
//		strs.add(null);
		strs.add("BB");
//		strs.add(null);
		strs.add("CC");
//		strs.add(null);
		strs.add("AA");
//		strs.add(null);
		for(String s :strs){
			System.out.print(s+" ");
		}
		System.out.println();
//		strs.remove("AA");
		strs.add(22, "kk");
		for(String s :strs){
			System.out.print(s+" ");
		}
		System.out.println();
		Map<String, String> map = new ConcurrentHashMap<>();
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new Hashtable<>();
		
//		System.out.println(strs.remove(10));
		
		Set set = new HashSet();
		
	}
	
}
