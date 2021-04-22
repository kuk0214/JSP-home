package com.increpas.coffee.j05;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class MemberInfo2 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 사용할 뷰 정의하고
		String view = "/WEB-INF/views/j05/memberInfo2.jsp";
		
		RequestDispatcher rd = req.getRequestDispatcher(view);
		try {
			rd.forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
