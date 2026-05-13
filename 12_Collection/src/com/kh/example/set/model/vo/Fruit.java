package com.kh.example.set.model.vo;

import java.util.Objects;

public class Fruit implements Comparable<Fruit> {
	private String name;
	private int price;
	
	public Fruit() {}
	public Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return name + "(" + price +"원)";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Fruit other = (Fruit)obj;
		return Objects.equals(name, other.name) && price == other.price;
		
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}
	@Override
	public int compareTo(Fruit o) {
		// 가격 오름차순
		
		return ((Integer)price).compareTo(o.price);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
