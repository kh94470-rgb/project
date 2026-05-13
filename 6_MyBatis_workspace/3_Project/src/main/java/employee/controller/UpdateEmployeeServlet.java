package employee.controller;

import java.io.IOException;

import employee.model.service.EmployeeService;
import employee.model.vo.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
@WebServlet("/updateEmp.me")
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 받아오기
		// 받아온 파라미터를 Employee e에 담기
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		int sal = Integer.parseInt(request.getParameter("sal"));
		int comm = request.getParameter("comm").equals("") ? 
					0 : Integer.parseInt(request.getParameter("comm"));
		int dept = Integer.parseInt(request.getParameter("dept"));
		
		
		HttpSession session = request.getSession();
		if(pwd.equals("")) {
			pwd = ((Employee)session.getAttribute("loginUser")).getPwd();
		}
		
		Employee e = new Employee(id, pwd, name, job, null, null, null, sal, comm, dept, null, null, null);
		
		EmployeeService service = new EmployeeService();
		int result = service.updateEmployee(e);
		
		if(result > 0) {
			Employee updateEmp = service.login(e);
			session.setAttribute("loginUser", updateEmp);
			session.setMaxInactiveInterval(600);
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("msg", "정보 수정을 실패하였습니다.");
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
