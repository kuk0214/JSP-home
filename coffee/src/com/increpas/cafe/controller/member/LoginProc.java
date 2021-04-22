package com.increpas.cafe.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.cafe.controller.CafeController;
import com.increpas.coffee.dao.ClsMemberDao;

public class LoginProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/main.cafe";
		// 할일
		// 1. 파라미터 받고
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");

		// 2. dao 함수 호출하고
		ClsMemberDao mDao = new ClsMemberDao();
		int cnt = mDao.getLoginCnt(sid, spw);
		// 3. 결과에 따라 처리하고
		if(cnt == 1) {
			HttpSession session = req.getSession();
			session.setAttribute("SID", sid);
		} else {
			view = "login.cafe";
		}
		// 4. 뷰를 처리방식 선택하고
		req.setAttribute("isRedirect", true);
		// 5.
		/*
			이 경우 로그인에 성공하던지
			실패하던지 두 경우 모두 요청이 살아있으면 곤란한 경우이다
			따라서 두 경우 모두 리다이렉트 방식으로 뷰를 불러야 한다.
			리다이렉트 처리는 응답객체에서 처리해서
			새로운 요청을 만들어 준다.
		 */
		
		return view;
	}

}
