package com.kh.variable;

public class A_Variable { // 기능 클래스
	
	public void declareVariable() { // 메소드 정의
		//변수 선언 후 초기화
		// 1. 논리형
		boolean isTrue;
		
		// 2. 숫자형
		// 2-1. 정수형
		byte bb;
		short ss;
		int ii;
		long ll;
		// 2-2. 실수형
		float ff;
		double dd;
		
		// 3. 문자형
		// 3-1. 문자
		char ch;
		// 3-2. 문자열
		String str;
		
		isTrue = true;
		bb = 100;
		ss = -17;
		ii = 0;
		ll = 1234567890L;
		ff = 3.14f;
		dd = 3.14;
		ch ='가';
		str ="나";
		
		System.out.println("isTrue의 값 : " + isTrue);
		System.out.println("bb의 값 : " + bb);
		System.out.println("ss의 값 : " + ss);
		System.out.println("ii의 값 : " + ii);
		System.out.println("ll의 값 : " + ll);
		System.out.println("ff의 값 : " + ff);
		System.out.println("dd의 값 : " + dd);
		System.out.println("ch의 값 : " + ch);
		System.out.println("str의 값 : " + str);
	}
	
	public void initVariable() {
		// 변수 선언과 동시에 초기화
		// 1. 논리형
		boolean boo = false;
		// 2. 숫자형
		// 2-1. 정수형
		byte by = 10;
		short sh = -5;
		int in = 55;
		long lo = 23545L;
		// 2-2. 실수형
		float fl = 32.5f;
		double dou = 565.5;
		// 3. 문자형
		// 3-1. 문자
		char cjl = '아';
		// 3-2. 문자열
		String skr = "아아아";
		
		System.out.println("boo의 값 : " + boo);
		System.out.println("by의 값 : " + by);
		System.out.println("sh의 값 : " + sh);
		System.out.println("in의 값 : " + in);
		System.out.println("lo의 값 : " + lo);
		System.out.println("fl의 값 : " + fl);
		System.out.println("dou의 값 : " + dou);
		System.out.println("cjl의 값 : " + cjl);
		System.out.println("skr의 값 : " + skr);
	}
}
