package com.increpas.coffee.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/Test01")
public class Test01 extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/WEB-INF/views/Test01.jsp";
		
		RequestDispatcher rd = req.getRequestDispatcher(view);
		try {
			rd.forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
