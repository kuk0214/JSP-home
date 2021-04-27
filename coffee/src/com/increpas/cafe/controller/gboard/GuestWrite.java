package com.increpas.cafe.controller.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.*;
import com.increpas.cafe.vo.*;

public class GuestWrite implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "gboard/gBoardWrite";
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/cafe/member/login.cafe";
			req.setAttribute("isRedirect", true);
		}
		
		GuestBoardDao gDao = new GuestBoardDao();
		MemberVO mVO = gDao.getMemberData(sid);
		
		// 뷰에 데이터 심고
		req.setAttribute("DATA", mVO);
		return view;
	}

}
