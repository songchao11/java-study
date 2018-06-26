package com.study.doublelinkedlist;

public class Test {
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("zhangsan");
		list.add("lisi");
		list.add("wang");
		list.add("AA");
		list.add("BB");
		list.add("CCC");
		list.add("SSS");
		list.add("FFF");
		list.add("AWE");
		list.add("OPT");
//		list.linkFirst("AAA");
//		list.linkFirst("BBB");
		try {
			System.out.println(list.size());
			System.out.println(list.get(7));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("下标非法异常");
		}
	}

}
