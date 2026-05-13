package com.kh.practice.student.view;

import com.kh.practice.student.controller.StudentController;

public class StudentMenu {
	private StudentController ssm = new StudentController();
	
	public StudentMenu() {
		System.out.println("======== 학생 정보 출력 =======");
		ssm.printStudent("김길동", "자바", 100);
		
		
		System.out.println("========= 학생성적 출력 =========");
		
		System.out.println("========== 성적 결과 출력 =========");
		
	}

}
