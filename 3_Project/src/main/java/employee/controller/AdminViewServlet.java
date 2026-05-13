package employee.controller;

import java.io.IOException;
import java.util.ArrayList;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminViewServlet
 */
@WebServlet("/admin.me")
public class AdminViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Employee loginUser = (Employee)session.getAttribute("loginUser");
		System.out.println(loginUser);
		
		if(loginUser != null && loginUser.getIsAdmin().equals("Y")) {
			
			ArrayList<Employee> list = new EmployeeService().selectAll();
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("WEB-INF/views/employee/admin.jsp").forward(request, response);
		} else {
			// 메세지에 "잘못된 접근입니다"를 담고서 errorPage.jsp로 위임
			request.setAttribute("msg", "잘못된 접근입니다");
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
