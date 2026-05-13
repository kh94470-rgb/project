package com.kh.example.chap06_method.run;

import java.util.Arrays;

import com.kh.example.chap05.constructor.model.vo.User;
import com.kh.example.chap06_method.controller.MethodPractice;
import com.kh.example.chap06_method.model.vo.Trainee;

public class Run {
	public static void main(String[] args) {
		MethodPractice mp = new MethodPractice();
//		mp.method1();
		
//		int result1 = mp.method2();
//		System.out.println(result1);
//		System.out.println(mp.method2());
		
//		mp.method3(10.3, 'A');
//		double dNum = 10.3;
//		char ch = 'A';
//		mp.method3(dNum, ch);
//		
//		mp.method4(mp.method2(), dNum);
//		System.out.println(mp.method4(mp.method2(), dNum));
//		
		double[] doubleArray = new double[3];
		System.out.println("Run doubleArray : " + Arrays.toString(doubleArray));
		System.out.println("Run doubleArray : " + doubleArray);
		mp.method5(doubleArray);
		System.out.println("Runs doubleArray : " + Arrays.toString(doubleArray));
		
		User user = mp.method6();
		System.out.println("Run user : " + user);
		
		System.out.println("============================");
		
		Trainee t1 = new Trainee("홍길동", 502, "종일", 95.5);
		System.out.println(t1.inform());
		t1.setName("김철수");
		System.out.println(t1.inform());
		t1.setClassRoom(501);
		System.out.println(t1.inform());
		t1.setTime("오후");
		System.out.println(t1.inform());
		Trainee.setScore(66.1);
		System.out.println(t1.inform());
		
		System.out.println(t1.getName());
		System.out.println(t1.getClassRoom());
		System.out.println(t1.getACADEMY());
		System.out.println(t1.getTime());
		System.out.println(Trainee.getScore());
		
	}

}
