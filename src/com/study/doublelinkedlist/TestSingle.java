package com.study.doublelinkedlist;

public class TestSingle {
	
	public static void main(String[] args) {
		SingleLinkedList<String> sList = new SingleLinkedList<String>();
		sList.add("AA");
		sList.add("BB");
		sList.add("CC");
		sList.add("DD");
		sList.add("EE");
		sList.add("FF");
		sList.add("GG");
		sList.linkFirst("SS");
		for(int i = 0;i < sList.size();i++){
			System.out.println(sList.get(i));
		}
	}

}
