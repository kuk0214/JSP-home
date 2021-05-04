package com.increpas.cafe.controller.board;

import java.io.*;
import java.util.*;

import javax.servlet.http.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

import com.increpas.cafe.controller.*;
import com.increpas.cafe.dao.*;
import com.increpas.cafe.vo.*;

public class BoardWriteProc implements CafeController {
/*
	이 컨트롤러는 지금까지의 컨트롤러와는 조금 다르다.
	지금 까지는 파라미터 방식으로 데이터가 전달되므로
		req.getParmeter();
	로 데이터를 꺼내면 됬지만
	
	지금은 파라미터 방식이 아닌 스트림 방식으로 데이터가 전달되기 때문에
	받는 방식도 스트림 방식으로 바꿔서 처리해야 한다.
	
	요근래는 스트림 방식으로 처리해주는 라이브러리가 많이 보급이 되어있다.
	우리의 경우 cos.jar를 이용할 것이고 이 경우 
		MultipartRequest 라는 클래스가 그 역할을 담당한다.
	
	사용 방법 ]
		new MutipartRequest(req, 자정경로, 업로드파일의 최대크기,
								인코딩 방식, 파일 이름이 충돌날 경우 정책);
								
	이 클래스를 new 시키면
		1. byte[] 로 전송된 데이터가 우리가 사용하기 편하도록
			파라미터 방식으로 변환시켜준다.
		2. 이 클래스만의 특징으로 파일 업로드 기능이 완성된다.
			즉, 서버의 지정한 디렉토리에 파일이 저장된다.
	2번의 문제 때문에 가장 중요한 기능이 저장 경로를 지정하는 것이다.
	2) 저장경로를 만드는 방법
	==> 저장 파일의 사용 목적에 따라서 경로가 달라진다. 
		1. 다운로드만을 위해서 저장한다면...
			아무데나 저장해도 된다.
			
			예 ]
				String path = "D:\\upload";
				
		2. 화면에 사용하기 위해서 저장해야 한다면
		 	반드시 리얼패스(실제 실행겨로) 를 찾아서 저장해야 한다.
		 
		 	예 ]
		 		String path = req.getSession().getServletContext().getRealPath("upload");
 		
	나머지 매개변수
	3) 업로드 최대크기
		==> 바이트 단위로 지정한다.
		
		예 ]
			int size = 1024 * 1024 * 1024 * 10 ; ==> 10Gb
			
			참고 ]
				1KByte = 1024Byte
				1MegaByte = 1024KByte
				1GByte = 1024MByte
				1TByte = 1024GByte
				1PByte = 1024TByte
				
	4) 인코딩 방식
		파일의 이름이 한글인 경우 파일의 이름이 깨질 수 있다.
		이런 경우를 대비해서 한글 파일의 이름을 복구할 인코딩 방식을 지정하는 것
		
		예 ]
			encoding="utf-8";
	
	5) 이름이 중복되는 경우 해결하는 정책
		이것은 한가지 방법만 기본적으로 제공되고 있다.
		파일 이름뒤에 (1), (2) 등의 숫자를 이용해서 변경하는 방식이다.
			
			DefaultFileRenamePolicy p = new DefaultFileRenamePolicy();
 */
	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/cafe/board/board.cafe";
		req.setAttribute("isRedirect", true);
		String sid = (String) req.getSession().getAttribute("SID");
		if(sid == null) {
			return "/cafe/member/login.cafe";
		}
		
		// 스트림으로 전송된 데이터를 파라미터 방식으로 변환시킨다.
		String path = req.getSession().getServletContext().getRealPath("\\WEB-INF\\resources\\img\\upload");
		/*
			이 방식으로 저장경로를 지정하는 경우 장점
				개발환경과 실제 서비스 환경에서 경로를 수정하지 않고 사용할 수 있다.
		 */
//		System.out.println("######### realPath : " + path);
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(req, path, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());
			/*
				위 행이 정상적으로 에러없이 실행이 되면
				byte[]이 파라미터로 바뀌고
				파일도 저장경로에 업로드 처리가 된다.
			 */
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
			파라미터 받고
				multi가 채워지는 순간
				스트림 방식으로 전송된 데이터를 파라미터로 바꿔서 기억하고 있다.
				기억된 객체는 req가 아니고 multi가 기억하고 있다.
			따라서 파라미터를 꺼내는 방법
				multi.getParameter("키값");
			로 전송된 데이터를 꺼내서 사용하면 된다.
				
		 */
		String title = multi.getParameter("title");
		String body = multi.getParameter("body");
		
		BoardDao bDao = new BoardDao();
		int cnt = 0;
		cnt = bDao.addBoard(sid, title, body);
		if(cnt != 1) {
			return "/cafe/board/boardWrite";
		} else {
			// 게시글 등록에 성공한 경우
			// 게시글 등록에 성공했으므로 업로드하는 파일도 정보를 등록해준다.
			
			// 파일 정보를 등록하려면 등록된 게시글의 번호를 알아야 하므로 번호를 조회한다.
			int bno = bDao.getBoardNo(sid);
		/*
			현재 파일이 업로드는 되어있는 상태이다.
			이것은 단순히 서버의 특정 위치에 파일을 저장한 것일 뿐이다.
			이 파일이 누가 업로드했고 어떤글에 첨부되어있는지 등의 정보는
			데이터베이스에 별도로 기록해 놓아야
			해당 파일의 실제 주인을 찾을 수 있게 된다.
			
			참고 ]
				
				multipartRequest가 가진 주요함수
				==> 업로드한 파일의 정보를 알려주는 함수
				
				getFile("키값")
					==> 업로드된 파일의 정보를 알려준다.
				getFileSystemName("키값")
					==> 업로드된 파일의 실제 저장된 이름을 알려준다.
				getOriginalFileName("키값")
					==> 업로드된 파일의 원래 이름을 알려준다.
				Enumeration getFileNames()
					==> 업로드된 파일의 모든 키값을 알려준다.
		 */
			// 데이터 기억할 변수 만들고
			FileVO fVO = new FileVO();
			// 업로드된 모든 파일의 키값을 추출한다.
			Enumeration en = multi.getFileNames();
			while(en.hasMoreElements()) {
				String key = (String) en.nextElement();
				// 업로드된 원래 파일이름을 알아낸다.
				String oriname = multi.getOriginalFileName(key);
				// oriname 이 없는 경우는 파일 태그에서 파일을 선택하지 않은 경우이므로
				// 다음 키값으로 진행해서 다음 파일을 처리한다.
				if(oriname == null) {
					continue;
				}
				
				String savename = multi.getFilesystemName(key);
				// <== 실제 저장된 파일의 이름을 알아낸다.
				
				File file = multi.getFile(key);
				long len = file.length();
				
				// 데이터가 준비가 되었으니 VO에 채워준다.
				fVO.setBno(bno);
				fVO.setOriname(oriname);
				fVO.setSavename(savename);
				fVO.setLen(len);
				
				cnt = bDao.addFileInfo(fVO);
			}
		}
			
		return view;
	}

}
