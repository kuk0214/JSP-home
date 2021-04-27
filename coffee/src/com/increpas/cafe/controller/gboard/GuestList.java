package com.increpas.cafe.controller.gboard;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.*;
import com.increpas.cafe.dao.*;
import com.increpas.cafe.vo.*;

public class GuestList implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 뷰 변수 만들고
		String view = "gboard/gBoardList";
		
		// 데이터베이스 작업해서 결과 받아오고
		GuestBoardDao gDao = new GuestBoardDao();
		ArrayList<BoardVO> list = gDao.getGBoardList();
		String sid = (String) req.getSession().getAttribute("SID");
		int cnt = 0 ;
		if(sid != null) {
			cnt = gDao.getWirteCount(sid);				
		}
		// 데이터 뷰에 넘겨주고
		req.setAttribute("LIST", list);
		req.setAttribute("CNT", cnt);
		// 뷰를 부르고...
		return view;
	}

}
