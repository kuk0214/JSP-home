package com.increpas.coffee.controller.member;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/member/join.cls")
public class JoinForm extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		// 뷰 변수 만들고
		String view = "/WEB-INF/views/member/join.jsp";
		
		// 만약 이미 로그인한 회원이 이 페이지를 호출하는 경우
		// 메인페이지로 다시 보낸다.
		HttpSession session = req.getSession();
		if(session.getAttribute("SID") != null) {
			resp.sendRedirect("/cafe/main.cls");
			return;
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
