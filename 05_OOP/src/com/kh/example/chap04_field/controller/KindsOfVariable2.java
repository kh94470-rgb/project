package com.kh.example.chap04_field.controller;

public class KindsOfVariable2 {
	public static int staticNum; 
	// static변수 = 클래스 변수 : static이 붙은 변수 
	
	// 인스턴스 변수 : static이 붙지 않은 변수
	private int testNum = 10;
	private static int staticTestNum = 10;
	
	public void test() {
		testNum++;
		System.out.println("testNum : " + testNum);
		staticTestNum++;
		System.out.println("staticTestNum : " + staticTestNum);
	}

}
