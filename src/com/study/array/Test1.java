package com.study.array;

public class Test1 {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		p1.name = "张三";
		p1.age = 21;
		p1.nation = "CN";
		p2.name = "李四";
		p2.age = 23;
//		System.out.println(p1.nation);
//		System.out.println(p2.nation);
		int[][] a = new int[3][3];
		a[0] = new int[]{1,2,3,77};
		a[1] = new int[]{4,5,6,99,88};
		a[2] = new int[]{7,8,9,55,66,44};
//		for(int[] k : a){
//			for(int s : k){
//				System.out.print(s+" ");
//			}
//			System.out.println();
//		}
		System.out.println(a[1][4]);
	}
}
