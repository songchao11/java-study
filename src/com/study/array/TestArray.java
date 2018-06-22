package com.study.array;

import java.util.Arrays;

public class TestArray {

	/**
	 * 1.������Ԫ�ص����ֵ,��Сֵ,ƽ����,�ܺ�
	 * 
	 * 2.����ĸ���,��ת
	 * 
	 * 3.����Ԫ�ص�����
	 */
	public static void main(String[] args) {
		int[] arrs = new int[]{66,46,53,22,78,-31,5};
		
		//����ķ�ת
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
		
		
		System.out.print("����ǰ:");
		for(int a : arrs){
			System.out.print(a+" ");
		}
		System.out.println();
		
//		bubbleSort(arrs);
//		straightSelectionSort(arrs);
		quickSort(arrs, 0, arrs.length-1);
		System.out.print("�����:");
		for(int a : arrs){
			System.out.print(a+" ");
		}
		
	}
	/**
	 * ð������
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
	 * ֱ��ѡ������
	 * ��һ��:��a[0]-a[N-1]��ѡ����С������,Ȼ����a[0]������
	 * �ڶ���:��a[1]-a[N-1]��ѡ����С������,Ȼ����a[1]������
	 * �Դ�����.....
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
	 * ��������
	 */
	public static void quickSort(int[] arrs, int left, int right){
		int i,j,t,temp;
		if(left > right){
			return ;
		}
		temp = arrs[left];//temp ��Ż�׼��
		i = left;
		j = right;
		while(i != j){
			//˳�����Ҫ,Ҫ���ұ�����ʼ�ұ�tempС��
			while(arrs[j] >= temp && i < j){
				j--;
			}
			//���������ұ�temp���
			while(arrs[i] <= temp && i < j){
				i++;
			}
			//�����������������е�λ��
			if(i < j){
				t = arrs[i];
				arrs[i] = arrs[j];
				arrs[j] = t;
			}
		}
		//����׼����λ
		arrs[left] = arrs[i];
		arrs[i] = temp;
		//����������ߵ�,����һ���ݹ�Ĺ���
		quickSort(arrs, left, i-1);
		//���������ұߵ�
		quickSort(arrs, i+1, right);
	}
	
	
	
}
