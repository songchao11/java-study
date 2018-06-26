package com.study.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestList {
	
	public static void main(String[] args) {
//		List<Integer> lists = new ArrayList<Integer>();
//		lists.add(1);
//		List<String> list1 = new ArrayList<String>(1);
//		list1.add("aa");
//		list1.add("ww");
//		System.out.println(lists.get(0));
		List s = new ArrayList();
		s.add("A");
		s.add("B");
		List<String> strs = new ArrayList<String>(s);
		for(String a : strs){
			System.out.println(a);
		}
	}

}
