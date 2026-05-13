package com.kh.example.practice4.run;

import com.kh.example.practice4.model.vo.Book;

public class Run {
	public static void main(String[] args) {
		Book b = new Book();
		b.inform();
		
		Book b1 = new Book("사과는 왜 빨갈까?", "KH정보교육원", "박신우");
		b1.inform();
		
		Book b2 = new Book("바다는 왜 파랄까?", "KH학원", "우산박", 3000, 0.1);
		b2.inform();
	}

}
