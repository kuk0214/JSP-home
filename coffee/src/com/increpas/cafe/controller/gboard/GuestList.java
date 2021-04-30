package com.increpas.cafe.controller.gboard;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.*;
import com.increpas.cafe.dao.*;
import com.increpas.cafe.util.PageUtil;
import com.increpas.cafe.vo.*;

public class GuestList implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 뷰 변수 만들고
		String view = "gboard/gBoardList";
		
		String spage = req.getParameter("nowPage");
		int nowPage = 1; // 현재 보고있는 페이지 번호 ==> 0페이지는 없으므로 1페이지로 셋팅해준다.
		try {
			nowPage = Integer.parseInt(spage);
		} catch(Exception e) {
			nowPage = 1;
		}
		// 데이터베이스 작업해서 결과 받아오고
		GuestBoardDao gDao = new GuestBoardDao();
		int total = gDao.getTotalCount();
		PageUtil page = new PageUtil(nowPage, total);
		
		
		ArrayList<BoardVO> list = gDao.getGBoardList(page);
		String sid = (String) req.getSession().getAttribute("SID");
		int cnt = 0 ;
		if(sid != null) {
			cnt = gDao.getWriteCount(sid);				
		}
		// 데이터 뷰에 넘겨주고
		req.setAttribute("LIST", list);
		req.setAttribute("CNT", cnt);
		req.setAttribute("PAGE", page);
		// 뷰를 부르고...
		return view;
	}

}
