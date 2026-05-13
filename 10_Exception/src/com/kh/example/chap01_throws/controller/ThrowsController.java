package com.kh.example.chap01_throws.controller;

public class ThrowsController {
	public void method1() {
		System.out.println("method1() 호출됨...");
		method2();
		System.out.println("method1() 종료됨...");
	}
	
	public void method2() {
		System.out.println("method2() 호출됨...");
		try {
			method3();
			System.out.println("나는 출력될까 안될까?");
		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("------ Exception catch! -------------");
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			System.out.println("예외 발생 여부와 상관 없이 무조건 수행...");
		}
		System.out.println("method2() 종료됨...");
	}
	
	public void method3() throws Exception {
		System.out.println("method3() 호출됨...");
		throw new Exception("throws와 try-catch연습을 위해 예외 강제 발생");
//		System.out.println("method3() 종료됨...");
	}

}
