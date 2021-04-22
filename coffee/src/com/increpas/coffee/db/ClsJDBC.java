package com.increpas.coffee.db;

import java.sql.*;

public class ClsJDBC {
	
	public ClsJDBC() {
		// 할일
		// 1. 드라이버 로딩하고
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			// 이 경우는 드라이버 로딩에 실패한 경우
			System.out.println("###### 드라이버 로딩 실패 ######");
			e.printStackTrace();
		}
	}
	
	// 커넥션을 요구하면 꺼내서 반환해주는 함수
	public Connection getCon() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hello";
		String pw = "increpas";
		try {
			con = DriverManager.getConnection(url, id, pw);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	// Statement를 요구하면 꺼내서 반환해주는 함수
	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	// PreparedStatement를 요구하면 꺼내서 반환해주는 함수
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	// 더이상 사용하지 않는 자원은 반환해주는 함수
	public void close(Object o) {
		// 매개변수로 입력된 타입을 확인하고
		try {
			if(o instanceof Connection) {
				((Connection) o).close();	
			} else if(o instanceof Statement) {
				((Statement) o).close();	
			} else if(o instanceof PreparedStatement) {
				((PreparedStatement) o).close();	
			} else if(o instanceof ResultSet) {
				((ResultSet) o).close();	
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
