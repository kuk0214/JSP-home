package com.increpas.cafe.controller.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.GuestBoardDao;
import com.increpas.cafe.vo.MemberVO;

public class ReBoardWrite implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/reboard/reBoardWrite";
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/cafe/member/login.cafe";
			req.setAttribute("isRedirect", true);
		}
		GuestBoardDao gDao = new GuestBoardDao();
		MemberVO mVO = gDao.getMemberData(sid);
		req.setAttribute("DATA", mVO);
		return view;
	}

}
