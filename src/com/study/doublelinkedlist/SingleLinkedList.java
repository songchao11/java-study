package com.study.doublelinkedlist;

/**
 * 单链表
 * @author song
 *
 */
public class SingleLinkedList<T> {
	
	/*
	 * 节点类
	 */
	private class Node<T>{
		T item;
		Node<T> next;
		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
	}
	
	//链表长度
	private int size = 0;
	
	//头结点
	private Node<T> head;
	
	public SingleLinkedList(){}
	
	/*
	 * 将元素添加到链表最前面
	 */
	public void linkFirst(T t){
		Node<T> newNode = new Node<T>(t, null);
		if(head == null){
			head = newNode;
		}else{
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	/*
	 * 将元素添加到链表最后
	 * while(l.next != null){
				l = l.next;
			}
			l.next = newNode;
	 */
	public void linkLast(T t){
		Node<T> newNode = new Node<T>(t, null);
		Node<T> l = head;
		if(l == null){
			head = newNode;
		}else{
			for(int i = 0;i < size-1;i++){
				l = l.next;
			}
			l.next = newNode;
		}
		size++;
	}
	
	/*
	 * 添加元素到尾部
	 */
	public boolean add(T t){
		linkLast(t);
		return true;
	}
	
	/*
	 * 根据下标获取指定节点
	 */
	public Node<T> node(int index){
		Node<T> f = head;
		for(int i = 0;i < index;i++){
			f = f.next;
		}
		return f;
	}
	
	/*
	 * 根据下标获取元素
	 */
	public T get(int index){
		return node(index).item;
	}
	
	/*
	 * 获取链表长度
	 */
	public int size(){
		return size;
	}

}
