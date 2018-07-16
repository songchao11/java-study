package com.study.string;

import org.junit.Test;

public class TestString {

	/*
	 * int length(): �ַ�������
	 * char charAt(int index): ����ָ��indexλ�õ��ַ�,index��0��ʼ
	 * boolean equals(Object anotherObj): �Ƚ������ַ����Ƿ����
	 * int compareTo(String anotherString): �Ƚ������ַ���
	 * int indexOf(String s): ����s�ַ����ڵ�ǰ�ַ������״γ��ֵ�λ��,��û���򷵻�-1 
	 * int indexOf(String s, int startPoint): ��startPointλ�ÿ�ʼ,����s�ַ����ڵ�ǰ�ַ������״γ��ֵ�λ��,��û���򷵻�-1 
	 * int lastIndexOf(String s): ����s�ַ������һ���ڵ�ǰ�ַ����г��ֵ�λ��,��û���򷵻�-1
	 * int lastIndexOf(String s, int startPoint):
	 * boolean startWith(String prefix): �жϵ�ǰ�ַ����Ƿ���prefix��ʼ
	 * boolean endWith(String prefix): �жϵ�ǰ�ַ����Ƿ���prefix����
	 * boolean regionMatches(int toffset, String other, int ooffset, int len): 
	 * �жϵ�ǰ�ַ�����toffset��ʼ���Ӵ�����һ���ַ���other��ooffset��ʼ,len���ȵ��Ӵ��Ƿ�equals
	 */
	@Test
	public void test(){
		String a = "eevbcabvdbviabvnidnabjasojab";
		System.out.println(a.indexOf("ab", 27));
	}
	
	@Test
	public void test1(){
		String str1 = "abcdefghmf";
		String str2 = "ghm";
		String str3 = "hmf";
		
		System.out.println(str1.length());
		System.out.println(str1.charAt(2));
		System.out.println(str2.compareTo(str1));
		System.out.println(str1.indexOf("f", 2));
		System.out.println(str1.lastIndexOf("f"));
		System.out.println(str1.startsWith("absc"));
		System.out.println(str1.regionMatches(7, str3, 0, str3.length()));
	}
	
	/*
	 * String substring(int startpoint): ���ش�startpointλ�ÿ�ʼ���������ַ���
	 * String substring(int start, int end): ���ش�start��ʼ��end������һ������ҿ����ַ���
	 * String replace(String old, String new): ���ַ����е�old�ַ���ת����new
	 * String trim(): ȥ���ַ������˵Ŀո�
	 * String concat(String str): ���ӵ�ǰ�ַ�����str
	 * String[] split(String regex): ����regex����ǰ�ַ�����ֳɶ���ַ������ɵ�����
	 */
	@Test
	public void test2(){
		String s1 = "���ݻ�վ";
		String s2 = "����һͷСë¿";
		String str = "  abc  dfg  ";
		String s = "kfas-vnbisan-vsava-aaa-vasv";
		String s3 = s1.substring(2);
		String s4 = s1.substring(0, 2);
		String s5 = s1.replace("����", "�Ͼ�");
		String s6 = str.trim();
		String s7 = s1.concat(s2);
		String[] strs = s.split("-");
		
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(s5);
		System.out.println(s6);
		System.out.println(s7);
		System.out.println("-----------");
		for(String i : strs){
			System.out.println(i);
		}
	}
	
	/*
	 * 1.�ַ����������������,��װ��֮���ת��
	 * ���ַ���-->������������,��װ��:������Ӧ�İ�װ���parseXxx(String str)
	 * �ڻ�����������,��װ��-->�ַ���:�����ַ������ص�valueOf()����
	 * 
	 * 2.�ַ������ֽ�����֮���ת��
	 * ���ַ���-->�ֽ�����:�����ַ�����getBytes()����
	 * ���ֽ�����-->�ַ���:�����ַ����Ĺ�����
	 * 
	 * 3.�ַ������ַ�����֮���ת��
	 * ���ַ���-->�ַ�����:�����ַ�����toCharArray()
	 * ���ַ�����-->�ַ���:�����ַ����Ĺ�����
	 */
	@Test
	public void test3(){
		//1.�ַ����������������,��װ��֮���ת��
		String s1 = "123";
		int b = 456;
		int a = Integer.parseInt(s1);
		String s2 = String.valueOf(b);
		System.out.println(a);
		System.out.println(s2);
		//2.�ַ������ֽ�����֮���ת��
		String s3 = "ahdsalj";
		byte[] bytes = s3.getBytes();
		for(int i = 0;i < bytes.length;i++){
			System.out.print((char)bytes[i]+" ");
		}
		String s4 = new String(bytes);
		System.out.println(s4);
		//3.�ַ������ַ�����֮���ת��
		String s5 = "vsia���Ǻ�";
		char[] c = s5.toCharArray();
		for(int i = 0;i < c.length;i++){
			System.out.print(c[i]+" ");
		}
		String s6 = new String(c);
		System.out.println(s6);
	}
	
	
}
