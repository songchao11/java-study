package com.study.string;

import java.util.ArrayList;
import java.util.List;

public class StringDemo {

	public static void main(String[] args) {
		String str = "   sbbva ����˭        ";
		String str1 = "     ";
		System.out.println(StringDemo.myTrim(str));
		System.out.println("-----------");
		String str2 = "abcdefg";
		System.out.println(StringDemo.reverseString(str2, 2, 5));
		System.out.println("====================");
		String str3 = "gfabcsnvabklkkfabnababaaa";
		System.out.println(StringDemo.getTime(str3, "ab"));
		System.out.println(StringDemo.getMaxMaxSubString("acsasongcabbhellojiijlocsncn", "asbvibbashelloviasbnvsongc"));
	}
	
	/*
	 * ȥ���ַ������˵Ŀո�
	 */
	public static String myTrim(String str){
		
		//1.���ȶ����ַ�����ͷβλ��
		int start = 0;
		int end = str.length() - 1;
		while(start < end && str.charAt(start) == ' '){
			start++;
		}
		while(start < end && str.charAt(end) == ' '){
			end--;
		}
		return str.substring(start, end + 1);
	}
	
	/*
	 * �ַ�����ת
	 */
	public static String reverseString(String str, int start, int end){
		char[] c = str.toCharArray();
		return reverseArray(c, start, end);
	}
	
	public static String reverseArray(char[] c, int start, int end){
		for(int i = start,j = end;i < j;i++,j--){
			char temp = c[i];
			c[i] = c[j];
			c[j] = temp;
		}
		return new String(c);
	}
	
	//��ȡһ���ַ�������һ���ַ����г��ֵĴ���(str2��str1�г��ֵĴ���)
	public static int getTime(String str1, String str2){
		int count = 0;
		int len = str2.length();
		int index = str1.indexOf(str2, 0);
		while(index != -1){
			count++;
			index = str1.indexOf(str2, index+len);
		}
		return count;
	}
	
	//��ȡ�����ַ����������ͬ�Ӵ�acsaabbsvnojkkhellocsncn   bvabbhellojiiji
	public static List<String> getMaxMaxSubString(String str1, String str2){
		List<String> list = new ArrayList<String>();
		String maxStr = (str1.length() > str2.length()) ? str1 : str2;
		String minStr = (str1.length() < str2.length()) ? str1 : str2;
		int len = minStr.length();
		for(int i = 0;i < len;i++){
			for(int x = 0,y = len-i;y <= len;x++,y++){
				String str = minStr.substring(x, y);
				if(maxStr.contains(str)){
					list.add(str);
				}
			}
			if(list.size() != 0){
				return list;
			}
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
