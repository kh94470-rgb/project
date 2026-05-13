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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		
		Employee e = new Employee();
		e.setEmpNO(id);
		e.setPwd(pwd);
		
		EmployeeService eService = new EmployeeService();
		Employee login = eService.login(e);
//		System.out.println(login);
		
		if(login != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", login);
			session.setMaxInactiveInterval(600); // 10분
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//			response.sendRedirect("index.jsp");
			// 		forward			vs		sendRedirect
			//    요청 url 유지			 요청 url 유지x -> 인자 값으로 url 변경
			//request, response 객체 유지	 request, response 객체 새로 생성
			//=> 데이터 그대로 담겨져있음		 => 데이터 모두 사라짐(request에 담긴)
			
			response.sendRedirect(request.getContextPath());
		} else {
			// 로그인 실패
			request.setAttribute("msg", "로그인을 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request,response);
			
			
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
