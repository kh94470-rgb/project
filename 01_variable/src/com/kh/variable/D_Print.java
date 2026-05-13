package com.kh.variable;

public class D_Print {
	public void print() {
		System.out.print("안녕하세요");
		System.out.print("반갑습니다");
		System.out.println("다음에봐요");
		System.out.println();
		System.out.println("오랜만이네요");
		System.out.println("건강하세요");
		
		
		//안녕하세요반갑습니다다음에봐요
		//
		//오랜만이네요
		//건강하세요
		//
		
	}
	
	public void printf() {
		String str1 = "안녕하세요";
		String str2 = "반갑습니다";
		
		//안녕하세요, 홍길동입니다. 반갑습니다. 친하게 지내요!
		System.out.println(str1 + ", 홍길동입니다. " + str2 +". 친하게 지내요!");
		System.out.printf("%s, 홍길동입니다. %s. 친하게 지내요!\n", str1, str2);
		
		int age = 20;
		String name = "홍길동";
		String job = "대통령";
		char gender = '남';
		//안녕하세요. 반갑습니다. 20살 남자 홍길동입니다. 저는 멋진 대통령이 꿈입니다.
		System.out.printf("%s. %s. %d살 %c자 %s입니다. 저는 멋진 %s이 꿈입니다.\n", str1, str2, age, gender, name, job);
		
	}

}
