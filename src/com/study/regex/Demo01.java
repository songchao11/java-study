package com.study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {
	public static void main(String[] args) {
		//表达式对象
		Pattern p = Pattern.compile("\\w+");
		//创建Matcher对象
		Matcher m = p.matcher("vaos6115vsav541");
		System.out.println(m.matches());
	}
}
