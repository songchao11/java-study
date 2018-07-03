package com.study.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectInputOutputStream {
	
	/*
	 * 对象的序列化过程:将内存中的对象通过ObjectOutputStream转化为二进制流,存储在磁盘文件中
	 */
	@Test
	public void testObjectOutptStream(){
		Person p1 = new Person("张三", 21);
		Person p2 = new Person("李四", 25);
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
			oos.writeObject(p1);
			oos.flush();
			oos.writeObject(p2);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(oos != null){
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testObjectInputStream(){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("person.txt"));
			Person p1 = (Person)ois.readObject();
			System.out.println(p1);
			Person p2 = (Person)ois.readObject();
			System.out.println(p1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ois != null){
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

}

/*
 * 要实现序列化的类:
 * 1.要求此类是可序列化的,实现Serializable接口
 * 2.要求此类的属性同样要实现Serializable接口
 * 3.提供一个版本号serialVersionUID
 * 4.使用static或transient修饰的属性不可实现序列化
 */
class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}