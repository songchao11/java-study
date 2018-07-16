package com.study.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/*
 * 与时间相关的类:
 * 1.System类下的currentTimeMillis()
 * 2.Date类:java.util.Date以及其子类java.sql.Date
 * 3.SimpleDateFormat类
 * 4.Calendar类
 */
public class TestDate {

	@Test
	public void test1(){
		Date date1 = new Date();
		System.out.println(date1.toString());
	}
	
	@Test
	public void test2() throws ParseException{
		//格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date());
		System.out.println(time);
		//解析
		Date date1 = sdf.parse("2018-2-26 13:23:25");
		System.out.println(date1);
	}
	
	@Test
	public void test3(){
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(day);
		System.out.println(c.getTime());
	}
	
}
