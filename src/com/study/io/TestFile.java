package com.study.io;

import java.io.File;

import org.junit.Test;

/*
 * java.io.File类
 * 1.凡是与输入输出相关的类,接口等都定义在java.io包下
 * 2.File是一个类,可以有构造器创建其对象.此对象对应着一个文件(.txt  .avi  .doc  .ppt  .mp3)或文件目录
 * 3.File类对象是与平台无关的
 * 4.File中的方法,仅涉及到如何创建,删除,重命名等等.只要涉及文件内容的,File是无能为力的,必须由io流来完成
 * 5.File类的对象常作为io流的具体类的构造器的形参
 */
public class TestFile {
	
	/*
	 * 路径:
	 * 绝对路径:包括盘符在内的完整的文件路径
	 * 相对路径:在当前文件目录下的文件的路径
	 */
	@Test
	public void test1(){
		File file1 = new File("D:\\test\\hello.txt");
		File file2 = new File("hello2.txt");
		File file3 = new File("D:\\test\\io");
		File file4 = new File("D:\\test\\kk.txt");
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		//getAbsoluteFile()返回的是一个File类对象，这个File对象表示是当前File对象的绝对路径名形式
		System.out.println(file1.getAbsoluteFile());
		//getAbsolutePath()返回的是一个字符串，这个字符串就是当前File对象的绝对路径名的字符串形式
		System.out.println(file1.getAbsolutePath());
		//获取文件父目录
		System.out.println(file1.getParent());
		System.out.println("--------------------");
		System.out.println(file3.getName());
		System.out.println(file3.getPath());
		System.out.println(file3.getAbsoluteFile());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file3.getParent());
		//重命名
		boolean f = file1.renameTo(file4);
		System.out.println(f);
	}
	
}
