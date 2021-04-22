package com.increpas.cafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CafeMain implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "main";
		return view;
	}

}
