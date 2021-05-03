package com.increpas.cafe.controller.board;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.BoardDao;
import com.increpas.cafe.util.PageUtil;
import com.increpas.cafe.vo.BoardVO;

public class BoardList implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/board/boardList";
		// 파라미터 받고
		String spage = req.getParameter("nowPage");
		int nowPage = 1;
		try {
			nowPage = Integer.parseInt(spage);
		} catch(Exception e) {
			// spage를 정수로 변환할 때 에러가 발생하는 경우는
			// nowPage를 파라미터로 전달하지 않은 경우이다.
			// 이때는 1페이지로 보여지게 처리해주자.
		}
		
		// 페이징 처리를 위해서는 필수적으로 필요한 데이터가 두가지가 있는데
		// nowPage와 게시물의 총갯수는 반드시 필요하다.
		// 따라서 게시물의 총갯수를 조회하자.
		BoardDao bDao = new BoardDao();
		int total = bDao.getTotal();
		
		PageUtil page = new PageUtil(nowPage, total, 5, 5);
		
		ArrayList<BoardVO> list = bDao.getList(page);
		req.setAttribute("LIST", list);
		/*
			==> 이렇게 속성에 데이터를 추가해주면
				jsp에서 사용할 때는 원칙적으로는
				${requestScope.속성이름}
				그런데 requestScope와 sessionScope의 속성은
				스코프 이름을 생략해도 꺼내올수 있도록 처리해 놓았다.
		 */
		req.setAttribute("PAGE", page);
		return view;
	}

}
