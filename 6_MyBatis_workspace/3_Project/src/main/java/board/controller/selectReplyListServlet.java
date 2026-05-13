package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import board.model.service.BoardService;
import board.model.vo.Reply;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class selectReplyListServlet
 */
@WebServlet("/selectReplyList.bo")
public class selectReplyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectReplyListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bId = Integer.parseInt(request.getParameter("bId"));
		ArrayList<Reply> list = new BoardService().selectReplyList(bId);
//		response.getWriter().print(list);
		
		response.setContentType("application/json; charset=UTF-8");
		JSONArray array = new JSONArray();
		for(Reply r : list) {
			JSONObject json = new JSONObject();
			json.put("replyNo", r.getReplyNo());
			json.put("content", r.getContent());
			json.put("empNo", r.getEmpNo());
			json.put("writer", r.getWriter());
			json.put("cDate", r.getCreateDate()+"");
			json.put("uDate", r.getUpdateDate()+"");
			json.put("refBoard", r.getRefBoard());
			json.put("status", r.getStatus());
			
			array.add(json);
		}
		
		response.getWriter().print(array);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
