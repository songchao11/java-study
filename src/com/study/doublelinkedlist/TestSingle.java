package com.study.doublelinkedlist;

public class TestSingle {
	
	public static void main(String[] args) {
		SingleLinkedList<String> sList = new SingleLinkedList<String>();
		System.out.println(sList.isEmpty());
		sList.add("AA");
		sList.add("BB");
		sList.add("CC");
		sList.add("DD");
		sList.add("EE");
		sList.add("FF");
		sList.add("GG");
		
		for(int i = 0;i < sList.size();i++){
			System.out.print(sList.get(i)+"\t");
		}
		System.out.println();
		sList.add(2, "PIG");
		for(int i = 0;i < sList.size();i++){
			System.out.print(sList.get(i)+"\t");
		}
		System.out.println();
		sList.remove("KK");
		sList.set(7, "HAHAHA");
		for(int i = 0;i < sList.size();i++){
			System.out.print(sList.get(i)+"\t");
		}
		
	}

}
