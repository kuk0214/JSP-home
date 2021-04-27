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
		
		String pw = req.getParameter("pw");
		String mail = req.getParameter("mail");
		String tel = req.getParameter("tel");
		String avt = req.getParameter("avt");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		// map 에 데이터 담고
		int no = 1;
		
		if(pw != null) {
			map.put(no++ + "pw", pw);
		}
		
		if(mail != null) {
			map.put(no++ + "mail", mail);
		}
		
		if(tel != null) {
			map.put(no++ + "tel", tel);
		}
		
		if(avt != null) {
			map.put(no++ + "avt", Integer.parseInt(avt));
		}
		map.put(no++ + "sid", sid);
		
		
		MemberDao mDao = new MemberDao();
		int cnt = mDao.editMyInfo(map);
		
		if(cnt == 1) {
			view = "/cafe/member/myInfo.cafe";
		} else {
			view = "/cafe/member/myInfoEdit.cafe";
		}
		
		return view;
	}

}
