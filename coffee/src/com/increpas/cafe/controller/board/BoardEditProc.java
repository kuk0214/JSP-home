package com.increpas.cafe.controller.board;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.BoardDao;

public class BoardEditProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/board/board.cafe";
		req.setAttribute("isRedirect", true);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "cafe/member/login.cafe";
		}
		String sno = req.getParameter("bno");
		int bno = Integer.parseInt(sno);
		
		Map<String, String[]> map = req.getParameterMap();
		
		Set<String> set = map.keySet();
		ArrayList<String> list = new ArrayList<String>(set);
		list.remove("nowPage");
		list.remove("bno");
		String str = list.toString().replaceAll("\\[|\\]", "").replaceAll(",", " = ? , ") + " = ? ";
		System.out.println(str);
		System.out.println(map.get(list.get(0))[0]);
		System.out.println(map.get(list.get(1))[0]);
		System.out.println(bno);
		
		BoardDao bDao = new BoardDao();
		int cnt = bDao.editBRD(bno, map);
		
		if(cnt == 0) {
			req.setAttribute("isRedirect", null);
			return "/cafe/board/boardEdit.cafe";
		}
		
		return view;
	}

}
