package com.increpas.coffee.j5;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/j5/addmemb.cls")
public class AddMemb extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 사용할 뷰 정의하고
		String view = "/WEB-INF/views/j5/addMemb.jsp";
		
		RequestDispatcher rd = req.getRequestDispatcher(view);
		try {
			rd.forward(req, resp);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
