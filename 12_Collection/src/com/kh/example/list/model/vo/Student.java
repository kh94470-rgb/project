package com.kh.example.list.model.vo;

import java.util.Objects;

// 점수 내림차순
public class Student implements Comparable<Student> {
	private String name;
	private int score;
	
	public Student() {}
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString() {
		return name + "(" + score + "점)";
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		// 객체 자체 비교
//		if(this == obj) {
//			return true;
//		}
//		if(obj == null) {
//			return false;
//		}
//		if(getClass() != obj.getClass()) {
//			return false;
//		}
//		
//		// 내용 비교
//		Student other = (Student)obj;
//		if(name == null) {
//			if(other.name != null) {
//				return false;
//			}
//		} else if(!name.equals(other.name)) {
//			return false;
//		}
//		if(score != other.score) {
//			return false;
//		}
//		return true;
//	}
//	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime*result + ((name == null) ? 0 : name.hashCode());
//		result = prime*result + score;
//		return super.hashCode();
//	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		Student other = (Student)obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, score);
	}
	@Override
	public int compareTo(Student o) {
		// 점수 내림차순
		// 비교 주체(this), 비교 대상(o)
		// 내림차순일 때,
		// 비교 주체가 비교 대상보다 크면 음수
		// 비교 주체가 비교 대상보다 작으면 양수
	    // 비교 주체와 비교 대상이 같으면 0을 반환
//		if(score > o.score) {
//			return -1;
//		}else if(score < o.score) {
//			return 1;
//		}else {
//			return 0;
//		}
		return ((Integer)score).compareTo(o.score);
	}
	

}
