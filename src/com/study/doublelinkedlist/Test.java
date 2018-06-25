package com.study.doublelinkedlist;

public class Test {
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
//		list.add("zhangsan");
//		list.add("lisi");
//		list.add("wang");
		list.linkFirst("AAA");
		list.linkFirst("BBB");
		System.out.println(list.size());
	}

}
