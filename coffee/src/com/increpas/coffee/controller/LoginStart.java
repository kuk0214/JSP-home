package com.increpas.coffee.controller;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/member/login.cls2")
public class LoginStart extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/WEB-INF/views/member/login.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(view);
		try {
			rd.forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
