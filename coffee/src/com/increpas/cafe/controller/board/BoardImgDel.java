package com.increpas.cafe.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.BoardDao;

public class BoardImgDel implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 이 컨트롤러는 비동기 통신으로 요청되는 요청을 처리하는 클래스
		req.setAttribute("isRedirect", null);
		
		// 전송되는 데이터 꺼낸다.
		String sno = req.getParameter("fno");
		int fno = Integer.parseInt(sno);
		
		BoardDao bDao = new BoardDao();
		int cnt = bDao.delFile(fno);
		
		StringBuffer buff = new StringBuffer();
		String result = "";
		buff.append("{");
		if(cnt != 1) {
			result = "NO";
		} else {
			result = "YES";
		}
		
		buff.append(" \"result\": \""+ result + "\"");
		buff.append("}");
		
		return buff.toString();
	}

}
