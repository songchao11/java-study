package com.study.doublelinkedlist;


/**
 * ˫������
 * @author song
 *
 * @param <T>
 */
public class LinkedList<T> {
	
	/**
	 * �ڵ���
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
	 * ��һ���ڵ������
	 */
	Node<T> first;
	
	/*
	 * ���һ���ڵ������
	 */
	Node<T> last;
	
	/*
	 * list��Ԫ�ص���Ŀ
	 */
	private int size = 0;
	
	/*
	 * ��������
	 */
	int modCount = 0;
	
	public LinkedList(){}
	
	/*
	 * �Ѵ����Ԫ�ر�Ϊ��һ��Ԫ��
	 */
	public void linkFirst(T t){
		//ʹ�ڵ�fָ��ԭ����ͷ���
		Node<T> f = first;
		//�½�һ���ڵ�newNode,��ڵ��ǰָ��ָ��null,��ָ��ָ��ԭ����ͷ���
		Node<T> newNode = new Node<T>(null, t, f);
		//���ԭ����ͷ���Ϊnull,����βָ��,����ʹԭ����ͷ���f��ǰ��ָ��ָ���µ�ͷ�ڵ�newNode
		if(f == null){
			last = newNode;
		}else{
			f.prev = newNode;
		}
		//ͷָ��ָ���µ�ͷ���
		first = newNode;
		size++;
		modCount++;
	}
	
	/*
	 * ��Ԫ����ӵ����
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
	 * ��list�����Ԫ��
	 */
	public boolean add(T t){
		linklast(t);
		return true;
	}

	/*
	 * ����list��С
	 */
	public int size(){
		return size;
	}
	
	/*
	 * ��ָ���ڵ�֮ǰ����Ԫ��
	 */
	public void linkBefore(T t, Node<T> succ){
		
	}

}
