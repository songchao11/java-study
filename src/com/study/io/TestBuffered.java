package com.study.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/*
 * 抽象基类                                                    节点流(文件流)            缓冲流(处理流的一种)
 * InputStream            FileInputStream       BufferedInputStream
 * OutputStream           FileOutputStream      BufferedOutputStream
 * Reader                 FileReader            BufferedReader
 * Writer                 FileWriter            BufferedWriter
 */
public class TestBuffered {

	@Test
	public void testBufferedInputOutputStream(){
		File file1 = new File("jihelei.jpg");
		File file2 = new File("jihelei2.jpg");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			byte[] b = new byte[1024];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bos != null){
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Test
	public void testBufferedReaderWriter(){
		File file1 = new File("ok.txt");
		File file2 = new File("kk.txt");
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			FileReader fr = new FileReader(file1);
			FileWriter fw = new FileWriter(file2);
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			String s;
			while((s = br.readLine()) != null){
				bw.write(s);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
}
