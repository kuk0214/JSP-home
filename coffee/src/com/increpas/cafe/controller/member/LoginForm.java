package com.increpas.cafe.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.increpas.cafe.controller.CafeController;

public class LoginForm implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "member/login";
		return view;
	}
}
