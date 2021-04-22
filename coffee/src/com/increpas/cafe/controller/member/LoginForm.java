package com.increpas.cafe.controller.member;

import javax.servlet.http.*;

import com.increpas.cafe.controller.CafeController;

public class LoginForm implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/login";
		if(req.getSession().getAttribute("SID") != null) {
			req.setAttribute("isRedirect", true);
			view = "/cafe/main.cafe";
		}
		
		if(req.getParameter("msg") != null) {
			req.setAttribute("MSG", req.getParameter("msg"));
		}
		
		return view;
	}
}
