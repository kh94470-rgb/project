package com.kh.example.animal.controller;

import com.kh.example.animal.model.vo.Animal;
import com.kh.example.animal.model.vo.Dog;
import com.kh.example.animal.model.vo.Snake;

public class AnimalController {
	public void method() {
		Animal a = new Animal("강아지", 9, 6.3);
//		System.out.println(a.inform());
		System.out.println(a.toString());
		System.out.println(a);
		
		Dog d = new Dog("바둑이", 3, 12.9, 50.1, "단모");
//		System.out.println(d.inform());
		System.out.println(d);
		
		Snake s = new Snake("방울이", 4, 10.2, "빗살");	
//		System.out.println(s.inform());
		System.out.println(s);
				
		
	}

}
