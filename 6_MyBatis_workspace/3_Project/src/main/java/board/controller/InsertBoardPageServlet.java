package board.controller;

import java.io.IOException;

import board.model.service.BoardService;
import board.model.vo.Board;
import employee.model.vo.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertBoardPageServlet
 */
@WebServlet("/insertBoard.bo")
public class InsertBoardPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String isNotice = request.getParameter("isNotice") == null ? "N" : "Y";
		String content = request.getParameter("content");
		int empNo = ((Employee)request.getSession().getAttribute("loginUser")).getEmpNO();
		
		Board b = new Board();
		b.setTitle(title);
		b.setIsNotice(isNotice);
		b.setContent(content);
		b.setEmpNo(empNo);
		
		int result = new BoardService().insertBoard(b);
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/list.bo");
		} else {
			request.setAttribute("msg", "게시글 등록을 실패했습니다.");
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
