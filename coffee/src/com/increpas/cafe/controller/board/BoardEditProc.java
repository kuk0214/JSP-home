package com.increpas.cafe.controller.board;

import java.util.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.increpas.cafe.controller.CafeController;
import com.increpas.cafe.dao.BoardDao;
import com.increpas.cafe.vo.FileVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardEditProc implements CafeController {
	BoardDao bDao = new BoardDao();
	boolean isNotEmpty = false;
	
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/board/boardDetail.cafe";
		req.setAttribute("isRedirect", true);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "cafe/member/login.cafe";
		}
		
		int cnt = 0;
		String path = req.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\img\\upload");
		MultipartRequest multi = null;
		String sno = "";
		String spage = "";
		try {
			multi = new MultipartRequest(req, path, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
			editProc(multi);
			
			sno = multi.getParameter("bno");
			spage = multi.getParameter("nowPage");
			cnt = editProc(multi);
			if(cnt == 0 && isNotEmpty) {
				view = "/cafe/board/boardEdit.cafe";
				return view;
			}
			
			cnt = addImg(multi);
		} catch(Exception e) {
			System.out.println("### 파일 업로드 에러....!");
		}
		
		
		
		
		return view  + "?bno=" + sno + "&nowPage=" + spage;
	}
	
	public int editProc(MultipartRequest multi) {
		int cnt = 0;
		String sno = multi.getParameter("bno");
		int bno = Integer.parseInt(sno);
		
		Enumeration<String> en = (Enumeration<String>) multi.getParameterNames();
		ArrayList<String> list = new ArrayList<String>();
		while(en.hasMoreElements()) {
			list.add(en.nextElement());
		}
		
		list.remove("nowPage");
		list.remove("bno");
		
		if(list.size() != 0) {
			isNotEmpty = true;
			
			String tmp = "";
			for(int i = 0 ; i < list.size() ; i++ ) {
				tmp = tmp + list.get(i) + " = '" + multi.getParameter(list.get(i)) + "' ";
				if(i < list.size() - 1) {
					tmp = tmp + ", ";
				}
			}
			cnt = bDao.editBRD(bno, tmp);
		}
		
		return cnt;
	}
	
	// 이미지 추가 처리 함수
	public int addImg(MultipartRequest multi) {
		int cnt = 0;
		String sno = multi.getParameter("bno");
		int bno = Integer.parseInt(sno);
		Enumeration<String> en = (Enumeration<String>) multi.getFileNames();
		while(en.hasMoreElements()) {
			FileVO fVO = new FileVO();
			String key = (String) en.nextElement();
			// 업로드된 원래 파일이름을 알아낸다.
			String oriname = multi.getOriginalFileName(key);
			// oriname 이 없는 경우는 파일 태그에서 파일을 선택하지 않은 경우이므로
			// 다음 키값으로 진행해서 다음 파일을 처리한다.
			if(oriname == null) {
				continue;
			}
			
			String savename = multi.getFilesystemName(key);
			long len = multi.getFile(key).length();
			
			fVO.setBno(bno);
			fVO.setOriname(oriname);
			fVO.setSavename(savename);
			fVO.setLen(len);
			
			cnt = bDao.addFileInfo(fVO);
		}
		return cnt;
	}
}
