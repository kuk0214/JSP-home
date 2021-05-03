package com.increpas.cafe.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.BoardDao;

public class BoardWriteProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/board/board.cafe";
		req.setAttribute("isRedirect", true);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/cafe/member/login.cafe";
		}
		
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		
		BoardDao bDao = new BoardDao();
		int cnt = 0;
		cnt = bDao.addBoard(sid, title, body);
		if(cnt != 1) {
			return "/cafe/board/boardWrite";
		}
		return view;
	}

}
