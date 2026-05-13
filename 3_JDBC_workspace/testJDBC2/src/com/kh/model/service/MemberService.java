package com.kh.model.service;

import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection; // 여기도 JDBCTemplate을 안 쓰기 위해
import static com.kh.common.JDBCTemplate.rollback;
import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberService {
	// View <-> Controller <-> Service <-> DAO
	private MemberDAO mDAO = new MemberDAO();
	
	public ArrayList<Member> selectAll() {
		Connection conn = getConnection();
		ArrayList<Member> list = mDAO.selectAll(conn);
		return list;
	}

	public int insertMember(Member m) { //service는 첫 번째로 connection 받아오기
		Connection conn = getConnection();
		int result = mDAO.insertMember(conn, m);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public ArrayList<Member> selectMemberId(String id) {
		Connection conn = getConnection();
		ArrayList<Member> list = mDAO.selectMemberId(conn, id);
		return list;
	}

	public ArrayList<Member> selectGender(char gen) {
		Connection conn = getConnection();
		ArrayList<Member> list = mDAO.selectGender(conn, gen);
		
		return list;
	}

	public int checkMember(String memberId) {
		Connection conn = getConnection();
		int check = mDAO.checkMember(conn, memberId);
		
		return check;
	}

	public int updateMember(String memberId, String upStr, String input) {
		Connection conn = getConnection();
		int result = mDAO.updateMember(conn, memberId, upStr, input);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	public void exitProgram() {
		Connection conn = getConnection();
		close(conn);
	}

	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		int result = mDAO.deleteMember(conn, memberId);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}
}
