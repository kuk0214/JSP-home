package com.increpas.cafe.dao;


import java.sql.*;
import java.sql.Date;

import java.util.*;

import com.increpas.cafe.db.*;
import com.increpas.cafe.sql.*;
import com.increpas.cafe.vo.*;


public class GuestBoardDao {
	CafeDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MemberSQL mSQL;
	GuestBoardSQL gSQL;
	
	public GuestBoardDao() {
		db = new CafeDBCP();
		mSQL = new MemberSQL();
		gSQL = new GuestBoardSQL();
	}
	
	// 로그인 회원 정보 조회 전담 처리함수
	public MemberVO getMemberData(String id) {
		MemberVO mVO = new MemberVO();
		
		// connection 꺼내오고
		con = db.getCon();
		// 질의명령 가져오고
		String sql = mSQL.getSQL(mSQL.SEL_AVTMNO);
		// 스테이트먼트 준비하고
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성하고
			pstmt.setNString(1, id);
			// 질의보내고 결과받고
			rs = pstmt.executeQuery();
			// 데이터꺼내서 VO에 담고
			rs.next(); // 커서내리고
			mVO.setMno(rs.getInt("mno"));
			mVO.setAvatar(rs.getString("avatar"));
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mVO;
	}

}
