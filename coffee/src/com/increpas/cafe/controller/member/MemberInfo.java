package com.increpas.cafe.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.*;
import com.increpas.cafe.vo.*;
import com.increpas.cafe.dao.*;

public class MemberInfo implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "member/memberInfo";
		// 할일
		// 파라미터 받고
		String sno = req.getParameter("mno");
		// 형변환
		int mno = Integer.parseInt(sno);
		// 데이터베이스 작업하고
		MemberDao mDao = new MemberDao();
		MemberVO mVO = mDao.getMembInfo(mno);
		// 결과받아서 요청객체에 기억시키고
		req.setAttribute("DATA", mVO);
		
		// 뷰를 부르고		
		return view;
	}

}
