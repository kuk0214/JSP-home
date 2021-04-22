package com.increpas.coffee.dao;

/**
 * 이 클래스는 서블릿 매핑에 의해서 처리되는 회원 관련 데이터 베이스 작업 전담 클래스
 * @author	조경국
 * @since	2021.04.19
 * @version v.1.0	
 */

import java.sql.*;

import com.increpas.coffee.db.*;
import com.increpas.coffee.sql.*;
import com.increpas.coffee.vo.*;

public class ClsMemberDao {
/*
	이 클래스는 데이터베이스 작업 전담 클래스이기 때문에
	이 클래스가 new 되는 순간 데이터베이스 작업 준비가 되어야 겠다.
 */
	ClsJDBC db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MemberSQL mSQL;
	
	public ClsMemberDao() {
		db = new ClsJDBC();
		// 이 작업이 정상적으로 완료되면 오라클 데이터베이스를 사용할 드라이버 로딩이 끝난 상태가 된다.
		// 따라서 데이터베이스 작업을 할때 커넥션을 꺼내고 기타 필요한 것들을 꺼내서 작업하면 된다.
		mSQL = new MemberSQL();
	}
	
	// 로그인 데이터베이스 작업 전담 처리함수
	public int getLoginCnt(String id, String pw) {
		// 반환값 변수 만들고
		int cnt = 0;
		// 데이터 베이스 작업....
		// 1. con 꺼내오고
		con = db.getCon();
		// 2. 질의명령 가져오고
		String sql = mSQL.getSQL(mSQL.SEL_LOGIN);
		// 3. 스테이먼트 준비하고
		pstmt = db.getPSTMT(con, sql);
		try {
			// 4. 질의명령 완성하고
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			// 5. 질의명령 보내고 결과받고
			rs = pstmt.executeQuery();
			// 6. 결과에서 데이터 꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		
		// 반환해주고....
		return cnt;
	}
	
	// 아이디 카운트 데이터베이스 조회 전담 처리함수
	public int getIdCnt(String id) {
		// 할일
		// 0. 반환값 변수 만들고
		int cnt = 1 ;
		
		// 1. 커넥션 꺼내오고
		con = db.getCon();
		// 2. 질의명령 꺼내오고
		String sql = mSQL.getSQL(mSQL.SEL_ID_CNT);
		// 3. 스테이트먼트 준비하고
		pstmt = db.getPSTMT(con, sql);
		try {
			// 4. 질의명령 완성하고
			pstmt.setString(1, id);
			// 5. 질의명령 보내고 결과받고
			rs = pstmt.executeQuery();
			// 6. 결과에서 데이터 꺼내고
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 7. 데이터 반환하고
		return cnt;
	}
	
	// 회원 가입 데이터베이스 전담 처리함수
	public int addMemb(MemberVO mVO) {
		// 반환값 변수 만들어주고
		int cnt = 0 ;
		// 할일
		// 1. 커넥션 꺼내오고
		con = db.getCon();
		// 2. 질의명령 꺼내오고
		String sql = mSQL.getSQL(mSQL.ADD_MEMB);
		// 3. 스테이먼트 준비하고
		pstmt = db.getPSTMT(con, sql);
		try {
			// 4. 질의명령 완성하고
			pstmt.setString(1, mVO.getName());
			pstmt.setString(2, mVO.getId());
			pstmt.setString(3, mVO.getPw());
			pstmt.setString(4, mVO.getMail());
			pstmt.setString(5, mVO.getTel());
			pstmt.setString(6, mVO.getGen());
			pstmt.setInt(7, mVO.getAno());
			// 5. 질의명령 보내고 결과 받고
			cnt = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		// 데이터 반환하고
		return cnt;
	}
}
