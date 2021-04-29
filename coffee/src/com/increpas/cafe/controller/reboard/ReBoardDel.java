package com.increpas.cafe.controller.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.ReBoardDao;

public class ReBoardDel implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "reBoardList.cafe";
		int rno = Integer.parseInt(req.getParameter("rno"));
		ReBoardDao rDao = new ReBoardDao();
		int cnt = rDao.delRBRD(rno);
		if(cnt != 1) {
			req.setAttribute("isRedirect", true);
			return "/cafe/reboard/reBoardList.cafe";
		}
		return view;
	}

}
