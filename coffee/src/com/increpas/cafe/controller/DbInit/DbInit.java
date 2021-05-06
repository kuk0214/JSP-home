package com.increpas.cafe.controller.DbInit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.DbInitDao;

public class DbInit implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		
		int cnt = 1;
		DbInitDao dDao = new DbInitDao();
		cnt = dDao.addTable();

		if(cnt == 0) {
			req.setAttribute("MSG", "success");
		}
		
		return "dbinit/dbinit";
	}

}
