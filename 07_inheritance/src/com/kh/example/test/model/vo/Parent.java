package com.kh.example.test.model.vo;

public class Parent {
	private int num;
	double dNum;
	protected boolean bool;
	public char ch;
	
	public Parent() {
		System.out.println("Parent : " + this);
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}

}
