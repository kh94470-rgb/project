package com.kh.example.person.controller;

import com.kh.example.person.model.vo.Person;

public class PersonController {
	public void method1() {
		// Person객체가 들어갈 수 있는 5개의 공간 pArr 생성
		Person[] pArr = new Person[5];
		
//		pArr[0].personInfo(); NullPointerException 발생
		
		for(int i = 0; i < pArr.length; i++ ) {
			System.out.println("pArr[" + i + "] : " + pArr[1]);
		}
		
		//각 인덱스 별로 객체 생성 후 대입
		pArr[0] = new Person();
		pArr[1] = new Person("강건강", 10);
		pArr[2] = new Person("남나눔", 29, '남', 178.4, 67.0);
		pArr[3] = new Person("아아아", 230);
		pArr[4] = new Person("우아니", 330, '여', 215.2, 676.3);
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println("pArr[" + i + "] : " + pArr[i]);
		}
		
		// 초기화가 잘 됐는지 출력
		for(int i = 0; i < pArr.length; i++) {
		
		System.out.println(pArr[i].personInfo());
		}
		
		// 선언과 동시에 초기화
		Person[] pArr2 = {new Person(),
						new Person("문미미", 47, '여', 432.2, 21.2),
						new Person("박보배", 23, '남', 245.2, 60.1)};
		for(int i = 0; i < pArr2.length; i++) {
			System.out.println("pArr[" + i + "] : " + pArr2[i]);
			System.out.println(pArr2[i].personInfo());
		}
		
		// 객체를 레퍼런스 변수에 저장 후 활용할 수 있음
		Person song = new Person("송성실", 25, '남', 175.2, 22.3);
		Person yoon = new Person("윤예의", 11, '남', 152.4, 42.1);
		
		Person[] pArr3 = new Person[2];
		pArr3[0] = song;
		pArr3[1] = yoon;
		
		Person[] pArr4 = {yoon, song};
		
		
	}
	

}
