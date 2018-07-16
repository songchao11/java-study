package com.study.string;

import org.junit.Test;

public class TestString {

	/*
	 * int length(): 字符串长度
	 * char charAt(int index): 返回指定index位置的字符,index从0开始
	 * boolean equals(Object anotherObj): 比较两个字符串是否相等
	 * int compareTo(String anotherString): 比较两个字符串
	 * int indexOf(String s): 返回s字符串在当前字符串中首次出现的位置,若没有则返回-1 
	 * int indexOf(String s, int startPoint): 从startPoint位置开始,返回s字符串在当前字符串中首次出现的位置,若没有则返回-1 
	 * int lastIndexOf(String s): 返回s字符串最后一次在当前字符串中出现的位置,若没有则返回-1
	 * int lastIndexOf(String s, int startPoint):
	 * boolean startWith(String prefix): 判断当前字符串是否以prefix开始
	 * boolean endWith(String prefix): 判断当前字符串是否以prefix结束
	 * boolean regionMatches(int toffset, String other, int ooffset, int len): 
	 * 判断当前字符串从toffset开始的子串与另一个字符串other从ooffset开始,len长度的子串是否equals
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
	 * String substring(int startpoint): 返回从startpoint位置开始至结束的字符串
	 * String substring(int start, int end): 返回从start开始到end结束的一个左闭右开的字符串
	 * String replace(String old, String new): 将字符串中的old字符串转换成new
	 * String trim(): 去除字符串两端的空格
	 * String concat(String str): 连接当前字符串与str
	 * String[] split(String regex): 按照regex将当前字符串拆分成多个字符串构成的数组
	 */
	@Test
	public void test2(){
		String s1 = "杭州火车站";
		String s2 = "我有一头小毛驴";
		String str = "  abc  dfg  ";
		String s = "kfas-vnbisan-vsava-aaa-vasv";
		String s3 = s1.substring(2);
		String s4 = s1.substring(0, 2);
		String s5 = s1.replace("杭州", "南京");
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
	 * 1.字符串与基本数据类型,包装类之间的转换
	 * ①字符串-->基本数据类型,包装类:调用相应的包装类的parseXxx(String str)
	 * ②基本数据类型,包装类-->字符串:调用字符串重载的valueOf()方法
	 * 
	 * 2.字符串与字节数组之间的转换
	 * ①字符串-->字节数组:调用字符串的getBytes()方法
	 * ②字节数组-->字符串:调用字符串的构造器
	 * 
	 * 3.字符串与字符数组之间的转换
	 * ①字符串-->字符数组:调用字符串的toCharArray()
	 * ②字符数组-->字符串:调用字符串的构造器
	 */
	@Test
	public void test3(){
		//1.字符串与基本数据类型,包装类之间的转换
		String s1 = "123";
		int b = 456;
		int a = Integer.parseInt(s1);
		String s2 = String.valueOf(b);
		System.out.println(a);
		System.out.println(s2);
		//2.字符串与字节数组之间的转换
		String s3 = "ahdsalj";
		byte[] bytes = s3.getBytes();
		for(int i = 0;i < bytes.length;i++){
			System.out.print((char)bytes[i]+" ");
		}
		String s4 = new String(bytes);
		System.out.println(s4);
		//3.字符串与字符数组之间的转换
		String s5 = "vsia哈呵呵";
		char[] c = s5.toCharArray();
		for(int i = 0;i < c.length;i++){
			System.out.print(c[i]+" ");
		}
		String s6 = new String(c);
		System.out.println(s6);
	}
	
	
}
