package com.study.array;

public class TestException {
	
	public static void main(String[] args) {
		//1.数组下标越界的异常java.lang.ArrayIndexOutOfBoundsException
//		int[] a = new int[4];
//		a[0] = 1;
//		for(int i = 0;i <= a.length;i++){
//			System.out.println(a[i]);
//		}
		
		//2.空指针异常 NullPointerException
		//第一种
//		int[] b = new int[3];
//		b[0] = 3;
//		b = null;
//		System.out.println(b[0]);
		//第二种
//		String[] strs = new String[3];
//		System.out.println(strs[0].toString());
		//第三种
		String[][] c = new String[3][];
		c[0][0] = "A";
		System.out.println(c[0][0]);
		
	}

}
