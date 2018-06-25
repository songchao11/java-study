package com.study.linkedlist;

public class LinkList {

	Node<Person> head = new Node<Person>();
	
	/**
	 * 增加操作
	 * 直接在链表的最后插入新增的节点即可,并将原本最后一个节点的next指向新节点
	 * @param node
	 */
	public void addNode(Object obj){
		Node<Object> node = new Node<Object>(obj);
		//链表中有节点,遍历到最后一个节点
		//一个移动的指针(把头结点看做一个指向节点的指针)
		Node temp = head;
		while(temp.next != null){//遍历单链表,直到遍历到最后一个就跳出循环
			temp = temp.next;//往后移一个节点,指向下一个节点
		}
		temp.next = node;//temp为最后一个节点或者头节点,将其next指向新节点
	}
	
	/**
	 * 在链表指定位置插入节点
	 * @param index 插入链表的位置,从1开始
	 * @param obj 插入的元素
	 */
	public void insertNodeByIndex(int index, Object obj){
		Node<Object> node = new Node<Object>(obj);
		//首先需要判断插入的位置是否合法
		if(index < 1 || index > length()){
			System.out.println("插入位置不合法");
			return ;
		}
		int length = 1;//记录我们遍历到第几个节点了
		Node temp = head;//可移动的指针
		while(temp.next != null){
			if(index == length++){
				//注意:temp代表的是当前位置的前一个节点
				//前一个节点        当前节点                        后一个节点
				//temp     temp.next     temp.next.next
				//插入操作
				node.next = temp.next;
				temp.next = node;
				return ;
			}
			temp = temp.next;
		}
	}
	/**
	 * 删除指定位置的节点
	 * @param index
	 */
	public void delNodeByIndex(int index){
		//先判断需要删除的位置是否合法
		if(index < 0 || index > length()){
			System.out.println("删除位置不合法");
			return ;
		}
		Node temp = head;
		int length = 1;//记录遍历到第几个节点了
		while(temp.next != null){
			if(index == length++){
				//删除元素
				temp.next = temp.next.next;
				return ;
			}
			temp = temp.next;
		}
	}
	
	/**
	 * 计算链表的长度,也就是节点的个数
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
	 * 遍历链表
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
