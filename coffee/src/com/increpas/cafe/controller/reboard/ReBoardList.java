package com.increpas.cafe.controller.reboard;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.*;
import com.increpas.cafe.util.PageUtil;
import com.increpas.cafe.vo.*;

public class ReBoardList implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "reboard/reBoardList";
		
		String spage = req.getParameter("nowPage");
		int nowPage = 1; // 현재 보고있는 페이지 번호 ==> 0페이지는 없으므로 1페이지로 셋팅해준다.
		try {
			nowPage = Integer.parseInt(spage);
		} catch(Exception e) {
			nowPage = 1;
		}
		
		ReBoardDao rDao = new ReBoardDao();
		// 총 게시물 수 꺼내오고
		int total = rDao.getTotalCount();
		// 총 게시물 수를 꺼내오면 이제 페이지 처리에 필요한 데이터가 모두 준비됬고
		// 페이지 처리에 필요한 객체를 만들어 준다.
		PageUtil page = new PageUtil(nowPage, total);
		
		ArrayList<BoardVO> list = rDao.getReBoardList(page);
		
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", page);
		
		return view;
	}

}
