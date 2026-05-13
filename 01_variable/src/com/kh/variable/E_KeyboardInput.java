package com.kh.variable;

import java.util.Scanner;

public class E_KeyboardInput {
	public void input1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		System.out.print("키를 입력하세요(소수점 첫쨰자리까지 입력) : ");
		double height = sc.nextDouble();
		
		
		System.out.printf("%s님은 %d세이며, 키는 %fcm입니다.", name, age, height);
	}
	public void input2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		System.out.print("주소를 입력하세요 : ");
		String home = sc.nextLine();
		
		// 제대로 동작하지 않는 이유
//		: nextInt()가 buffer에 남겨놓은 줄바꿈을 nextLine()이 데이터로 인지하여
//		사용자 입력이 없었음에도 받아온 것처럼 하고 종결됨
		
		System.out.printf("%s님은 %d세이며 주소는 %s입니다.", name, age, home);
	}
	
	public void input3() {
		//해결 방법 1 : 주소를 받을 떄 next()로 대체
		//한계 상황 : 띄어쓰기로 되어있는 문자열은 띄어쓰기 앞까지만 인지(next() 띄어쓰기 구분자로 인식)
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		System.out.print("주소를 입력하세요 : ");
		String home = sc.next();
		
		// 제대로 동작하지 않는 이유
//		: nextInt()가 buffer에 남겨놓은 줄바꿈을 nextLine()이 데이터로 인지하여
//		사용자 입력이 없었음에도 받아온 것처럼 하고 종결됨
		
		System.out.printf("%s님은 %d세이며 주소는 %s입니다.", name, age, home);
		
	}
	
	public void input4() {
		// 해결 방법 2 : buffer에 남아있는 줄바꿈을 제거하기 위해 nextLine() 추가
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		sc.nextLine(); // buffer에 있는 줄바꿈 제거
		
		System.out.print("주소를 입력하세요 : ");
		String home = sc.nextLine();
		
		// 제대로 동작하지 않는 이유
//		: nextInt()가 buffer에 남겨놓은 줄바꿈을 nextLine()이 데이터로 인지하여
//		사용자 입력이 없었음에도 받아온 것처럼 하고 종결됨
		
		System.out.printf("%s님은 %d세이며 주소는 %s입니다.", name, age, home);
	}
	
	public void input5() {
		// 해결 방법 3 : 나이를 받아올 때부터 buffer에 줄바꿈이 남지 않게 하기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine();
		
		System.out.print("나이를 입력하세요 : ");
//		String strAge = sc.nextLine(); // "20"
		// 문자열 -> 기본 자료형 : 파싱(parsing)
//		int age = Integer.parseInt(strAge);
		int age = Integer.parseInt(sc.nextLine());
		
		
		System.out.print("주소를 입력하세요 : ");
		String home = sc.nextLine();
		
		// char(한 글자)를 받아오고 싶을 때는? charAt() 사용
		// 01234 (zero-based index)
		// apple
		char ch = home.charAt(0);
		System.out.println(ch);
		
		
		System.out.printf("%s님은 %d세이며 주소는 %s입니다.", name, age, home);
	}

}
