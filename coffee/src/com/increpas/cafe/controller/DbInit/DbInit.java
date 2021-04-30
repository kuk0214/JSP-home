package com.increpas.cafe.controller.DbInit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;

public class DbInit implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		return "dbinit/dbinit";
	}

}
