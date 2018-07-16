package com.study.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * 使用FileReader,FileWriter可以实现文本文件的复制
 * 对于非文本文件(视频文件,音频文件,图片),只能使用字节流
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
