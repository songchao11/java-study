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
 * ���ʵ���ֽ������ַ���֮���ת��:
 * ת����: InputStreamReader  OutputStreamWriter
 * ����: �ַ��� ->�ֽ�����
 * ����:�ֽ����� ->�ַ���
 */
public class TestOtherStream {

	@Test
	public void test(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			File file1 = new File("ok.txt");
			//����
			FileInputStream fis = new FileInputStream(file1);
			InputStreamReader isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String str;
			//����
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
