package com.increpas.cafe.controller.member;


import javax.servlet.http.*;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.*;

public class LoginProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 할일
		// 0. 뷰 부르는 방식 설정하고...
		// 1. 파라미터 받고
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");

		// 2. 데이터 베이스 작업하고
		ClsMemberDao mDao = new ClsMemberDao();
		int cnt = mDao.getLogin(sid, spw);
		// 3. 결과에 따라 처리하고
		String view = "/cafe/main.cafe";
		if(cnt == 1) {
			// 로그인 처리하고
			req.getSession().setAttribute("SID", sid);
			// 뷰 부르는 방식 설정하고...
			req.setAttribute("isRedirect", true);
		} else {
			req.setAttribute("isRedirect", true);
			view = "/cafe/member/login.cafe?MSG=fail";
		}
		// 4. 뷰를 부르고
		
		
		
		return view;
	}

}
