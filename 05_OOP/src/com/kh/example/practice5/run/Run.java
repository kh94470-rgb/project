package com.kh.example.practice5.run;

import com.kh.example.practice5.model.vo.Employee;

public class Run {
	public static void main(String[] args) {
		Employee ep = new Employee();
		ep.setEmpNo(100);
		ep.setEmpName("홍길동");
		ep.setDept("영업부");
		ep.setJob("과장");
		ep.setAge(25);
		ep.setGender('남');
		ep.setSalary(2500000);
		ep.setBonusPoint(0.05);
		ep.setPhone("010-1234-5678");
		ep.setAddress("서울시 강남구");
		
		
		System.out.println(ep.getEmpNo());
		System.out.println(ep.getEmpName());
		System.out.println(ep.getDept());
		System.out.println(ep.getJob());
		System.out.println(ep.getAge());
		System.out.println(ep.getGender());
		System.out.println(ep.getSalary());
		System.out.println(ep.getBonusPoint());
		System.out.println(ep.getPhone());
		System.out.println(ep.getAddress());
	}

}
