package com.study.string;


import org.junit.Test;

public class TestStringBuffer {

	/*
	 * StringBuffer常用方法:
	 * 添加:append()  删除:delete(int start, int end)  修改:setCharAt(int index, char ch)
	 * 查charAt(index) 插入:insert(int index, String str) 反转:reverse() 长度:length()
	 * 
	 * StringBuilder是线程不安全的,但效率要高于StringBuffer
	 */
	@Test
	public void testStringBuffer(){
		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		System.out.println(sb);
		System.out.println(sb.charAt(0));
	}
	
}
