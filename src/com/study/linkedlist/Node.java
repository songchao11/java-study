package com.study.linkedlist;

public class Node<T> {

	//Ϊ�˷�������������ʹ��public
	//������ݵı���,��Ū�򵥵�,ֱ�ӽ����Ͷ���Ϊint
	public T data;
	//��Žڵ�ı���,Ĭ��Ϊnull
	public Node<T> next;
	public Node(){
		
	}
	//�ڹ���ʱ���ܸ�data��ֵ
	public Node(T data){
		this.data = data;
	}
	
	
}
