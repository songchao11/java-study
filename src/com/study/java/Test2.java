package com.study.java;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test2 {

	public static void main(String[] args) {
		List<String> strs = new LinkedList<String>();
		strs.add("AA");
		strs.add("BB");
		strs.add("CC");
		strs.add("AA");
		for(String s :strs){
			System.out.print(s+" ");
		}
		System.out.println();
		strs.remove("AA");
		for(String s :strs){
			System.out.print(s+" ");
		}
		
		Map<String, String> map = new ConcurrentHashMap<>();
		Map<String, String> map1 = new HashMap<>();
		Map<String, String> map2 = new Hashtable<>();
		
	}
	
}
