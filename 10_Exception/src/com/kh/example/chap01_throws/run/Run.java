package com.kh.example.chap01_throws.run;

import com.kh.example.chap01_throws.controller.ThrowsController;

public class Run {
	public static void main(String[] args) {
		ThrowsController tc = new ThrowsController();
		
		tc.method1();
		
		System.out.println("정상적으로 종료됨...");
	}

}
