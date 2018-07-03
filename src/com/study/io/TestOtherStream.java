package com.study.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.Test;

/*
 * 如何实现字节流与字符流之间的转换:
 * 转换流: InputStreamReader  OutputStreamWriter
 * 编码: 字符串 ->字节数组
 * 解码:字节数组 ->字符串
 */
public class TestOtherStream {

	@Test
	public void test(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File file1 = new File("ok.txt");
			//解码
			FileInputStream fis = new FileInputStream(file1);
			InputStreamReader isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String str;
			//编码
			File file2 = new File("okok.txt");
			FileOutputStream fos = new FileOutputStream(file2);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			while((str = br.readLine()) != null){
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
