package com.kh.example.chap05.constructor.run;

import com.kh.example.chap05.constructor.model.vo.User;

public class Run {
	public static void main(String[] args) {
		User u1 = new User();
		System.out.println("Run u1 : " + u1);
		u1.inform();
		u1.inputValue("user01");
		u1.inputValue2("홍길도");
		u1.inputValue(20);
		u1.inputValue(78.543);
		u1.inputValue("user02", "김철수", 17, 55.5);
//		u1.inputValue5("user02", "김철수", 17, 60);
		u1.inform();
		u1.inputValue(60);
		u1.inform();
		
		User u2 = new User("user03", "김영희", 25, 123.456);
		u2.inform();
		u2.inputValue(26);
		u2.inform();
	}

}
