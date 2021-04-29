package com.increpas.cafe.controller.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.ReBoardDao;
import com.increpas.cafe.vo.BoardVO;

public class ReBoardReplyProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/reboard/reBoardList.cafe";
		req.setAttribute("isRedirect", true);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/cafe/member/login.cafe";
		}
		BoardVO rVO = new BoardVO();
		rVO.setTitle(req.getParameter("title"));
		rVO.setBody(req.getParameter("body"));
		rVO.setMno(Integer.parseInt(req.getParameter("mno")));
		rVO.setUpno(Integer.parseInt(req.getParameter("upno")));
		
		ReBoardDao rDao = new ReBoardDao();
		int cnt = rDao.addReply(rVO);
		if(cnt != 1) {
			
		}
		
		return view;
	}

}
