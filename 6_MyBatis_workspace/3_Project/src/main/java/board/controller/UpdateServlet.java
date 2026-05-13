package board.controller;

import java.io.IOException;

import board.model.service.BoardService;
import board.model.vo.Board;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updateBoard.bo")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		String title = request.getParameter("title");
		String isNotice = request.getParameter("isNotice") == null? "N" : "Y";
		String content = request.getParameter("content");
		
		Board b = new Board();
		b.setBoardNo(bId);
		b.setTitle(title);
		b.setIsNotice(isNotice);
		b.setContent(content);
		
		int result = new BoardService().updateBoard(b);
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/selectBoard.bo?bId=" + bId);
		} else {
			request.setAttribute("msg", "게시글 수정을 실패했습니다.");
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
