package com.kh.example.chap03_Date.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateController {
	public void method1() {
		Date today = new Date();
		System.out.println(today); //Fri Feb 06 14:15:09 KST 2026
		System.out.println(today.getTime()); //1770354909073
		
		Date time = new Date(1770354909073L);
		System.out.println(time);
		
		Date date = new Date(2026, 2, 7);
		System.out.println(date);
		
	}
	
	public void method2() {
//		Calendar c = new Calendar();
		Calendar c = Calendar.getInstance();
		System.out.println(c);
		
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc);
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		int amPm = c.get(Calendar.AM_PM);
		System.out.println(amPm); // 오전 0, 오후 1
		String strAmPm = amPm == Calendar.AM ? "오전" : "오후";
		int hour = c.get(Calendar.HOUR);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		int day = c.get(Calendar.DAY_OF_WEEK);
		String result = null;
		switch(day) {
//		case Calendar.MONDAY : result = "월요일"; break;
		case 1 : result = "일요일";
		break;
		case 2 : result = "월요일";
		break;
		case 3 : result = "화요일";
		break;
		case 4 : result = "수요일";
		break;
		case 5 : result = "목요일";
		break;
		case 6 : result = "금요일";
		break;
		default : result = "토요일";
		}
		System.out.printf("%d년 %d월 %d일 %s %s %d시 %d분 %d초", year, month, date, result, strAmPm, hour, min, sec);
		
		System.out.println();
		
		GregorianCalendar endGc = new GregorianCalendar(2026, 6, 10, 17, 50, 0); // 26년 7월 10일 17시 50분 00초
		System.out.println(endGc);
		long milli = endGc.getTimeInMillis();
		Date endDate = new Date(milli);
		System.out.println(endDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초 SSS"); // 대문자 HH는 24시 기준
		String format = sdf.format(endDate);
		System.out.println(format);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
