package com.kh.servlet;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestServlet2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식에서 영어나 숫자 데이터를 제외한 다른 데이터는 깨져서 넘어옴
		// 그래서 데이터 깨짐을 방지하기 위한 코드 필요
		// 단, 톰캣이 버전업이 되면서 굳이 아래 코드가 없어도 데이터 깨짐을 방지할 수 있게 되었음
		// (톰캣 하위 버전을 쓰게 되면 반드시 필요한 코드)
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String city = request.getParameter("city");
		String height = request.getParameter("height");
		String[] food = request.getParameterValues("food");
		
		System.out.println(name);
		System.out.println(gender);
		System.out.println(age);
		System.out.println(city);
		System.out.println(height);
		System.out.println(Arrays.toString(food));
		
		// setAttribute(String arg0, Object arg1) : arg0이라는 변수에 arg1이라는 데이터를 담겠다
		request.setAttribute("jName", name);
		request.setAttribute("jGender", gender);
		request.setAttribute("jAge", age);
		request.setAttribute("jCity", city);
		request.setAttribute("jHeight", height);
		request.setAttribute("jFood", String.join(", ", food));
		
		RequestDispatcher view = request.getRequestDispatcher("/servlet/testServlet2End.jsp");
		view.forward(request, response);
		// getRequestDispatcher에서의 / => context root (webapp)
		// form action에서의 / => context root보다 하나 앞 = 서버 루트(localhost:8000)
		
		
		
		
		
		
		
		
		
	}
}
