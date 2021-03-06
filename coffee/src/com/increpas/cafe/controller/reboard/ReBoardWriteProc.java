package com.increpas.cafe.controller.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.ReBoardDao;
import com.increpas.cafe.vo.BoardVO;

public class ReBoardWriteProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/reboard/reBoardList.cafe";
		req.setAttribute("isRedirect", true);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/cafe/member/login.cafe";
		}
		BoardVO rVO = new BoardVO();
		rVO.setMno(Integer.parseInt(req.getParameter("mno")));
		rVO.setTitle(req.getParameter("title"));
		rVO.setBody(req.getParameter("body"));
		ReBoardDao rDao = new ReBoardDao();
		int cnt = 0;
		cnt = rDao.addReBRD(rVO);
		if(cnt != 1) {
			view = "/cafe/reboard/reBoardWrite";
		}
		return view;
	}

}
