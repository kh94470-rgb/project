package com.kh.example.run;

import com.kh.example.chap01_String.controller.StringController;
import com.kh.example.chap03_Date.controller.DateController;

public class Run {
	public static void main(String[] args) {
		StringController sc = new StringController();
//		sc.method1();
//		sc.mehtod2();
//		sc.method3();
		
		DateController dc = new DateController();
		dc.method1();
//		dc.method2();
	}

}
