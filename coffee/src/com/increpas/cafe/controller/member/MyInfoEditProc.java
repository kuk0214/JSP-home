package com.increpas.cafe.controller.member;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.*;
import com.increpas.cafe.dao.*;
import com.increpas.cafe.vo.*;

public class MyInfoEditProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		// 성공했을 경우 뷰 준비
		String view = "/cafe/member/myInfo.cafe";
		// 뷰 호출 방식 셋팅
		req.setAttribute("isRedirect", true);
		
		// 세션에서 아이디 꺼내고
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			view = "/cafe/member/login.cafe";
			return view;
		}
		
		Map<String, String[]> map = req.getParameterMap();
		MemberDao mDao = new MemberDao();
		int cnt = mDao.editMyInfo(map, sid);
		
		if(cnt == 1) {
			// 정보수정에 성공한 경우
			view = "/cafe/member/myInfo.cafe";
		} else {
			// 정보수정에 실패한 경우
			view = "/cafe/member/myInfoEdit.cafe";
		}
		
		return view;
	}

}
