package com.study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01 {
	public static void main(String[] args) {
		//���ʽ����
		Pattern p = Pattern.compile("\\w+");
		//����Matcher����
		Matcher m = p.matcher("vaos6115vsav541");
		System.out.println(m.matches());
	}
}
