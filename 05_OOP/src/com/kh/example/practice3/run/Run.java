package com.kh.example.practice3.run;

import com.kh.example.practice3.model.vo.Circle;

public class Run {
	public static void main(String[] args) {
		Circle c = new Circle();
		c.getAreaOfCircle();
		c.getSizeOfCircle();
		
		System.out.println();
		System.out.println("=== 반지름 1 증가 ===");
		c.incrementRadius();
		System.out.println();
		
		c.getAreaOfCircle();
		c.getSizeOfCircle();
		
	}

}
