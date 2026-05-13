package com.kh.example.chap06_method.controller;

import java.util.Arrays;

import com.kh.example.chap05.constructor.model.vo.User;

public class MethodPractice {
	// 1. 매개변수 없고 반환 값 없는 메소드
	public void method1() {
		// 반환값x      매개변수x
		System.out.println("매개변수와 반환 값 둘 다 없는 메소드입니다.");
	}
	
	// 2. 매개변수 없고 반환 값 있는 메소드
	public int method2() {
		//return 0; // return에 리터럴 값 삽입
		int a = 10;
		int b = 20;
		int c = a + b;
		return c; // return에 변수 삽입
	}
	
	// 3. 매개변수 있고 반환 값 없는 메소드
	public void method3(double num, char ch) {
		System.out.println("실수 " + num + ", 문자 " + ch);
	}
	
	// 4. 매개변수 있고 반환 값 있는 메소드
	public boolean method4(int num1, double num2) {
		return num1 + num2 > 0;
	}
	
	// 심화 1. 매개변수로 주소 값 전달(배열)
	public void method5(double[] dArr) {
		System.out.println("MP dArr : " + Arrays.toString(dArr));
		System.out.println("Mp dArr : " + dArr);
		dArr[0] = 99.9;
		System.out.println("MP dArr : " + Arrays.toString(dArr));
	}
	
	// 심화 2. 리턴으로 주소 값 반환(클래스 = 객체)
	public User method6() {
		User u = new User();
		System.out.println("MP u : " + u);
		return u;
		
	}
	
	
	
	
	
	
	
	
	

}
