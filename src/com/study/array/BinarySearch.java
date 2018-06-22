package com.study.array;

public class BinarySearch {

	/**
	 * 二分查找
	 * 数组必须是顺序的
	 */
	public static int binary(int[] arrs, int des){
		//定义最小最大的索引
		int low = 0;
		int high = arrs.length - 1;
		while(low <= high){
			int middle = (low + high)/2;
			if(des == arrs[middle]){
				return middle;
			} else if(des > arrs[middle]){
				low = middle + 1;
			}else{
				high = middle - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		int[] arrs = new int[]{2,5,6,8,9,11,95,102};
//		int result = binary(arrs, 95);
//		System.out.println(result);
		String str1 = "AA";
		String str2 = "AA";
		String str3 = new String("AA");
		System.out.println(str1 == str2);//true
		System.out.println(str1.equals(str2));//true
		System.out.println(str1 == str3);//false
		System.out.println(str1.equals(str3));//true
	}
	
}
