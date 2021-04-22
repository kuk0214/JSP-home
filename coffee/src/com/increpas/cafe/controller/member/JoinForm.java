package com.increpas.cafe.controller.member;


import javax.servlet.http.*;

import com.increpas.cafe.controller.CafeController;

public class JoinForm implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/join";
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
