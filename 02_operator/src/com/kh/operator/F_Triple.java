package com.kh.operator;

import java.util.Scanner;

public class F_Triple {
	public void method1() {
		// 입력한 정수가 홀수인지 짝수인지 판별
		// 홀수이면 "홀수입니다", 짝수이면 "짝수입니다" 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int a = sc.nextInt();
		
		String result = a % 2 == 0 ? "짝수" : "홀수";
		
		
		System.out.println(a + "은(는) " + result + "입니다");
		
		}
	
	public void method2() {
		// 입력한 정수가 양수인지 아닌지 판별
		// 양수면 "양수다", 양수가 아니면 "양수가 아니다" 문장 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int b = sc.nextInt();
		
		String result = b > 0 ? "양수다" : "양수가 아니다";
		System.out.println(result);
		// 양수면 "양수다", 0이면 "0이다" , 음수면 " 음수다"
		
		String result1 = b > 0 ? "양수다" : (b < 0 ? "음수다" : "0이다");
		System.out.println(result1);
	}

}
