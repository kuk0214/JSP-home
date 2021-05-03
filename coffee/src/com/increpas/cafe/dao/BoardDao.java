package com.increpas.cafe.dao;

import java.util.*;
import java.sql.*;
import java.sql.Date;

import com.increpas.cafe.db.CafeDBCP;
import com.increpas.cafe.sql.BoardSQL;
import com.increpas.cafe.util.PageUtil;
import com.increpas.cafe.vo.*;


public class BoardDao {
	CafeDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	BoardSQL bSQL;
	
	public BoardDao() {
		db = new CafeDBCP();
		bSQL = new BoardSQL();
	}
	
	// 게시글 총 갯수 조회 전담 처리 함수
	public int getTotal() {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_TOTAL_CNT);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
	
	public ArrayList<BoardVO> getList(PageUtil page) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_BOARD_LIST);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bVO = new BoardVO();
				bVO.setRno(rs.getInt("rno"));
				bVO.setBno(rs.getInt("bno"));
				bVO.setTitle(rs.getString("title"));
				bVO.setId(rs.getString("id"));
				bVO.setWdate(rs.getDate("wdate"));
				bVO.setSdate(bVO.getWdate());
				
				list.add(bVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return list;
	}
	
	public int addBoard(String id, String title, String body) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.ADD_BOARD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, body);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}

}
