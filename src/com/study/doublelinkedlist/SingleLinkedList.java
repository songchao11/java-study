package com.study.doublelinkedlist;

/**
 * ������ʵ����
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
	 * ����:
	 * �ٽ�Ԫ�ط�װ��һ���ڵ�newNode(��ʱ����ָ��next)
	 * ���ж�ͷ����Ƿ�Ϊnull,��Ϊnull,ֱ�ӽ��ڵ�newNode����Ϊͷ���
	 * ������Ϊnull,��newNode��nextָ��֮ǰ��ͷ���head,Ȼ���ٽ�newNode��Ϊ�µ�ͷ���
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
	 * ����:
	 * �����Ƚ�Ԫ�ط�װ��һ���ڵ�newNode,��Ϊ�ǲ��뵽�������,����newNode��nextָ��null
	 * ���ж�ͷ����Ƿ�Ϊnull,��Ϊnull,��ֱ�ӽ�newNode��Ϊͷ���
	 * ������Ϊnull,������±��ҵ���������һ���ڵ�
	 * ��Ȼ�����һ���ڵ��nextָ��newNode
	 * ˼��:��ʵ��������һ��β�ڵ�,�������ڵ���뵽����ĩβ�͸��ӷ���
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
	 * ��Ԫ�ز��뵽ָ���ڵ�֮ǰ
	 * A  0  B
	 * ��Ԫ�ز��뵽0λ�ò���:
	 * �����indexΪ0,��˵����ʱ�ǽ�Ԫ����ӵ�ͷ��
	 * �ڸ����±��ȡ��0λ�õ�ǰһ���ڵ�A�Լ���һ���ڵ�B
	 * ��Ȼ��Ԫ�ط�װ��һ���ڵ�newNode,newNode��nextָ��ڵ�B
	 * �ܽ�ǰһ���ڵ�A��nextָ��newNode
	 */
	public void add(int index, T t){
		Node<T> f = head;
		Node<T> newNode = null;
		//��Ԫ�ز����һλ
		if(index == 0){
			newNode = new Node<T>(t, f);
			head = newNode;
		}else{
			for(int i = 0;i < index - 1;i++){
				f = f.next;
			}
			Node<T> oldNext = f.next;
			newNode = new Node<T>(t, oldNext);
			f.next = newNode;
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
	 * �����±�ѭ������,֪���ҵ�indexλ��Ϊֹ
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
	public T get(int index) throws Exception{
		checkIndex(index);
		return node(index).item;
	}
	
	/*
	 * ��ȡ������
	 */
	public int size(){
		return size;
	}
	
	/*
	 * �ж������Ƿ�Ϊ��
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	/*
	 * ɾ��ָ��Ԫ��,����ж����ͬԪ��,��ɾ����һ��
	 * ע��:�������������������������ϵ���ͬԪ��,ֻ�Ƴ���һ���ҵ���Ԫ��
	 * ����:
	 * �ٶ��������ڵ�:һ������Ҫɾ��Ԫ�صĽڵ�current,��һ������Ҫɾ���ڵ����һ���ڵ�previous(�������Ǵ�head�ڵ㿪ʼ)
	 * ��Ȼ��ͨ����Ҫɾ����Ԫ��obj,�ҵ�obj����Ӧ�Ľڵ��Լ���һ���ڵ�
	 * ������ɾ���Ľڵ���ͷ���(��ʱcurrent��previous����head�ڵ�),��ֱ�ӽ�head����һ���ڵ����¶���Ϊͷ���
	 * ����ɾ���Ľڵ㲻��ͷ���,�ͽ���ɾ������һ���ڵ�(previous)��nextָ��ɾ���ڵ�(current)����һ���ڵ�
	 * ���ٽ�size-1
	 */
	public boolean remove(Object obj){
		//�ж������Ƿ�Ϊ��
		if(size == 0){
			return false;
		}
		Node<T> current = head;//��Ҫ��ɾ���Ľڵ�
		Node<T> previous = head;//��ɾ���ڵ����һ���ڵ�
		while(current.item != obj){
			//current.nextΪnull��˵�����������ѱ�������,��û���ҵ���Ҫ��ɾ����Ԫ��
			if(current.next == null){
				return false;
			}else{
				previous = current;
				current = current.next;
			}
		}
		//��ɾ���Ľڵ���ͷ���
		if(current == head){
			head = head.next;
		}else{
			previous.next = current.next;
		}
		size--;
		return true;
	}

	/*
	 * ɾ��ָ��λ�õ�Ԫ��
	 * ����:
	 * �����ȶ��������ڵ�:Ҫ��ɾ���Ľڵ�(current)��Ҫ��ɾ���ڵ����һ���ڵ�(previous)
	 * �ڸ����±��ͷ��ʼ�ҵ�Ҫ��ɾ���Ľڵ��Լ�����һ���ڵ�
	 * �����Ҫ��ɾ���Ľڵ���ͷ���,��ֱ�ӽ�ͷ������һ���ڵ���Ϊ�µ�ͷ���
	 * �ܷ���ͽ�previous��nextָ��current��next
	 * ���ٽ�size-1
	 */
	public T remove(int index) throws Exception{
		T item = null;
		checkIndex(index);
		Node<T> current = head;//Ҫ��ɾ���Ľڵ�
		Node<T> previous = head;//Ҫ��ɾ���ڵ����һ���ڵ�
		for(int i = 0;i < index;i++){
			previous = current;
			current = current.next;
		}
		item = current.item;
		if(current == head){
			head = head.next;
		}else{
			previous.next = current.next;
		}
		size--;
		return item;
	}
	
	/*
	 * ����ָ��λ��Ԫ��ֵ
	 * ����:
	 * ���ж��±��Ƿ�Խ��
	 * �ڸ����±��ҵ�ָ���ڵ�
	 * ��Ȼ�󽫽ڵ��ֵ�ĵ�
	 */
	public boolean set(int index, T t) throws Exception{
		checkIndex(index);
		Node<T> l = head;
		for(int i = 0;i < index;i++){
			l = l.next;
		}
		l.item = t;
		return true;
	}
	
	/*
	 * �±���
	 */
	private void checkIndex(int index) throws Exception{
		if(index < 0 || index > size-1){
			throw new Exception("�±��쳣");
		}
	}

}
