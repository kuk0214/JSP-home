package com.increpas.coffee.controller.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/member/login.cls")
public class LoginForm extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		/*
			이 서블릿의 역할은 단지 로그인 폼만 보여주면 된다.
			
			이 서블릿은 /member/login.cls로 요청이 들어오면
			요청은 남겨두고 보이는 화면만
			login.jsp 로 바꿔서 응답해주면 된다.
			따라서 forward 방식으로 뷰를 불러야겠다.
		 */
		
		// 먼저 로그인 한 회원인지 아닌지 확인한다.
		HttpSession session = req.getSession();
		Object o = session.getAttribute("SID");
		if(o != null) {
			// 이 경우는 이미 로그인 한 경우이므로
			// 메인 페이지로 리다이렉트 시킨다.
			try {
				resp.sendRedirect("/cafe/main.cls");
			} catch(Exception e) {
				e.printStackTrace();
			}
			return;
		}
		String view = "/WEB-INF/views/member/login.jsp";
		
		// RequestDispatcher 를 만들고 거기서 forward()를 호출하면 된다.
		RequestDispatcher rd = req.getRequestDispatcher(view);
		try {
			rd.forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
