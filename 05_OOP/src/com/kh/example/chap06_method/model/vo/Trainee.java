package com.kh.example.chap06_method.model.vo;

public class Trainee {
	private String name;
	private final String ACADEMY = "KH";
	private int classRoom;
	private String time;
	private static double score;
	
	// 기본 생성자
	public Trainee() {}
	
	// 매개변수 있는 생성자
	public Trainee(String name, int classRoom, String time, double score) {
		this.name = name;
		this.classRoom = classRoom;
		this.time = time;
		Trainee.score = score;
		
	}
	
	// 전체 정보 메소드
	public String inform() {
		return ACADEMY + " " + name + " 훈련생은 " + classRoom + "반 " + time + "이고, "
				+ score + "점입니다.";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public static void setScore(double score) {
		Trainee.score = score;
	}
	
	public String getName() {
		return name;
	}
	public int getClassRoom() {
		return classRoom;
	}
	public String getTime() {
		return time;
	}
	public static double getScore() {
		return score;
	}
	public String getACADEMY() {
		return ACADEMY;
	}
	
	
	
	
	
	

}
