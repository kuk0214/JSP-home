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
	
	// 게시글 리스트 조회 처리 전담 함수
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
	
	// 게시글 등록 처리 전담 함수
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
	
	// 게시글 번호 조회 전담 처리 함수
	public int getBoardNo(String id) {
		int bno = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_MAX_BNO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			bno = rs.getInt("maxbno");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return bno;
	}
	
	// 파일 정보 등록 데이터베이스 작업 전담 처리 함수
	public int addFileInfo(FileVO fVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.ADD_FILE);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, fVO.getBno());
			pstmt.setString(2, fVO.getOriname());
			pstmt.setString(3, fVO.getSavename());
			pstmt.setLong(4, fVO.getLen());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 게시글 상세 정보 조회 전담 처리 함수
	public BoardVO getBnoInfo(int bno) {
		BoardVO bVO = new BoardVO();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_BNO_DETAIL);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			rs.next();
			bVO.setBno(rs.getInt("bno"));
			bVO.setId(rs.getString("id"));
			bVO.setTitle(rs.getString("title"));
			bVO.setBody(rs.getString("body"));
			bVO.setWdate(rs.getDate("wdate"));
			bVO.setWtime(rs.getTime("wdate"));
			bVO.setSdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return bVO;
	}
	
	// 첨부파일 조회 전담 처리 함수
	public ArrayList<FileVO> getFileList(int bno) {
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		con = db.getCon();
		String sql = bSQL.getSQL(bSQL.SEL_FBNO_LIST);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FileVO fVO = new FileVO();
				fVO.setFno(rs.getInt("fno"));
				fVO.setOriname(rs.getString("oriname"));
				fVO.setSavename(rs.getString("savename"));
				
				list.add(fVO);
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
}
