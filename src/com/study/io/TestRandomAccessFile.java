package com.study.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import org.junit.Test;

/*
 * RandomAccessFile:֧���������
 * 1.�ȿ��Գ䵱һ��������,�ֿ��Գ䵱һ�������
 * 2.֧�ִ��ļ��Ŀ�ͷ��ȡ,д��
 * 3.֧�ִ�����λ�õĶ�ȡ,д��
 */
public class TestRandomAccessFile {
	
	@Test
	public void test1(){
		RandomAccessFile raf1 = null;//��ȡ�ļ������
		RandomAccessFile raf2 = null;//д���ļ������
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
