package com.kh.example.test.model.vo;

public class Child2 extends Parent {
	private String str;
	
	public Child2() {
		System.out.println("Child2 : " + this);
//		super.num = 0;
		super.dNum = 1.2;
		super.bool = true;
		super.ch = 'B';
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	public String getStr() {
		return str;
	}

}
