package com.kh.example.list.model.compare;

import java.util.Comparator;

public class ListComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// 비교 주체(o1), 비교 대상(o2)
		// 오름차순일 때,
		// 비교 주체가 비교 대상보다 크면 양수
		// 비교 주체가 비교 대상보다 작으면 음수
		// 비교 주체와 비교 대상이 같으면 0을 반환
		
		//return -o1.compareTo(o2);
		return o2.compareTo(o1);
	}

	
	

}
