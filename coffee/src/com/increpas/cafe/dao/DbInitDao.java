package com.increpas.cafe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.increpas.cafe.db.CafeDBCP;
import com.increpas.cafe.sql.*;

public class DbInitDao {
	CafeDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	DbinitSQL dSQL;
	
	public DbInitDao() {
		db = new CafeDBCP();
		dSQL = new DbinitSQL();
	}
	
	// 테이블 생성 데이터베이스 전담 처리 함수
	public int addTable() {
		int cnt = 1;
		con = db.getCon();
		String sql = dSQL.getSQL(dSQL.ADD_TABLE);
		stmt = db.getSTMT(con);
		try {
			cnt = stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(stmt);
			db.close(con);
		}
		return cnt;
	}
}
