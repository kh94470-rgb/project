package el.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import person.model.vo.Person;

public class ELServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("잘 들어오나");
		// 1. 콘솔에 "잘 들어오나" 찍어보기
		// 2. 이름~영화 데이터 받아오기
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		char gender = request.getParameter("gender").charAt(0);
		int age = Integer.parseInt(request.getParameter("age"));
		String beverage = request.getParameter("beverage");
		String[] products = request.getParameterValues("product");
		String book = request.getParameter("book");
		String movie = request.getParameter("movie");
		
		Person who = new Person(name, gender, age);
		
		// request 영역
		request.setAttribute("p", who);
		request.setAttribute("beverage", beverage);
		request.setAttribute("products", products);
		request.setAttribute("year", 2026);
		
		// session 영역
		HttpSession session = request.getSession();
		session.setAttribute("book", book);
		
		// application 영역
		ServletContext application = request.getServletContext();
		application.setAttribute("movie", movie);
		
		RequestDispatcher view = request.getRequestDispatcher("/el/01_2_elEnd.jsp");
		view.forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
