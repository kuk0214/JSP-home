package com.increpas.cafe.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.increpas.cafe.controller.CafeController;
import com.increpas.coffee.dao.ClsMemberDao;
import com.increpas.coffee.vo.MemberVO;

public class JoinProc implements CafeController {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp)  {
		String sname = req.getParameter("name");
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		String smali = req.getParameter("mail");
		String stel = req.getParameter("tel");
		String sgen = req.getParameter("gen");
		String savt = req.getParameter("avt");
		int ano = Integer.parseInt(savt) + 10;
		
		MemberVO mVO = new MemberVO();
		mVO.setName(sname);
		mVO.setId(sid);
		mVO.setPw(spw);
		mVO.setMail(smali);
		mVO.setTel(stel);
		mVO.setGen(sgen);
		mVO.setAno(ano);
		
		ClsMemberDao mDao = new ClsMemberDao();
		int cnt = mDao.addMemb(mVO);
		
		String view = "/cafe/main.cafe";
		if(cnt == 1) {
			HttpSession session = req.getSession();
			session.setAttribute("SID", sid);
		} else {
			view = "redirectPage";
			req.setAttribute("JOINMSG", "fail");
		}
		
		return view;
	}

}
