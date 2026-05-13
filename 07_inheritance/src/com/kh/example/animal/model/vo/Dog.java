package com.kh.example.animal.model.vo;

public class Dog extends Animal {
	
	private double height;
	private String hair;
	
	public Dog() {}
	public Dog(String name, int age, double weight, double height, String hair) {
		super(name, age, weight);
		this.height = height;
		this.hair = hair;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	public double getHeight() {
		return height;
	}
	public void setHair(String hair) {
		this.hair = hair;
	}
	public String getHair() {
		return hair;
	}
//	@Override
//	public String inform() {
//		return super.inform() + " " + height +" " + hair;
//	}
	
	@Override
	public String toString() {
		return super.toString() + " " + height + " " + hair;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
