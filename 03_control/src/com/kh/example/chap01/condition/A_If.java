package com.kh.example.chap01.condition;

import java.util.Scanner;

public class A_If {
	public void method1() {
		// 키보드로 입력한 숫자가 짝수인지 홀수인지 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("입력한 숫자 : ");
		int a = sc.nextInt();
		
		String result;
				
		if (a%2 == 0) {
//			System.out.println("짝수");
			result = "짝수입니다";
		}else {
//			System.out.println("홀수");
			result = "홀수입니다";
		}
		System.out.println(result);
	}
	
	public void method2() {
		// 키보드로 입력한 숫자가 양수인지, 0인지 , 음수인지 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("입력한 숫자 : ");
		int b = sc.nextInt();
		
		String result1 = "";
		if(b > 0) {
			result1 = "양수";
		}else if(b == 0) {
			result1 = "0";
		}else if(b < 0) {
			result1 = "음수";
		}
		System.out.println(result1);
		
//		String result1;
//		
//		if (b > 0) {
//			result1 = "양수입니다";
//		}else if (b == 0) {
//			result1 = "0입니다";
//		}else {
//			result1 = "음수입니다";
//		}
//		System.out.println(result1);
		
//		if(b > 0) {
//			System.out.println("양수다");
//		}else {// num <= 0, num 0 음수
//			if(b == 0) {
//				System.out.println("0이다");
//			}else {
//				System.out.println("음수다");
//		}
	}
		public void method3() {
			// 키보드로 성별(M/F)을 입력받아 남자면 "XY입니다", 여자면 "XX입니다" 출력 
			Scanner sc = new Scanner(System.in);
			System.out.print("성별은(M/F) : ");
//			String strGender = sc.nextLine(); // "M", "F"
//			char gender = strGender.charAt(0); 
			char gender = sc.nextLine().charAt(0);
			
			String result;
			
//			if (gender == 'M' || gender == 'm') {
//				result = "XY입니다";
//			}else if(gender == 'F' || gender == 'f') {
//				result = "XX입니다";
//			}else {
//				result = "잘못 입력했습니다";
//			}
			switch(gender) {
			case 'M': case 'm': 
				result = "XY입니다";
				break;
			case 'F': case 'f':
				result = "XX입니다";
				break;
			default : 
				result = "잘못 입력했습니다";
			}
			System.out.println(result);
		}
		
		public void method4() {
			//사용자에게 나이를 입력받아 성인인지 청소년인지 어린이인지 출력
			// 성인 : 19세 초과 / 청소년 : 13세 초과 19세 이하 / 어린이 : 13세 이하
			Scanner sc = new Scanner(System.in);
			System.out.print("나이 : ");
			int a = sc.nextInt();
			
			String age;
			
			if(a >= 0) {
				if(a > 19 ) {
					age = "성인";
				}else if (a > 13) {
					age = "청소년";
				}else {
					age = "어린이";
				}
				System.out.println(age);
			}else {
				System.out.println("나이는 0세부터 시작합니다.");
			}
		}
		public void method5() {
			// 사용자에게 이름을 받아 본인인지 확인
			// 자신의 이름과 같으면 "본인입니다", 자신의 이름과 다르면 "본인이 아닙니다"
			Scanner sc = new Scanner(System.in);
			System.out.print("이름 : ");
			String na = sc.nextLine();
			
//			String me;
			// 문자열 내용은 ==으로 비교 불가!!1
//			if (name == "홍길동") {
//				me = "본인입니다";
//			}else {
//				me = "본인이 아닙니다";
//			}
//			System.out.println(me);
			
			if(na.equals("홍길동")) {
				System.out.println("본인입니다");
			}else {
				System.out.println("본인이 아닙니다");
				
			}
		}

}
