package com.increpas.cafe.controller.member;

import javax.servlet.http.*;

import com.increpas.cafe.controller.CafeController;

public class LoginForm implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/login";
		return view;
	}
}
