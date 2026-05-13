package com.kh.example.chap01.condition;

import java.util.Scanner;

public class B_Switch {
	public void method1() {
		// 정수 두 개와 연산기호문자(+, -, *, /) 1개를 입력 받아서
		// 연산 기호 문자에 해당하는 계산 수행
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		int first = sc.nextInt();
		
		System.out.print("두 번째 정수 : ");
		int second = sc.nextInt();
		
//		sc.nextLine();
		
		System.out.print("연산자(+, -, *, /) : ");
//		String opStr = sc.next();
//		char op = opStr.charAt(0);
		char op = sc.next().charAt(0);
		
		int result = 0;
//		switch(op) {
//		case '+' :
//			result = first + second;
//			break;
//		case '-' :
//			result = first - second;
//			break;
//		case '*' : 
//			result = first * second;
//			break;
//		case '/' :
//			if(second == 0) {
//				System.out.println("0으로 나눌 수 없습니다. 결과 값은 임의로 출력됩니다.");
//			}else {
//			result = first / second;
		
		if(op == '+') {
			result = first + second;
		}else if(op == '-') {
			result = first - second;
		}else if(op == '*') {
			result = first * second;
		}else if(op == '/') {
			switch(second) {
			case 0:
				System.out.println("0으로 나눌 수 없습니다. 결과 값은 임의로 출력됩니다.");
				break;
			default:
				result = first/second;
			}
		}
		
		System.out.printf("%d %c %d = %d", first, op, second, result);
	}
	public void method2() {
		// 사용자에게 과일을 입력받아 해당 과일의 가격 출력
		// 사과 1000원, 바나나 5000원, 복숭아 3000원, 키위 2000원
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사과, 바나나 , 복숭아, 키위 중 가격이 궁금한 과일을 적어주세요");
		System.out.print("어떤 과일의 가격이 궁금하세요? ");
		String fruit = sc.nextLine();
		
		int price = 0;
		
		switch(fruit) {
		case "사과" : price = 1000; break;
		case "바나나" : price = 5000; break;
		case "복숭아" : price = 3000; break;
		case "키위" : price = 2000; break;
		default : price = -1;
		}
		
		if(price < 0) {
			System.out.println("해당 과일은 저희 집에 없어요 옆에 마트로 가보세요");
		}else {
			System.out.println(price + "원이니다!");
		}
		
		
		}
	public void method3() {
		// 1~12 사이의 숫자를 입력 받아 해당하는 숫자를 달로 보고
		// 그 달의 마지막 날짜 출력
		// ex. 1~12 사이의 숫자를 하나 입력하세요 : 1
		// 1월의 마지막 날은 31일입니다
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 월? ");
		int a = sc.nextInt();
		
		int last = 0;
//		
//		switch(a) {
//		case 1: last = 31; break;
//		case 2: last = 28; break;
//		case 3: last = 31; break;
//		case 4: last = 30; break;
//		case 5: last = 31; break;
//		case 6: last = 30; break;
//		case 7: last = 31; break;
//		case 8: last = 31; break;
//		case 9: last = 30; break;
//		case 10: last = 31; break;
//		case 11: last = 30; break;
//		case 12: last = 31; 
//		}

		switch(a) {
//		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
		case 1, 3, 5, 7, 8, 10, 12:
			last = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			last = 30;
			break;
		case 2: last = 28; break;
		}
		
		if(last == 0) {
			System.out.println("1부터 12 사이의 숫자를 입력해주세요.");
		}else {
			System.out.println(a + "월의 마지막 날은 " + last + "일입니다");
		}
	}
	public void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 간단 계산기");
		System.out.println("2. 과일 가게");
		System.out.println("3. 달의 마지막 날");
		System.out.print("메뉴 번호 : ");
//		int menu = Integer.parseInt(sc.nextLine());
		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			method1();
			break;
		case 2:
			method2();
			break;
		case 3:
			method3();
			break;
		default:
			System.out.println("잘못된 번호입니다.");
		}
	}

}
