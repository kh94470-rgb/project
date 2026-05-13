package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close; // close에 JDBCTemplate을 굳이 안 쓰기 위해

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {
	/*
	  	이전 프로젝트에서 DAO가 맡은 업무
	  	1. JDBC 드라이버 등록
	  	2. DB 연결 Connection 객체 생성
	  	3. SQL 실행
		4. 처리 결과에 따른 트랜잭션 처리
		5. 자원 반납
		--> 실제로 DAO가 해야하는 업무는 SQL문을 DB로 전달해서 실행하고 반환 값을 받아오는 것만 하면 됨(3번)
		--> 1, 2, 4, 5번 업무 분리 (JDBCTemplate, Service단 도입)
		
		+ JDBCTemplate? JDBC에 필요한 공통 업무(중복 코드)를 모아둔 곳
		+ Service단? model에 묶여있는 곳으로 DAO 보조
		
	*/
	
	public ArrayList<Member> selectAll(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		String query = "select * from member";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String memberPwd = rset.getString("member_pwd");
				String memberName = rset.getString("member_name");
				char gender = rset.getString("gender").charAt(0);
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				int age = rset.getInt("age");
				Date enrollDate = rset.getDate("enroll_date");
				
				Member m = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address, enrollDate);
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // Connection 닫으면 길이 끊어짐 그래서 마지막에 닫음
			close(rset);
			close(stmt);
		}
		return list; // return 체크
	}

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into member values(?, ?, ?, ?, ?, ?, ?, ?, sysdate)"; // ' '을 안 넣어도 되는 이유 : 
																					 //pstmt.setString(1, m.getMemberId());얘네가 알아서 넣어줌
		try {
			pstmt = conn.prepareStatement(query); // 테이블 컬럼명 순서
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getGender()+"");
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getAddress());
			pstmt.setInt(8, m.getAge());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<Member> selectMemberId(Connection conn, String id) { // 부분 검색 (포함 검색)
		PreparedStatement pstmt = null;
//		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
//		String query = "select * from member where member_id like '%" + id + "%'";  
		String query = "select * from member where member_id like ?";
		
		try {
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + id + "%");
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new Member(rset.getString("member_id"),
									rset.getString("member_pwd"),
									rset.getString("member_name"),
									rset.getString("gender").charAt(0),
									rset.getString("email"),
									rset.getString("phone"),
									rset.getInt("age"),
									rset.getString("address"),
									rset.getDate("enroll_date")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
//			close(stmt);
		}
		
		
		return list;
	}

	public ArrayList<Member> selectGender(Connection conn, char gen) {
		Statement stmt = null;
//		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		String query = "select * from member where gender = '" + gen +"'"; // Statement에 넣을 땐 리터럴 ' ' 생각해주기
//		String query = "select * from member where gender = ?";
		
		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, gen+"");
//			rset = pstmt.executeQuery();
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				String memberId = rset.getString("member_id");
				String memberPwd = rset.getString("member_pwd");
				String memberName = rset.getString("member_name");
				char gender = rset.getString("gender").charAt(0);
				String email = rset.getString("email");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				int age = rset.getInt("age");
				Date enrollDAte = rset.getDate("enroll_date");
				
				Member m = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address, enrollDAte);
				list.add(m);		
				
//				list.add(new Member(rset.getString("member_id"),
//						 			rset.getString("member_pwd"),
//						 			rset.getString("member_name"),
//						 			rset.getString("gender").charAt(0),
//						 			rset.getString("email"),
//						 			rset.getString("phone"),
//						 			rset.getInt("age"),
//						 			rset.getString("address"),
//						 			rset.getDate("enroll_date")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
//			close(pstmt);
		}
		
		return list;
	}

	public int checkMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
//		Statement stmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = "select count(*) from member where member_id = ?";
//		String query = "select count(*) from member where member_id = '" + memberId + "'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery(); //행의 개수 생각하기 count로 해서 행은 1개
			if(rset.next()) {
				//result = rset.getInt("count(*)");
				result = rset.getInt(1);
			}
			
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
//			close(stmt);
			close(rset);
		}
		
		
		return result;
	}

	public int updateMember(Connection conn, String memberId, String upStr, String input) {
		PreparedStatement pstmt = null;
//		Statement stmt = null;
		int result = 0;
		String query = "update member set " + upStr + "= ? where member_Id = ?";
//		String query = "update member set ? = ? where member_Id = ?";
//		String query = "update member set " + upStr + " = '" + input + "' where member_Id = '" + memberId + "'";
		try {
			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, upStr);
//			pstmt.setString(2, input);
//			pstmt.setString(3, memberId);
			
			pstmt.setString(1, input);
			pstmt.setString(2, memberId);
			result = pstmt.executeUpdate();
			
//			stmt = conn.createStatement();
//			result = stmt.executeUpdate(query); //dml문은 commit이든 rollback을 해야 다음 넘어감
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
//			close(stmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
//		PreparedStatement pstmt = null;
		Statement stmt = null;
		int result = 0;
		
//		String query = "delete from member where member_id = ?";
		String query = "delete from member where member_id = '" + memberId + "'";
		
		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, memberId);
//			result = pstmt.executeUpdate();
			
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close(pstmt);
			close(stmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
