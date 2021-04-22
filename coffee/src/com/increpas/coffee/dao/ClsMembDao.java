package com.increpas.coffee.dao;

import java.sql.*;
import javax.sql.DataSource;

import com.increpas.cafe.db.*;
import com.increpas.coffee.sql.*;
import com.increpas.coffee.vo.*;

/**
 * 이 클래스는 회원관련 데이터베이스 작업을
 * 서버가 처음 기동될 때 미리 확보한 커넥션(DBCP : DataBase Connection Pool)을 이용해서 
 * 데이터베이스 작업을 전담해서 처리할 클래스 
 * @author	조경국
 * @since	2021.04.21
 * @version	v.1.0
 */

public class ClsMembDao {
	// 커넥션 풀을 관리할 변수
	CafeDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MemberSQL mSQL;
	
	
	public ClsMembDao() {
		db = new CafeDBCP();
		mSQL = new MemberSQL();
	}
	
	// 로그인 회원 정보 조회 전담 처리함수
	public MemberVO getLoginInfo(String sid) {
		// 반환값 변수 준비하고
		MemberVO mVO = new MemberVO();
		// 데이터베이스 작업 처리
		// 할일
		// 1. 커넥션 얻어오고
		con = db.getCon();
		// 2. 질의명령 꺼내오고
		String sql = mSQL.getSQL(mSQL.SEL_ID_INFO);
		// 3. PreparedStatement 꺼내오고
		pstmt = db.getPSTMT(con, sql);
		try {
			// 4. 질의명령 완성하고
			pstmt.setString(1, sid);
			// 5. 질의명령 보내고 결과받고
			rs = pstmt.executeQuery();
			// 6. 결과에서 데이터꺼내고
			// ==> 이 질의명령의 결과는 한행만 만들어 지므로 한행 내려서 처리하면 된다.
			rs.next();
			
			int mno = rs.getInt("mno");
			String name = rs.getString("name");
			String id = rs.getString("id");
			String mail = rs.getString("mail");
			String tel = rs.getString("tel");
			String gen = rs.getString("gen");
			int ano = rs.getInt("ano");
			String avatar = rs.getString("avatar");
			Date jDate = rs.getDate("joindate");
			Time jTime = rs.getTime("joindate");
			// 7. VO 데이터 담고
			mVO.setMno(mno);
			mVO.setName(name);
			mVO.setId(id);
			mVO.setMail(mail);
			mVO.setTel(tel);
			mVO.setGen(gen.equals("M") ? "남자" : "여자");
			mVO.setAno(ano);
			mVO.setAvatar(avatar);
			mVO.setjDate(jDate);
			mVO.setjTime(jTime);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		// 8. VO 내보내주고
		return mVO;
	}
}
