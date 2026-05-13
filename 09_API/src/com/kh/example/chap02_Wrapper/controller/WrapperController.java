package com.kh.example.chap02_Wrapper.controller;

public class WrapperController {
	public void method() {
		int num1 = 10;
		Integer integer1 = new Integer(num1); // 기본 자료형 -> 객체 : boxing
		int num2 = integer1.intValue(); //객체 -> 기본 자료형 : unBoxing
		
		// jdk 1.5, auto boxing/auto unBoxing
		Integer integer2 = num1; // auto boxing
		int num3 = integer2; // auto unBoxing
	}

}
