package com.increpas.cafe.controller.reboard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.ReBoardDao;
import com.increpas.cafe.vo.BoardVO;

public class ReBoardEdit implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/cafe/member/login.cafe";
		}
		
		int rno = Integer.parseInt(req.getParameter("rno"));
		BoardVO rVO = new BoardVO();
		rVO.setId(sid);
		rVO.setRno(rno);
		
		ReBoardDao rDao = new ReBoardDao();
		rDao.getBoardRno(rVO);
		
		req.setAttribute("DATA", rVO);
		String view = "reboard/reBoardEdit";
		
		return view;
	}

}
