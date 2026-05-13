package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import board.model.service.BoardService;
import board.model.vo.Board;
import board.model.vo.Reply;
import employee.model.vo.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectBoardServlet
 */
@WebServlet("/selectBoard.bo")
public class SelectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BoardService bService = new BoardService();
		
		Employee loginUser = (Employee)request.getSession().getAttribute("loginUser");
		Integer empNo = null;
		if(loginUser != null) {
			empNo = loginUser.getEmpNO();
		}
		Board b = bService.selectBoard(bId, empNo);
		ArrayList<Reply> list = bService.selectReplyList(bId);
		if(b != null) {
			request.setAttribute("b", b);
			request.setAttribute("list", list);
			request.getRequestDispatcher("WEB-INF/views/board/boardDetail.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "해당 게시글은 존재하지 않습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
