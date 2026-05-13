package com.kh.example.map.model.vo;

import java.util.Objects;

public class Snack {
	private String flavor;
	private int price;
	
	public Snack() {}
	public Snack(String flavor, int price) {
		this.flavor = flavor;
		this.price = price;
	}
	
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return flavor + "[" + price + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		Snack other = (Snack)obj;
		return Objects.equals(flavor, other.flavor) && price == other.price;
	
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(flavor, price);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
