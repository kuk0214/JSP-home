package com.increpas.cafe.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.cafe.controller.CafeController;
import com.increpas.coffee.dao.ClsMembDao;
import com.increpas.coffee.vo.MemberVO;

public class MyInfo implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String view = "/member/memberInfo";
		HttpSession session = req.getSession();
		
		String sid = (String) session.getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			view = "login.cafe";
		} else {
			ClsMembDao mDao = new ClsMembDao();
			
			MemberVO mVO = mDao.getLoginInfo(sid);
			
			req.setAttribute("DATA", mVO);
		}
		return view;
	}

}
