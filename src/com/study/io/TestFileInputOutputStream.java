package com.study.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/*
 * 1.���ķ���
 * ������������ͬ:������    �����
 * ���մ������ݵ�λ�Ĳ�ͬ:�ֽ���   �ַ���(������ı��ļ�)
 * ���ս�ɫ�Ĳ�ͬ:�ڵ���(ֱ���������ļ���)  ������
 * 2.IO����ϵ
 * �������                                                    �ڵ���(�ļ���)            ������(��������һ��)
 * InputStream            FileInputStream       BufferedInputStream
 * OutputStream           FileOutputStream      BufferedOutputStream
 * Reader                 FileReader            BufferedReader
 * Writer                 FileWriter            BufferedWriter
 */
public class TestFileInputOutputStream {

	/*
	 * ��Ӳ�̴��ڵ�һ���ļ���,��ȡ�����ݵ�������.ʹ��FileInputStream
	 * ʹ��try-catch�����쳣���Ӻ���:��֤���Ĺر�һ������ִ�� 
	 */
	@Test
	public void testFileInputStream1(){
		FileInputStream fis = null;
		try {
			//1.����һ��File��Ķ���
			File file = new File("hello.txt");
			//2.����һ��FileInputStream��Ķ���
			fis = new FileInputStream(file);
			//read()��ȡ�ļ���һ���ֽ�
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
			byte[] b = new byte[5];//��ȡ��������Ҫд�������
			int len;//ÿ�ζ��뵽byte�е��ֽڳ���
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
