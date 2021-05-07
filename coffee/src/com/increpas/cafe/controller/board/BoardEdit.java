package com.increpas.cafe.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.BoardDao;
import com.increpas.cafe.vo.BoardVO;
import com.increpas.cafe.vo.FileVO;

public class BoardEdit implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "board/boardEdit";
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			req.setAttribute("isRedirect", true);
			return "/cafe/member/login.cafe";
		}
		String sno = req.getParameter("bno");
		int bno = Integer.parseInt(sno);
		
		BoardDao bDao = new BoardDao();
		BoardVO bVO = bDao.getBoardData(bno);
		
		req.setAttribute("DATA", bVO);
		return view;
	}

}
