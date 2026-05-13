package com.kh.example.chap02_abstract.family.model.vo;

import java.awt.event.MouseListener;
import java.io.Serializable;

public interface Basic extends Cloneable, Serializable, MouseListener {
//								마커 인터페이스(Marker Interface)
	
//	private int a;
	public static final double PI = 3.14;
	int date = 5;
	
	public abstract void breathe();
	void pee();
	
	public default void test() {
		
	}

}
