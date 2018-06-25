package com.study.doublelinkedlist;


/**
 * 双向链表
 * @author song
 *
 * @param <T>
 */
public class LinkedList<T> {
	
	/**
	 * 节点类
	 */
	private static class Node<T>{
		T item;
		Node<T> next;
		Node<T> prev;
		public Node(Node<T> prev, T item, Node<T> next) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
	
	/*
	 * 第一个节点的引用
	 */
	Node<T> first;
	
	/*
	 * 最后一个节点的引用
	 */
	Node<T> last;
	
	/*
	 * list中元素的数目
	 */
	private int size = 0;
	
	/*
	 * 操作次数
	 */
	int modCount = 0;
	
	public LinkedList(){}
	
	/*
	 * 把传入的元素变为第一个元素
	 */
	public void linkFirst(T t){
		//使节点f指向原来的头结点
		Node<T> f = first;
		//新建一个节点newNode,其节点的前指针指向null,后指针指向原来的头结点
		Node<T> newNode = new Node<T>(null, t, f);
		//如果原来的头结点为null,更新尾指针,否则使原来的头结点f的前置指针指向新的头节点newNode
		if(f == null){
			last = newNode;
		}else{
			f.prev = newNode;
		}
		//头指针指向新的头结点
		first = newNode;
		size++;
		modCount++;
	}
	
	/*
	 * 将元素添加到最后
	 */
	public void linklast(T t){
		Node<T> l = last;
		Node<T> newNode = new Node<T>(l, t, null);
		if(l == null){
			first = newNode;
		}else{
			l.next = newNode;
		}
		last = newNode;
		size++;
		modCount++;
	}
	
	/*
	 * 向list里添加元素
	 */
	public boolean add(T t){
		linklast(t);
		return true;
	}

	/*
	 * 返回list大小
	 */
	public int size(){
		return size;
	}
	
	/*
	 * 在指定节点之前插入元素
	 */
	public void linkBefore(T t, Node<T> succ){
		
	}

}
