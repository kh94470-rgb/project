package board.model.service;

import static common.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.BoardDAO;
import board.model.vo.Board;
import board.model.vo.Reply;
import common.model.vo.PageInfo;

public class BoardService {
	
	private BoardDAO bDAO = new BoardDAO();

	public int getListCount() {
		SqlSession session = getSqlSession();
		int listCount = bDAO.getListCount(session);
		return listCount;
	}

	public ArrayList<Board> selectBoardList(PageInfo pi) {
		SqlSession session = getSqlSession();
		ArrayList<Board> list = bDAO.selectBoardList(session, pi);
		session.close();
		return list;
	}

	public int insertBoard(Board b) {
		SqlSession session = getSqlSession();
		int result = bDAO.insertBoard(session, b);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		return result;
	}

	public Board selectBoard(int bId, Integer empNo) {
		SqlSession session = getSqlSession();
		Board b = bDAO.selectBoard(session, bId);
		if(b != null) {
			if(empNo != null && b.getEmpNo() != empNo) {
				int result = bDAO.updateCount(session, bId);
				if(result > 0) {
					session.commit();
					b.setCount(b.getCount() + 1);
				} else {
					session.rollback();
				}
			}
		}
		
		return b;
	}

	public ArrayList<Reply> selectReplyList(int bId) {
		SqlSession session = getSqlSession();
		ArrayList<Reply> list = bDAO.selectReplyList(session, bId);
		return list;
	}

	public int updateBoard(Board b) {
		SqlSession session = getSqlSession();
		int result = bDAO.updateBoard(session, b);
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		return result;
	}

	public int deleteBoard(int bId) {
		SqlSession session = getSqlSession();
		int result = bDAO.deleteBoard(session, bId);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		return result;
	}

	public int getSearchListCount(HashMap<String, String> map) {
		SqlSession session = getSqlSession();
		int listCount = bDAO.getSearchListCount(session, map);
		session.close();
		return listCount;
	}

	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession session = getSqlSession();
		ArrayList<Board> list = bDAO.selectSearchList(session, map, pi);
		session.close();
		return list;
	}

	public int insertReply(Reply r) {
		SqlSession session = getSqlSession();
		int result = bDAO.insertReply(session, r);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		return result;
	}

}
