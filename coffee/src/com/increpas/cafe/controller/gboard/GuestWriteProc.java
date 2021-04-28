package com.increpas.cafe.controller.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.GuestBoardDao;
import com.increpas.cafe.vo.BoardVO;

public class GuestWriteProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/gboard/gBoardList.cafe";
		req.setAttribute("isRedirect", true);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/cafe/member/login.cafe";
		}
		
		int writer = Integer.parseInt(req.getParameter("mno"));
		String body = req.getParameter("body");
		
		BoardVO gVO = new BoardVO();
		gVO.setMno(writer);
		gVO.setBody(body);
		
		GuestBoardDao gDao = new GuestBoardDao();
		int cnt = gDao.addGBRD(gVO);
		if(cnt != 1) {
			view = "redirectPage";
			req.setAttribute("WMSG", "fail");
			req.setAttribute("isRedirect", false);
		}
		
		return view;
	}
}
