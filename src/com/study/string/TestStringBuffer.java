package com.study.string;


import org.junit.Test;

public class TestStringBuffer {

	/*
	 * StringBuffer���÷���:
	 * ���:append()  ɾ��:delete(int start, int end)  �޸�:setCharAt(int index, char ch)
	 * ��charAt(index) ����:insert(int index, String str) ��ת:reverse() ����:length()
	 * 
	 * StringBuilder���̲߳���ȫ��,��Ч��Ҫ����StringBuffer
	 */
	@Test
	public void testStringBuffer(){
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		System.out.println(sb);
		System.out.println(sb.charAt(0));
	}
	
}
