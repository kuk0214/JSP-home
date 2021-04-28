package com.increpas.cafe.controller.reboard;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.*;
import com.increpas.cafe.vo.*;

public class ReBoardList implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "reboard/reBoardList";
		ReBoardDao rDao = new ReBoardDao();
		ArrayList<BoardVO> list = rDao.getReBoardList();
		
		req.setAttribute("LIST", list);
		
		return view;
	}

}
