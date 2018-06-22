package com.study.array;

import java.util.Arrays;

public class TestArray {

	/**
	 * 1.求数组元素的最大值,最小值,平均数,总和
	 * 
	 * 2.数组的复制,反转
	 * 
	 * 3.数组元素的排序
	 */
	public static void main(String[] args) {
		int[] arrs = new int[]{66,46,53,22,78,-31,5};
		
		//数组的反转
//		for(int i = 0;i < arrs.length/2;i++){
//			int temp = arrs[i];
//			arrs[i] = arrs[arrs.length-1-i];
//			arrs[arrs.length-1-i] = temp;
//		}
//		for(int i: arrs){
//			System.out.println(i);
//		}
//		int[] s = new int[7];
//		int[] s = arrs.clone();
//		System.arraycopy(arrs, 0, s, 0, arrs.length);
//		s = Arrays.copyOf(arrs, 7);
//		System.arraycopy(src, srcPos, dest, destPos, length);
//		arrs[0] = 1;
//		arrs[1] = 9;
//		for(int a : s){
//			System.out.println(a);
//		}
		
		
		System.out.print("排序前:");
		for(int a : arrs){
			System.out.print(a+" ");
		}
		System.out.println();
		
//		bubbleSort(arrs);
//		straightSelectionSort(arrs);
		quickSort(arrs, 0, arrs.length-1);
		System.out.print("排序后:");
		for(int a : arrs){
			System.out.print(a+" ");
		}
		
	}
	/**
	 * 冒泡排序
	 */
	public static void bubbleSort(int[] arrs){
		for(int i = 0;i < arrs.length-1;i++){
			for(int j = 0;j < arrs.length-1-i;j++){
				int temp;
				if(arrs[j] > arrs[j+1]){
					temp = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 直接选择排序
	 * 第一次:从a[0]-a[N-1]中选出最小的数据,然后与a[0]做交换
	 * 第二次:从a[1]-a[N-1]中选出最小的数据,然后与a[1]做交换
	 * 以此类推.....
	 */
	public static void straightSelectionSort(int[] arrs){
		for(int i = 0;i < arrs.length-1;i++){
			int minIndex = i;
			for(int j = i;j < arrs.length;j++){
				if(arrs[minIndex] > arrs[j]){
					minIndex = j;
				}
			}
			if(i != minIndex){
				int temp = arrs[minIndex];
				arrs[minIndex] = arrs[i];
				arrs[i] = temp;
			}
		}
	}
	
	/**
	 * 快速排序
	 */
	public static void quickSort(int[] arrs, int left, int right){
		int i,j,t,temp;
		if(left > right){
			return ;
		}
		temp = arrs[left];//temp 存放基准数
		i = left;
		j = right;
		while(i != j){
			//顺序很重要,要从右边往左开始找比temp小的
			while(arrs[j] >= temp && i < j){
				j--;
			}
			//从左往右找比temp大的
			while(arrs[i] <= temp && i < j){
				i++;
			}
			//交换两个数在数组中的位置
			if(i < j){
				t = arrs[i];
				arrs[i] = arrs[j];
				arrs[j] = t;
			}
		}
		//将基准数归位
		arrs[left] = arrs[i];
		arrs[i] = temp;
		//继续处理左边的,这是一个递归的过程
		quickSort(arrs, left, i-1);
		//继续处理右边的
		quickSort(arrs, i+1, right);
	}
	
	
	
}
