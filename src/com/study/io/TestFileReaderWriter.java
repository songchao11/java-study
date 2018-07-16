package com.study.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * ʹ��FileReader,FileWriter����ʵ���ı��ļ��ĸ���
 * ���ڷ��ı��ļ�(��Ƶ�ļ�,��Ƶ�ļ�,ͼƬ),ֻ��ʹ���ֽ���
 */
public class TestFileReaderWriter {
	
	@Test
	public void testReader(){
		File file = new File("ok.txt");
		FileReader fr = null;
		try{
			fr = new FileReader(file);
			char[] c = new char[20];
			int len;
			while((len = fr.read(c)) != -1){
				String s = new String(c, 0, len);
				System.out.print(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testFileReaderWriter(){
		File file1 = new File("ok.txt");
		File file2 = new File("oo.txt");
		FileReader fr = null;
		FileWriter fw = null;
		try{
			fr = new FileReader(file1);
			fw = new FileWriter(file2);
			char[] c = new char[20];
			int len;
			while((len = fr.read(c)) != -1){
				fw.write(c, 0, len);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fr != null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fw != null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
