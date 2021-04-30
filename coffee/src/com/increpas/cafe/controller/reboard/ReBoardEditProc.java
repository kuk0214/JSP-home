package com.increpas.cafe.controller.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;

public class ReBoardEditProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/reboard/reBoardList.cafe";
		req.setAttribute("isRedirect", true);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/cafe/member/login.cafe";
		}
		
		int rno = Integer.parseInt(req.getParameter("rno"));
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		
		return view;
	}

}
