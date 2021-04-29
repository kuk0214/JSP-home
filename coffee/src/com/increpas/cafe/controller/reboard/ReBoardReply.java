package com.increpas.cafe.controller.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.GuestBoardDao;
import com.increpas.cafe.vo.MemberVO;

public class ReBoardReply implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 뷰 설정하고
		String view = "reboard/reBoardReply";
		
		// 세션 검사하고
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/cafe/member/login.cafe";
		}
		
		GuestBoardDao gDao = new GuestBoardDao();
		MemberVO mVO = gDao.getMemberData(sid);
		// 파라미터 꺼내고
		String tno = req.getParameter("upno");
		String title = req.getParameter("title");
		// 데이터 전달하고
		req.setAttribute("UPNO", tno);
		req.setAttribute("UPTITLE", title);
		req.setAttribute("DATA", mVO);
		
		return view;
	}

}
