package com.study.fanshe;

@MyAnnotation(value = "cccc")
public class Person extends Creature<String> implements Comparable,MyInterface {

	public String name;
	public int age;
	public Person() {
		super();
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	private Person(String name,int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("hi ���ǹ�����");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@MyAnnotation(value = "haha")
	public void show(){
		System.out.println("����һ����");
	}
	private void display(String nation) throws Exception{
		System.out.println("�ҵĹ�����:"+nation);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void sayHello(){
		System.out.println("hello");
	}
	
	class Bird{
		
	}
	
}
