package com.increpas.coffee.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/member/logout.cls")
public class Logout extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 할일
		// 세션에 기록된 내용을 지워준다.
		// 1. Session을 꺼내온다.
		HttpSession session = req.getSession();
		// 2. 세션에 기록된 내용 지우고
		session.removeAttribute("SID");
		
		// 3. 뷰를 부른다.
		resp.sendRedirect("/cafe/main.cls");
	}
}
