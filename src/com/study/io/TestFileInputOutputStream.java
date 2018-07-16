package com.study.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * 1.流的分类
 * 按照数据流向不同:输入流    输出流
 * 按照处理数据单位的不同:字节流   字符流(处理的文本文件)
 * 按照角色的不同:节点流(直接作用于文件的)  处理流
 * 2.IO的体系
 * 抽象基类                                                    节点流(文件流)            缓冲流(处理流的一种)
 * InputStream            FileInputStream       BufferedInputStream
 * OutputStream           FileOutputStream      BufferedOutputStream
 * Reader                 FileReader            BufferedReader
 * Writer                 FileWriter            BufferedWriter
 */
public class TestFileInputOutputStream {

	/*
	 * 从硬盘存在的一个文件中,读取其内容到程序中.使用FileInputStream
	 * 使用try-catch处理异常更加合理:保证流的关闭一定可以执行 
	 */
	@Test
	public void testFileInputStream1(){
		FileInputStream fis = null;
		try {
			//1.创建一个File类的对象
			File file = new File("hello.txt");
			//2.创建一个FileInputStream类的对象
			fis = new FileInputStream(file);
			//read()读取文件的一个字节
			int a = fis.read();
			while(a != -1){
				System.out.print((char)a);
				a = fis.read();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	
	@Test
	public void testFileInputStream2(){
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[5];//读取到的数据要写入的数组
			int len;//每次读入到byte中的字节长度
			while((len = fis.read(b)) != -1){
//				for(int i = 0;i < len;i++){
//					System.out.print((char)b[i]);
//				}
				String s = new String(b, 0, len);
				System.out.print(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testFileOutputStream(){
		File file = new File("hello2.txt");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			fos.write(new String("i love China").getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testFileInputOutputStream(){
		File file1 = new File("hello.txt");
		File file2 = new File("hello3.txt");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			byte[] b = new byte[5];
			int len;
			while((len = fis.read(b)) != -1){
				fos.write(b, 0, len);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fis != null){
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
