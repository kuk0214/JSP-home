package com.increpas.cafe.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.coffee.dao.ClsMembDao;
import com.increpas.coffee.vo.MemberVO;

public class MyInfoEdit implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/member/myInfoEdit";
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/cafe/member/login.cafe";
		} else {
			ClsMembDao mDao = new ClsMembDao();
			
			MemberVO mVO = mDao.getLoginInfo(sid);
			
			req.setAttribute("DATA", mVO);
		}
		return view;
	}

}
