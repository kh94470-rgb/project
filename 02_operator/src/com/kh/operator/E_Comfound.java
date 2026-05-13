package com.kh.operator;

public class E_Comfound {
	public void method() {
		int num = 12;
		System.out.println("num : " + num);
		
		// 3 증가
//		num = num + 3;
		num += 3;
		System.out.println("num : " + num);
		
		// 5 감소
//		num = num - 5;
		num -= 5;
		System.out.println("num : " + num);
		
		// 6 곱하기
//		num = num * 6;
		num *= 6;
		System.out.println("num : " + num);
		
		// 2 나누기
//		num = num / 2;
		num /= 2;
		System.out.println("num : " + num);
		
		// 4로 나눈 나머지 대입
//		num = num % 4;
		num %= 4;
		System.out.println("num : " + num);
	}

}
