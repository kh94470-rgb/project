package com.kh.variable;

public class C_Cast {
	
	//자동 형변환
	public void cast1() {
		byte bNum = 3;
		int iNum = bNum;
		
		long lNum = 1000000000000L;
		float fNum = lNum;
		
		int num = 'A';
		char ch = 97;
		System.out.println("num : " + num);
		System.out.println("ch : " + ch);
		
		//char ch2 = num; // 에러 발생 : num이 4byte라는 크기 자체를 갖고있기 때문에 char안에 들어갈 수 없음
		char ch2 = (char)num;
		System.out.println("ch2 : " + ch2);
		
		//char ch3 = -10;
		int num1 = -10;
		char ch3 = (char)num1;
		System.out.println("ch3 : " + ch3);
	}
	
	public void cast2() {
		int iNum = 10;
		long lNum = 100L;
		
		
		int result1 = iNum + (int)lNum;
		
		
		long result2 = iNum+ lNum;
		
		int result3 = (int)(iNum + lNum);
		
		//int result4 = (int)iNum + lNum
		
		
		

	}

}
