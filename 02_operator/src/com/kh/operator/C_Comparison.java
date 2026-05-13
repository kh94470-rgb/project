package com.kh.operator;

public class C_Comparison {
	public void method() {
		int a = 10;
		int b = 25;
		
		boolean result1 = (a == b);
		boolean result2 = (a <= b);
		boolean result3 = (a >= b);
		boolean result4 = result1 != result3;
		
		System.out.println(result1); // false
		System.out.println(result2); // true
		System.out.println(result3); // false
		System.out.println(result4); // false
		
	
		
		System.out.println("b가 짝수인가? " + (b%2 == 0));
		System.out.println("b가 홀수인가? " + (b%2 == 1));
		System.out.println("b가 홀수인가? " + (b%2 != 0));
	}

}
