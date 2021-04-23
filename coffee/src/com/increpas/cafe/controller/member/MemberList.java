package com.increpas.cafe.controller.member;

import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


import com.increpas.cafe.controller.*;
import com.increpas.cafe.dao.*;
import com.increpas.cafe.vo.*;

public class MemberList implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 할일
		// 1. 이 요청은 우리의 경우 회원 로그인에 성공한 사람만 사용 할 수 있는 기능이므로
		// 		로그인이 되어있는지 체크한다.
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			// 로그인 안한 경우이므로 로그인 페이지로 돌려보낸다.
			req.setAttribute("isRedirect", true);
			return "/cafe/member/login.cafe"; 
		}
		
		// 이 행을 실행하는 경우는 로그인한 경우이므로
		// 데이터베이스에서 회원리스트를 꺼내온다.
		MemberDao mDao = new MemberDao();
		ArrayList<MemberVO> list = mDao.getMembList();
		
		// 생산된 데이터를 요청객체에 추가하고
		req.setAttribute("LIST", list);
		
		// 뷰 부르고...
		return "member/memberList";
	}

}
