package com.kh.example.chap01_encapsultion;

// 위치로 구분하는 변수 : 전역변수 vs 지역변수
// 전역변수 = 멤버변수 = 멤버필드 = 필드
// 전역변수? 클래스 안에 작성된 변수(=메소드 밖)
// 지역변수? 메소드 안에 작성된 변수
public class Account {
	private String name = "홍길동";
	private String phone = "010-1111-2222";
	private String pwd = "q1w2e3";
	private int bankCode = 2030;
	private int balance = 0; // 잔액
	
	// 입금
	public void deposit(int money) {
		if(money > 0) {
			balance += money;
			System.out.printf("%s님의 계좌에 %d원이 입금되었습니다.\n", name, money);
		} else {
			System.out.println("잘못된 금액이 입력되었습니다.");
		}
		

	}
	
	// 출금
	public void withdraw(int money) {
		if(money <= balance) {
			balance -= money;
			System.out.println(name + "님의 계좌에서 " + money + "원이 출금되었습니다.");
			
		}else {
			System.out.println("잔액이 부족합니다. 잔액을 확인하세요.");
		}
		
	
	}
	
	// 잔액 조회
	public void displayBalance() {
		System.out.println(name + "님의 계좌에 잔액은 " + balance + "원입니다.");
		
	}

}
