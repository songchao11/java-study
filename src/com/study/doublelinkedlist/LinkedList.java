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
		Node<T> prev;//ǰ�ýڵ�
		Node<T> next;//���ýڵ�
		public Node(Node<T> prev, T item, Node<T> next) {
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
	
	/*
	 * ��һ���ڵ������(ͷ)
	 */
	Node<T> first;
	
	/*
	 * ���һ���ڵ������(β)
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
	 * �������Ԫ�ز嵽������ǰ��Ĳ���:
	 * ��ȡ�����֮ǰ��ͷ�����Ϊf
	 * �ڽ���Ҫ�����Ԫ�ط�װ��һ���ڵ�newNode,�����ָ��ָ��f
	 * �����ԭ����ͷ���Ϊnull(��ʱ����Ϊ��),�ͽ�β�ڵ�ָ��newNode;
	 * ����ʹԭ����ͷ���f��ǰ��ָ��ָ��newNode
	 * ��ͷ�ڵ�ָ���µ�ͷ���
	 */
	public void linkFirst(T t){
		//ʹ�ڵ�fָ��ԭ����ͷ���
		Node<T> f = first;
		//�½�һ���ڵ�newNode,��ڵ��ǰָ��ָ��null,��ָ��ָ��ԭ����ͷ���
		Node<T> newNode = new Node<T>(null, t, f);
		//���ԭ����ͷ���Ϊnull,����β�ڵ�,����ʹԭ����ͷ���f��ǰ��ָ��ָ���µ�ͷ�ڵ�newNode
		if(f == null){
			last = newNode;
		}else{
			f.prev = newNode;
		}
		//ͷ�ڵ�ָ���µ�ͷ���
		first = newNode;
		size++;
		modCount++;
	}
	
	/*
	 * ��Ԫ����ӵ����
	 * A  B  C
	 * ��Ԫ����ӵ����Ĳ���:
	 * ��ȡ�����֮ǰ��β�ڵ���Ϊl
	 * �ڽ���Ҫ�����Ԫ�ط�װ��һ���ڵ�newNode,������ǰ��ָ��ָ��l
	 * �����β�ڵ�Ϊnull(˵����ʱ����Ϊ��),�ͽ�ͷ���ָ��newNode;
	 * ����ͽ�ԭ��β�ڵ�ĺ���ָ��ָ��newNode
	 * ��β�ڵ�ָ���µ�β�ڵ�
	 */
	public void linklast(T t){
		//ʹ�ڵ�lָ��ԭ����β�ڵ�
		Node<T> l = last;
		//�½��ڵ�newNode,������ǰ��ָ��ָ��l
		Node<T> newNode = new Node<T>(l, t, null);
		//���ԭ����β�ڵ�Ϊnull,����ͷ�ڵ�,����ʹԭ����β�ڵ�l�ĺ���ָ��ָ���µ�ͷ���newNode
		if(l == null){
			first = newNode;
		}else{
			l.next = newNode;
		}
		//β�ڵ�ָ���µ�β���
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
	 * A   B
	 * ��Ԫ�ز���B�ڵ�֮ǰ,��Ҫ�����²���:
	 * �ٻ��ָ���ڵ�B��ǰ��A
	 * �ڽ���Ҫ�����Ԫ�ط�װ��һ���ڵ�S,��ָ������ǰ��ָ��ͺ���ָ��ֱ�ΪA��B
	 * �۽�B�ڵ��ǰ��ָ�����ΪS
	 * �������ж�ָ���ڵ�B��ǰ���Ƿ�Ϊnull.���Ϊnull,��ֱ�ӽ��ڵ�S��Ϊͷ���;
	 * �����Ϊnull,�ͽ��ڵ�A�ĺ���ָ�����ΪS
	 */
	private void linkBefore(T t, Node<T> succ){
		//���ָ���ڵ��ǰ��
		Node<T> pred = succ.prev;
		//�½��ڵ�newNode,ǰ��ָ��ָ��pred,����ָ��ָ��succ
		Node<T> newNode = new Node<T>(pred, t, succ);
		//succ��ǰ��ָ��ָ��newNode
		succ.prev = newNode;
		//���ָ���ڵ��ǰ��Ϊnull,��newNode��Ϊͷ���,�������pred�ĺ��ýڵ�
		if(pred == null){
			first = newNode;
		}else{
			pred.next = newNode;
		}
		size++;
		modCount++;
	}
	/*
	 * �����±��ȡָ���ڵ�(�±���㿪ʼ)
	 */
	private Node<T> node(int index){
		Node<T> x = first;
		for(int i = 0;i < index;i++){
			x = x.next;
		}
		return x;
	}
	/*
	 * ����node�����Ż�
	 * ����:
	 * �ж�index�Ƿ�С��size��һ��,��С,���ͷ�ڵ�������
	 * ����,���β�ڵ���ǰ����
	 */
	private Node<T> nodeOptimizing(int index){
		Node<T> x = null;
		if(index < size/2){
			x = first;
			for(int i = 0;i < index;i++){
				x = x.next;
			}
		}else{
			x = last;
			for(int i = size-1;i > index;i--){
				x = x.prev;
			}
		}
		return x;
	}
	/*
	 * ��ȡָ���±��ֵ
	 */
	public T get(int index) throws Exception{
		checkIndex(index);
		return nodeOptimizing(index).item;
	}
	/*
	 * ����±�ĺϷ���
	 */
	private void checkIndex(int index) throws Exception{
		if(index < 0 || index > size){
			throw new Exception("�±�Ƿ��쳣");
		}
	}
	
	/*
	 * ɾ��ָ��λ��Ԫ��
	 */
	public T remove(int index) throws Exception{
		checkIndex(index);
		return unLink(nodeOptimizing(index));
	}
	
	/*
	 * ɾ��ָ��Ԫ��
	 * ����:
	 * �������ж�obj�Ƿ�Ϊnull,��Ϊnull,��Ҫ��"==";��Ϊnull,��ʹ��equals
	 * ��ѭ�������ҵ�obj��Ӧ�Ľڵ㲢ɾ��
	 */
	public boolean remove(Object obj){
		Node<T> x = first;
		if(obj == null){
			while(x.item != obj){
				//û���ҵ���Ҫɾ���Ľڵ�
				if(x.next == null){
					return false;
				}
				x = x.next;
			}
			unLink(x);
			return true;
		}else{
			while(!x.item.equals(obj)){
				if(x.next == null){
					return false;
				}
				x = x.next;
			}
			unLink(x);
			return true;
		}
	}
	
	/*
	 * ��ָ��λ�����Ԫ��
	 */
	public void add(int index, T t) throws Exception{
		checkIndex(index);
		linkBefore(t, nodeOptimizing(index));
	}
	
	/*
	 * ɾ��ָ���ڵ�,������ָ���ڵ�Ԫ�ص�ֵ
	 * ����:
	 * �ٻ�ȡָ���ڵ��ǰ�ýڵ�(prev)�ͺ��ýڵ�(next)
	 * ����ǰ�ýڵ�Ϊnull,��˵��xΪͷ���,��ʱֻҪ��next��Ϊ�µ�ͷ��㼴��,����ͽ�prev��nextָ��next,����x��prev��Ϊnull
	 * �������ýڵ�Ϊnull,��˵��xΪβ�ڵ�,��ʱֻҪ��prev��Ϊ�µ�β�ڵ�,���򽫺��ýڵ��prevָ��prev,����x��next��Ϊnull
	 * �ܽ�x��item��Ϊnull,size-1
	 */
	private T unLink(Node<T> x){
		T element = x.item;
		Node<T> next = x.next;
		Node<T> prev = x.prev;
		//��prevΪnull,��˵��xΪͷ���,��ʱֻҪ��next��Ϊ�µ�ͷ���,����prev��nextָ��next,x��prev��Ϊnull
		if(prev == null){
			first = next;
		}else{
			prev.next = next;
			x.prev = null;
		}
		//��nextΪnull,��˵��xΪβ�ڵ�,��ʱֻҪ��prev��Ϊ�µ�β�ڵ�,����next��prevָ��prev,x��next��Ϊnull
		if(next == null){
			last = prev;
		}else{
			next.prev = prev;
			x.next = null;
		}
		x.item = null;
		size--;
		modCount++;
		return element;
	}
	
	/*
	 * ����ָ��λ�õ�ֵ
	 */
	public boolean set(int index, T t) throws Exception{
		checkIndex(index);
		Node<T> x = nodeOptimizing(index);
		x.item = t;
		return true;
	}

}
