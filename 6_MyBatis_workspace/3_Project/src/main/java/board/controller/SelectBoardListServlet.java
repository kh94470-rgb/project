package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import board.model.service.BoardService;
import board.model.vo.Board;
import common.Pagination;
import common.model.vo.PageInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectBoardListServlet
 */
@WebServlet("/list.bo")
public class SelectBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService service = new BoardService();
		
		int currentPage = 1;
		if(request.getParameter("page") != null) {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int listCount = service.getListCount(); // 전체 게시글 개수
//		System.out.println(listCount);
		// employee-mapper.xml (사원 관련 mapper) : 사용 x
		//	ㄴ empMapper
		// board-mapper.xml (게시판 관련 mapper) : 새로 생성
		//  ㄴ boardMapper
		
		PageInfo pi = Pagination.getPageInfo(currentPage, listCount);
		ArrayList<Board> list = service.selectBoardList(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/board/boardList.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
