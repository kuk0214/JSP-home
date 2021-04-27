package com.increpas.cafe.controller.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;

public class GuestWrite implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "gboard/gBoardWrite";
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/cafe/member/login.cafe";
			req.setAttribute("isRedirect", true);
		}
		return view;
	}

}
