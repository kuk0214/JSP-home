package com.increpas.cafe.dao;

import java.sql.*;
import java.sql.Date;
import java.sql.Time;
import java.util.*;
import javax.sql.*;

import com.increpas.cafe.db.*;
import com.increpas.cafe.vo.*;
import com.increpas.cafe.sql.*;
import com.increpas.cafe.util.PageUtil;

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
	public ArrayList<BoardVO> getReBoardList() {
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
				rVO.setId(rs.getString("id"));
				rVO.setAvatar(rs.getString("avatar"));
				rVO.setTitle(rs.getString("title"));
				rVO.setBody(rs.getString("body").replaceAll("\r\n", "<br>"));
				rVO.setUpno(rs.getInt("upno"));
				rVO.setStep(rs.getInt("step"));
				rVO.setWdate(rs.getDate("wdate"));
				rVO.setWtime(rs.getTime("wdate"));
				rVO.setSdate();
				
				list.add(rVO);
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
	
	public ArrayList<BoardVO> getReBoardList(PageUtil page) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_LIST_RNUM);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO rVO = new BoardVO();
				rVO.setRno(rs.getInt("rno"));
				rVO.setMno(rs.getInt("mno"));
				rVO.setId(rs.getString("id"));
				rVO.setAvatar(rs.getString("avatar"));
				rVO.setTitle(rs.getString("title"));
				rVO.setBody(rs.getString("body").replaceAll("\r\n", "<br>"));
				rVO.setUpno(rs.getInt("upno"));
				rVO.setStep(rs.getInt("step"));
				rVO.setWdate(rs.getDate("wdate"));
				rVO.setWtime(rs.getTime("wdate"));
				rVO.setSdate();
				
				list.add(rVO);
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
	
	// 게시글 등록 전담 처리 함수
	public int addReBRD(BoardVO rVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_REBRD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, rVO.getTitle());
			pstmt.setString(2, rVO.getBody());
			pstmt.setInt(3, rVO.getMno());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 댓글 등록 전담 처리 함수
	public int addReply(BoardVO rVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_REPLY);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, rVO.getTitle());
			pstmt.setString(2, rVO.getBody());
			pstmt.setInt(3, rVO.getMno());
			pstmt.setInt(4, rVO.getUpno());
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 게시글 삭제 전담 처리 함수
	public int delRBRD(int rno) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.DEL_REBRD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, rno);
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 게시글 정보조회 전담 처리 함수
	public void getBoardRno(BoardVO rVO) {
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_RNO_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, rVO.getId());
			pstmt.setInt(2, rVO.getRno());
			rs = pstmt.executeQuery();
			rs.next();
			rVO.setRno(rs.getInt("rno"));
			rVO.setUpno(rs.getInt("upno"));
			rVO.setMno(rs.getInt("mno"));
			rVO.setAvatar(rs.getString("avatar"));
			rVO.setTitle(rs.getString("title"));
			rVO.setUptitle(rs.getString("uptitle"));
			rVO.setBody(rs.getString("body"));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return;
	}
	
	// 게시글 수정 전담 처리 함수
	public int editReBRD(Map<String, String[]> map) {
		int cnt = 0;
		// 매개변수 데이터 처리하고
		Set<String> set = map.keySet();
		ArrayList<String> list = new ArrayList<String>(set);
		list.remove("rno");
		String str = list.toString().replaceAll("\\[|\\]", "").replaceAll(",", " = ? , ") + " = ? ";
		
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.EDIT_REBRD);
		sql = sql.replaceAll("###", str);
		pstmt = db.getPSTMT(con, sql);
		try {
			for(int i = 0 ; i < list.size() ; i++ ) {
				pstmt.setString((i+1), map.get(list.get(i))[0]);
			}
			pstmt.setInt(list.size() + 1, Integer.parseInt(map.get("rno")[0]));
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 총 게시물 수 조회 전담 처리함수
	public int getTotalCount() {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_TOTAL_CNT);
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

}
