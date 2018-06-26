package com.study.doublelinkedlist;

/**
 * ������
 * @author song
 *
 */
public class SingleLinkedList<T> {
	
	/*
	 * �ڵ���
	 */
	private class Node<T>{
		T item;
		Node<T> next;
		public Node(T item, Node<T> next) {
			this.item = item;
			this.next = next;
		}
	}
	
	//������
	private int size = 0;
	
	//ͷ���
	private Node<T> head;
	
	public SingleLinkedList(){}
	
	/*
	 * ��Ԫ����ӵ�������ǰ��
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
	 * ��Ԫ����ӵ��������
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
	 * ���Ԫ�ص�β��
	 */
	public boolean add(T t){
		linkLast(t);
		return true;
	}
	
	/*
	 * �����±��ȡָ���ڵ�
	 */
	public Node<T> node(int index){
		Node<T> f = head;
		for(int i = 0;i < index;i++){
			f = f.next;
		}
		return f;
	}
	
	/*
	 * �����±��ȡԪ��
	 */
	public T get(int index){
		return node(index).item;
	}
	
	/*
	 * ��ȡ������
	 */
	public int size(){
		return size;
	}

}
