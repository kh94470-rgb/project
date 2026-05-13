package board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import board.model.vo.Board;
import board.model.vo.Reply;
import common.model.vo.PageInfo;

public class BoardDAO {

	public int getListCount(SqlSession session) {
		return session.selectOne("boardMapper.getListCount");
	}

	public ArrayList<Board> selectBoardList(SqlSession session, PageInfo pi) {
		// offset : 건너 뛸 게시글 수
		// limit : 선택할 게시글 수
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)session.selectList("boardMapper.selectBoardList", null, rowBounds);
	}

	public int insertBoard(SqlSession session, Board b) {
		return session.insert("boardMapper.insertBoard", b);
	}

	public Board selectBoard(SqlSession session, int bId) {
		return session.selectOne("boardMapper.selectBoard", bId);
	}

	public int updateCount(SqlSession session, int bId) {
		return session.update("boardMapper.updateCount", bId);
	}

	public ArrayList<Reply> selectReplyList(SqlSession session, int bId) {
		return (ArrayList)session.selectList("boardMapper.selectReplyList", bId);
	}

	public int updateBoard(SqlSession session, Board b) {
		return session.update("boardMapper.updateBoard", b);
	}

	public int deleteBoard(SqlSession session, int bId) {
		return session.update("boardMapper.deleteBoard", bId);
	}

	public int getSearchListCount(SqlSession session, HashMap<String, String> map) {
		return session.selectOne("boardMapper.searchListCount", map);
	}

	public ArrayList<Board> selectSearchList(SqlSession session, HashMap<String, String> map, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)session.selectList("boardMapper.selectSearchList", map, rowBounds);
	}

	public int insertReply(SqlSession session, Reply r) {
		return session.update("boardMapper.insertReply", r);
	}

}
