package com.increpas.cafe.controller.board;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.BoardDao;
import com.increpas.cafe.vo.BoardVO;
import com.increpas.cafe.vo.FileVO;

public class BoardDetail implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "board/boardDetail";
		
		String sno = req.getParameter("bno");
		int bno = Integer.parseInt(sno);
		String spage = req.getParameter("nowPage");
		
		BoardDao bDao = new BoardDao();
		BoardVO bVO = bDao.getBnoInfo(bno);
		ArrayList<FileVO> list = bDao.getFileList(bno);
		
		
		req.setAttribute("nowPage", spage);
		req.setAttribute("DATA", bVO);
		req.setAttribute("LIST", list);
		
		return view;
	}

}
