package com.study.io;

import java.io.File;

import org.junit.Test;

/*
 * java.io.File��
 * 1.���������������ص���,�ӿڵȶ�������java.io����
 * 2.File��һ����,�����й��������������.�˶����Ӧ��һ���ļ�(.txt  .avi  .doc  .ppt  .mp3)���ļ�Ŀ¼
 * 3.File���������ƽ̨�޹ص�
 * 4.File�еķ���,���漰����δ���,ɾ��,�������ȵ�.ֻҪ�漰�ļ����ݵ�,File������Ϊ����,������io�������
 * 5.File��Ķ�����Ϊio���ľ�����Ĺ��������β�
 */
public class TestFile {
	
	/*
	 * ·��:
	 * ����·��:�����̷����ڵ��������ļ�·��
	 * ���·��:�ڵ�ǰ�ļ�Ŀ¼�µ��ļ���·��
	 */
	@Test
	public void test1(){
		File file1 = new File("D:\\test\\hello.txt");
		File file2 = new File("hello2.txt");
		File file3 = new File("D:\\test\\io");
		File file4 = new File("D:\\test\\kk.txt");
		System.out.println(file1.getName());
		System.out.println(file1.getPath());
		//getAbsoluteFile()���ص���һ��File��������File�����ʾ�ǵ�ǰFile����ľ���·������ʽ
		System.out.println(file1.getAbsoluteFile());
		//getAbsolutePath()���ص���һ���ַ���������ַ������ǵ�ǰFile����ľ���·�������ַ�����ʽ
		System.out.println(file1.getAbsolutePath());
		//��ȡ�ļ���Ŀ¼
		System.out.println(file1.getParent());
		System.out.println("--------------------");
		System.out.println(file3.getName());
		System.out.println(file3.getPath());
		System.out.println(file3.getAbsoluteFile());
		System.out.println(file3.getAbsolutePath());
		System.out.println(file3.getParent());
		//������
		boolean f = file1.renameTo(file4);
		System.out.println(f);
	}
	
}
