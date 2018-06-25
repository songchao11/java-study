package com.study.linkedlist;

public class Node<T> {

	//为了方便两个变量都使用public
	//存放数据的变量,先弄简单点,直接将类型定义为int
	public T data;
	//存放节点的变量,默认为null
	public Node<T> next;
	public Node(){
		
	}
	//在构造时就能给data赋值
	public Node(T data){
		this.data = data;
	}
	
	
}
