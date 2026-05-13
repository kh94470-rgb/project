package employee.controller;

import java.io.IOException;
import java.util.HashMap;

import employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStateServlet
 */
@WebServlet("/updateState.me")
public class UpdateStateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// ajax에서 보낸 파라미터 받아오기
		int id = Integer.parseInt(request.getParameter("empNo"));
		String col = request.getParameter("column").equals("관리자") ? "is_admin" : "status";
		String value = request.getParameter("value");
		
		System.out.println(id);
		System.out.println(col);
		System.out.println(value);
		
		HashMap<String, Object> datas = new HashMap<String, Object>();
		datas.put("id", id);
		datas.put("col", col);
		datas.put("val", value);
//		int result = new EmployeeService().updateState(id, col, value);
		int result = new EmployeeService().updateState(datas);
		
		response.getWriter().print(result == 1 ? "success" : "fail");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
