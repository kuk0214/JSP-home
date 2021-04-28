package com.increpas.cafe.dao;

import java.sql.*;
import java.sql.Date;
import java.sql.Time;
import java.util.*;
import javax.sql.*;

import com.increpas.cafe.db.*;
import com.increpas.cafe.vo.*;
import com.increpas.cafe.sql.*;

/**
 * 이 클래스는 댓글 게시판 데이터 베이스 작업 전담 처리 클래스
 * @author	조경국
 * @since	2021.04.28
 * @version	v.1.0
 * @see
 * 			작업이력
 * 				2021.04.28 - 전은석
 * 					: 클래스 작성, 리스트조회 함수 작성
 *
 */
public class ReBoardDao {
	CafeDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	ReBoardSQL rSQL;
	
	public ReBoardDao() {
		db = new CafeDBCP();
		rSQL = new ReBoardSQL();
	}
	
	// 게시글 조회 전담 처리 함수
	public ArrayList<BoardVO> dasd() {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_ALL_LIST);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				BoardVO rVO = new BoardVO();
				rVO.setRno(rs.getInt("rno"));
				rVO.setMno(rs.getInt("mno"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return list;
	}
}