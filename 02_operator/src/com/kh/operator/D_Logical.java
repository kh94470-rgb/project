package com.kh.operator;

import java.util.Scanner;

public class D_Logical {
	public void method1() {
		//입력한 정수 값이 1~100 사이의 숫자인지 확인
		//42+3
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int a = sc.nextInt();
		
		//boolean bool = 1 <= a && a <= 100;
		//System.out.println(a + "숫자는 1~100 사이의 숫자인가?" + bool);
		System.out.println(a + "숫자는 1~100 사이의 숫자인가?" + (1 <= a && a <= 100));
		
	}
	
	public void method2() {
		//입력한 문자 값이 대문자인지 확인 15
		Scanner sc = new Scanner(System.in);
//		System.out.print("문자 하나 입력 : ");
//		String str = sc.nextLine();
//		char ch = str.charAt(0);
		
//		boolean bool = (ch >= 'A' && ch<= 'Z');
//		ySystem.out.println("영어 대문자인가? " + bool);
		
		System.out.print("계속 하시려면 Y 또는 y를 입력하세요 : ");
//		String str1 = sc.nextLine();
//		char ch2 = str1.charAt(0);
		char ch2 = sc.nextLine().charAt(0); //메소드 체이닝
		boolean boo = (ch2 == 'y' || ch2 == 'Y');
		
		//코드 작성
		System.out.println("계속 하겠다고 하셨습니까? : " + boo);
	}
	

}
