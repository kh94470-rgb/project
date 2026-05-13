package com.kh.example.list.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kh.example.list.model.compare.ListComparator;
import com.kh.example.list.model.compare.StudentComparator;
import com.kh.example.list.model.vo.Student;

public class ListController {
	public void doList() {
		List l = new ArrayList(); // 다형성 적용,초기 용량 10
		// 제네릭 미사용 = 타입 제한 x = 모든 타입을 다 받을 수 있게 함(Object)
//		l.add(Object e) / l.get():Object
		
		ArrayList<String> list = new ArrayList<String>(3);
		list.add(new String("테스트"));
		list.add("도대담");
		list.add("남나눔");
		
		System.out.println("list : " + list);
		
		list.add("하현호");
		System.out.println("list : " + list);
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		
		list.add("문미미");
		System.out.println("list : " + list);
		System.out.println("현재 list에 담긴 element 개수 : " + list.size());
		// 장점 1. 크기 제약이 없다
		// 특징 1. 저장 순서가 유지된다

		// 장점 2. 추가/삭제/정렬 등의 기능처리 간단하다
		list.add(0, "류라라");
		System.out.println("list : " + list);
		
		list.add(3, "강건강");
		System.out.println("list : " + list);
		
		String remove1 = list.remove(1);
		System.out.println(remove1);
		System.out.println("list : " + list);
		
		for(int i = 0; i < list.size(); i ++) {
			String elem = list.get(i);
			if(elem.equals("강건강")) {
				list.remove(i);
				break;
			}
		}
		System.out.println("list : " + list);
		
//		System.out.println(list.remove("강건강"));
//		System.out.println("list : " + list);
//		System.out.println(list.remove("테스트"));
//		System.out.println("list : " + list);
		
		// Student객체만 저장할 수 있는 ArrayList studenList 생성
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("박보배", 100));
		studentList.add(new Student("강건강", 40));
		studentList.add(new Student("차청춘", 70));
		System.out.println(studentList);
		
		// 매개변수끼리 다형성이 이루어졌는데 동적 바인딩이 되어야 제거가 되는데
		// 동적 바인딩 조건이 1. 다형성 적용 2. 오버라이딩 적용
		// 근데 1은 이루어졌고 2는 이루어지지 않아서 정적 바인딩만 된 상태
		studentList.remove(new Student("박보배", 100));
		System.out.println(studentList);
		
		Student s1 = new Student("홍길동", 55);
		Student s2 = new Student("김길동", 44);
		Student s3 = new Student("이길동", 33);
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		System.out.println(studentList);
		
		studentList.remove(s2);
		System.out.println(studentList);
		
		for(int i = 0; i < studentList.size(); i++) {
			Student s = studentList.get(i);
			if(s.getName().equals("홍길동") && s.getScore() == 55) {
				studentList.remove(i);
			}
		}
		System.out.println(studentList);
		
		System.out.println("list : " + list);
		Collections.sort(list);
		System.out.println("list : " + list);
		
		Collections.sort(list, new ListComparator());
		list.sort(new ListComparator());
		System.out.println("list : " + list);
		
		System.out.println(studentList);
		Collections.sort(studentList);
		System.out.println(studentList);
		
		studentList.add(new Student("박길동", 66));
		studentList.add(new Student("이길동", 88));
		System.out.println(studentList);
		
		studentList.sort(new StudentComparator());
		System.out.println(studentList);
		
		String result = list.set(3, "박보배");
		System.out.println("list : " + list);
		System.out.println(result);
		
		String result2 = list.get(0);
		System.out.println(result2);
		System.out.println("list : " + list);
		
		System.out.println(list.contains("남나눔"));
		System.out.println(list.indexOf("남나눔"));
		System.out.println(list.contains("강건강"));
		System.out.println(list.indexOf("강건강"));
		
		System.out.println(studentList.contains((new Student("이길동", 88))));
		System.out.println(studentList.indexOf(new Student("이길동", 88)));
		
		System.out.println(list.isEmpty());
		list.clear();
		System.out.println("list : " + list);
		System.out.println(list.isEmpty());
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
