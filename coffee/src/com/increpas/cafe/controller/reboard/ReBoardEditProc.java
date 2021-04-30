package com.increpas.cafe.controller.reboard;

import java.util.*;

import javax.servlet.http.*;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.ReBoardDao;

public class ReBoardEditProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/reboard/reBoardList.cafe";
		req.setAttribute("isRedirect", true);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/cafe/member/login.cafe";
		}
		
		// 데이터 꺼내오고
		/*
			전달되는 파라미터를 알고 있는 경우는
				req.getParameter("키값");
			지금의 경우는 제목과 본문이 선택적으로 수정이되서 전송이 될 것이다.
			따라서 어떤 경우는 제목이, 어떤 경우는 본문이 없을 수도 있다.
			이런 경우는 전달되는 파라미터의 키값만 뽑아보면 알 수 있다.
				req.getParameterNames();
			이 함수는 전달되는 데이터의 키값만 추출해주는 함수이다.
			 
			Enumeration<String> en = req.getParameterNames(); while(en.hasMoreElements())
			{ System.out.println(en.nextElement()); }
			 
			
			Map<String, String[]> map = req.getParameterMap();
			Set<String> set = map.keySet();
			ArrayList<String> list = new ArrayList<String>(set);
			
			System.out.println("####" + map.get("rno")[0]);
			list.remove("rno");
			System.out.println(list.toString().replaceAll("\\[|\\]", "").replaceAll(",", " = ? ,") + " = ? ");
		
			[title, body]
			==>
				title = ?, body = ?
		 */
		
		
		Map<String, String[]> map = req.getParameterMap();
		 ReBoardDao rDao = new ReBoardDao();
		 int cnt = rDao.editReBRD(map);
		 String msg = "";
		 if(cnt != 1) {
			 msg = "?msg=fail";
		 }
		 
		return view + msg;
	}

}
