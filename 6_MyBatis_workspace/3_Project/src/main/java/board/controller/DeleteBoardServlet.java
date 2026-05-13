package board.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;

import board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet("/deleteBoard.bo")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String encode = request.getParameter("bId");
		Decoder decoder = Base64.getDecoder();
		byte[] bArr = decoder.decode(encode); // 복호화(디코딩)
		int bId = Integer.parseInt(new String(bArr));
		
		int result = new BoardService().deleteBoard(bId);
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/list.bo");
		} else {
			request.setAttribute("msg", "게시글 삭제를 실패하였습니다.");
			request.getRequestDispatcher("WEB-INF/views/comon/errorPage.jsp").forward(request, response);
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
