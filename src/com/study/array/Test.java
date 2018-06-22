package com.study.array;

public class Test {
	
	public static void main(String[] args) {
		int[] arrs = new int[]{3,7,-98,99,5,1,33};
		System.out.println("����ǰ:");
		for(int a : arrs){
			System.out.print(a+" ");
		}
		quickSort(arrs, 0, arrs.length-1);
		System.out.println("�����:");
		for(int k : arrs){
			System.out.print(k+" ");
		}
		int[] as = new int[]{2,4,8,9,11,33,99};
		System.out.println("----------");
		System.out.println(binarySearch(as, 2));
	}

	public static void quickSort(int[] arrs, int low, int high){
		int i,j,t,temp;
		if(low > high){
			return ;
		}
		i = low;
		j = high;
		temp = arrs[low];
		while(i < j){
			//�ȴ��������ұ�tempС����
			while(i < j && arrs[j] >= temp){
				j--;
			}
			//���������ұ�temp�����
			while(i < j && arrs[i] <= temp){
				i++;
			}
			//������������λ��
			if(i < j){
				t = arrs[i];
				arrs[i] = arrs[j];
				arrs[j] = t;
			}
		}
		//����׼����λ
		arrs[low] = arrs[i];
		arrs[i] = temp;
		//�ݹ鴦���׼����ߵ�
		quickSort(arrs, low, i-1);
		//�ݹ鴦���׼���ұߵ�
		quickSort(arrs, i+1, high);
	}
	public static int binarySearch(int[] arrs, int target){
		int low = 0;
		int high = arrs.length-1;
		while(low <= high){
			int middle = (low + high)/2;
			if(target == arrs[middle]){
				return middle;
			}else if(target < arrs[middle]){
				high = middle - 1;
			}else{
				low = middle + 1;
			}
		}
		return 0;
	}
}
