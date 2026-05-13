package com.kh.example.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.TreeSet;

import com.kh.example.list.model.compare.ListComparator;
import com.kh.example.set.model.vo.Fruit;

public class SetController {
	public void doSet() {
		// Set<String> set = new hastSet<String>(); // 다형성
		HashSet<String> set = new HashSet<String>();
		set.add("사과");
		set.add("파인애플");
		set.add("자두");
		set.add("귤");
		set.add("바나나");
		System.out.println("set : " + set);  // 순서 유지 x
		
		set.add("귤");
		System.out.println("set : " + set); // 중복 허용 x
		
		HashSet<Fruit> fruitSet = new HashSet<Fruit>();
		fruitSet.add(new Fruit("사과", 1000));
		fruitSet.add(new Fruit("감", 2000));
		fruitSet.add(new Fruit("배", 3000));
		System.out.println(fruitSet);
		fruitSet.add(new Fruit("감", 2000));
		System.out.println(fruitSet);
		
		// 순서 유지가 가능한 Set(중복 저장 x)
		LinkedHashSet<String> set2 = new LinkedHashSet<String>();
		set2.add("딸기");
		set2.add("복숭아");
		set2.add("체리");
		set2.add("오렌지");
		System.out.println("set2 : " + set2);
		
		set2.add("망고");
		set2.add("수박");
		set2.add("메론");
		set2.add("딸기");
		System.out.println("set2 : " + set2);
		
		// 자동 정렬해주는 Set
		TreeSet<String> set3 = new TreeSet<String>(set2);
		System.out.println("set3 : " + set3);
		
		TreeSet<String> set4 = new TreeSet<String>(new ListComparator());
		set4.addAll(set2);
		System.out.println("set4 : " + set4);
		
		TreeSet<Fruit> fruitSet2 = new TreeSet<Fruit>(fruitSet);
		System.out.println(fruitSet2);
		
		System.out.println("==Set 안에 element에 접근하기==");
//		for(int i = 0; i < set4.size(); i++) {
//			set4.get
//		}
		// 향상된 for문(=for each문)
		int[] arr1 = new int[3];
		for(int a : arr1) {
			System.out.println(a);
		}
		
		System.out.println("방법 1. 향상된 for문 이용하기");
		for(String f : set4) {
			System.out.println(f);
		}	
		
		System.out.println();
		
		System.out.println("2. Set을 List화 하기");
		ArrayList<String> list = new ArrayList<String>(set4);
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
		
		System.out.println();
		
		System.out.println("3. iterator 이용하기");
		Iterator<String> it = set4.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		while(it.hasNext()) {
			System.out.println("re : " + it.next());
		}
		
		//ListIterator : 양방향(List계열에만 존재)
		ListIterator<String> lit = list.listIterator();
		while(lit.hasNext()) {
			System.out.println("lit next : " + lit.next());
		}
		while(lit.hasNext()) {
			System.out.println("re) lit next : " + lit.next());
		}
		while(lit.hasPrevious()) {
			System.out.println("lit previous : " + lit.previous());
		}
		
		System.out.println();
		System.out.println();
		System.out.println("fruitSet의 element 접근해보기");
		System.out.println(fruitSet);
		
		System.out.println("1. 향상된 for문 이용하기");
		for(Fruit fr : fruitSet) {
			System.out.println(fr);
		}
		System.out.println();
		System.out.println("2. List화 하기");
		ArrayList<Fruit> list2 = new ArrayList<Fruit>();
		list2.addAll(fruitSet);
		for(int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i));
		}
		
		
		System.out.println();
		System.out.println("3.  iterator 이용하기");
		Iterator<Fruit> it2 = fruitSet.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
