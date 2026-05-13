package com.kh.example.chap02_abstract.controller;

import com.kh.example.chap02_abstract.family.model.vo.Basic;
import com.kh.example.chap02_abstract.family.model.vo.Family;
import com.kh.example.chap02_abstract.family.model.vo.Mother;

public class FamilyController {
	public void method() {
		//Family f = new Family(); // 추상 클래스로는 객체 생성 불가
		Family m = new Mother();
		
		//Basic v = new Basic(); // 인터페이스로는 객체 생성 불가
		Basic b = new Mother();
	}

}
