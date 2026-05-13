package com.kh.example.chap01_encapsultion;

public class Run {
	public static void main(String[] args) {
		Account a = new Account();
		
//		a.balance += 100000; // 홍길동씨
//		System.out.println(a.balance);
		a.deposit(100000);
//		
//		a.balance -= 50000; // 홍길동씨
//		System.out.println(a.balance);
		a.withdraw(50000);
		a.displayBalance();
//		
//		a.balance -= 1000000000; // 박신우씨
//		System.out.println(a.balance);
	}

}
