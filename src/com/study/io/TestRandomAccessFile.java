package com.study.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/*
 * RandomAccessFile:支持随机访问
 * 1.既可以充当一个输入流,又可以充当一个输出流
 * 2.支持从文件的开头读取,写入
 * 3.支持从任意位置的读取,写入
 */
public class TestRandomAccessFile {
	
	@Test
	public void test1(){
		RandomAccessFile raf1 = null;//读取文件随机流
		RandomAccessFile raf2 = null;//写入文件随机流
		try {
			raf1 = new RandomAccessFile(new File("hi.txt"), "r");
			raf2 = new RandomAccessFile(new File("hi2.txt"), "rw");
			byte[] b = new byte[20];
			int len;
			while((len = raf1.read(b)) != -1){
				raf2.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(raf1 != null){
				try {
					raf1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(raf2 != null){
				try {
					raf2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
