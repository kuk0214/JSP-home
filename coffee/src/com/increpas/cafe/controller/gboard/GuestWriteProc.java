package com.increpas.cafe.controller.gboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.GuestBoardDao;
import com.increpas.cafe.vo.BoardVO;

public class GuestWriteProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		int writer = Integer.parseInt(req.getParameter("mno"));
		String body = req.getParameter("body");
		
		BoardVO gVO = new BoardVO();
		gVO.setMno(writer);
		gVO.setBody(body);
		
		GuestBoardDao gDao = new GuestBoardDao();
		int cnt = gDao.addGBRD(gVO);
		String view = "/cafe/gboard/gBoardList.cafe";
		if(cnt == 1) {
			req.setAttribute("isRedirect", true);
		} else {
			view = "redirectPage";
			req.setAttribute("WMSG", "fail");
		}
		return view;
	}
}
