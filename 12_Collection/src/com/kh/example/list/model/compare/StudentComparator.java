package com.kh.example.list.model.compare;

import java.util.Comparator;

import com.kh.example.list.model.vo.Student;

public class StudentComparator implements Comparator<Student> {
	// 이름 오름차순, 만약 이름이 같다면 점수 내림차순

	@Override
	public int compare(Student o1, Student o2) {
		 // 비교 주체 o1 / 비교 대상 o2
		String standardName = o1.getName();
		String objectName = o2.getName();
		int result = standardName.compareTo(objectName);
		if(result == 0) {
			return -((Integer)o1.getScore()).compareTo(o2.getScore());
		}else {
			return result;
		}
	}
	

}
