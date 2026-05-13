package com.kh.example.chap04_field.run;

import com.kh.example.chap04_field.controller.KindsOfVariable2;
import com.kh.example.chap04_field.controller.KindsOfVariable1;

public class Run {
	public static void main(String[] args) {
		KindsOfVariable1 kov1 = new KindsOfVariable1();
//		kov1.method1(10);
//		kov1.method2();
		
		
		// KindsOfVariable2에 있는 staticNum을 int a1에 대입
		KindsOfVariable2 kov2 = new KindsOfVariable2();
		int a1 = kov2.staticNum;
//		int a2 = KindsOfVariable2.staticNum;
		
		kov2.test(); // 11,11
		kov2.test(); // 12, 12
//		kov2.test(); // 13, 13
//		kov2.test(); // 14, 14
		KindsOfVariable2 kov22 = new KindsOfVariable2();
		kov22.test(); // 11, 15
//		kov22.test(); // 12, 16
		
//		kov2.test(); // 15, 17
		
	}

}
