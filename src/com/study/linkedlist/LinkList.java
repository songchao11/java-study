package com.study.linkedlist;

public class LinkList {

	Node<Person> head = new Node<Person>();
	
	/**
	 * ���Ӳ���
	 * ֱ��������������������Ľڵ㼴��,����ԭ�����һ���ڵ��nextָ���½ڵ�
	 * @param node
	 */
	public void addNode(Object obj){
		Node<Object> node = new Node<Object>(obj);
		//�������нڵ�,���������һ���ڵ�
		//һ���ƶ���ָ��(��ͷ��㿴��һ��ָ��ڵ��ָ��)
		Node temp = head;
		while(temp.next != null){//����������,ֱ�����������һ��������ѭ��
			temp = temp.next;//������һ���ڵ�,ָ����һ���ڵ�
		}
		temp.next = node;//tempΪ���һ���ڵ����ͷ�ڵ�,����nextָ���½ڵ�
	}
	
	/**
	 * ������ָ��λ�ò���ڵ�
	 * @param index ���������λ��,��1��ʼ
	 * @param obj �����Ԫ��
	 */
	public void insertNodeByIndex(int index, Object obj){
		Node<Object> node = new Node<Object>(obj);
		//������Ҫ�жϲ����λ���Ƿ�Ϸ�
		if(index < 1 || index > length()){
			System.out.println("����λ�ò��Ϸ�");
			return ;
		}
		int length = 1;//��¼���Ǳ������ڼ����ڵ���
		Node temp = head;//���ƶ���ָ��
		while(temp.next != null){
			if(index == length++){
				//ע��:temp������ǵ�ǰλ�õ�ǰһ���ڵ�
				//ǰһ���ڵ�        ��ǰ�ڵ�                        ��һ���ڵ�
				//temp     temp.next     temp.next.next
				//�������
				node.next = temp.next;
				temp.next = node;
				return ;
			}
			temp = temp.next;
		}
	}
	/**
	 * ɾ��ָ��λ�õĽڵ�
	 * @param index
	 */
	public void delNodeByIndex(int index){
		//���ж���Ҫɾ����λ���Ƿ�Ϸ�
		if(index < 0 || index > length()){
			System.out.println("ɾ��λ�ò��Ϸ�");
			return ;
		}
		Node temp = head;
		int length = 1;//��¼�������ڼ����ڵ���
		while(temp.next != null){
			if(index == length++){
				//ɾ��Ԫ��
				temp.next = temp.next.next;
				return ;
			}
			temp = temp.next;
		}
	}
	
	/**
	 * ��������ĳ���,Ҳ���ǽڵ�ĸ���
	 * @return
	 */
	public int length(){
		int length = 0;
		Node temp = head;
		while(temp.next != null){
			length++;
			temp = temp.next;
		}
		return length;
	}
	
	/**
	 * ��������
	 */
	public void traverse(){
		Node temp = head.next;
        while(temp != null){
            System.out.print(temp.data+"\t");
            temp = temp.next;
        }
        System.out.println();
	}
	
	public static void main(String[] args) {
		LinkList t = new LinkList();
		Person p1 = new Person("lisi", 47);
		Person p2 = new Person("wangwu", 23);
		t.addNode(p1);
		t.addNode(p2);
		Person p3 = new Person("zhaoliu", 22);
		t.insertNodeByIndex(2, p3);
		Person p4 = new Person("jack", 18);
		Person p5 = new Person("rose", 25);
		t.addNode(p4);
		t.addNode(p5);
		System.out.println(t.length());
		t.delNodeByIndex(3);
		t.traverse();
	}
	
}
