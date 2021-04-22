package com.increpas.cafe.db;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

/**
 * 이 클래스는 coffee 프로젝트에서 
 * 커넥션 풀에 있는 커넥션을 이용해서 데이터베이스 작업을 할 유틸리티 클래스
 * 
 * @author	조경국
 * @since	2021.04.21
 * @version	v.1.0
 */

public class CafeDBCP {
	// 커넥션 풀을 관리할 변수를 준비한다.
	public DataSource ds;
	
	/*
		누군가 이 클래스를 new 시키면 
		context.xml 파일에 등록된 자원을 가지고 오도록 한다.
		이처럼 context.xml 파일에 등록된 자원을 가지고 오는 기법을
		JNDI(Java Naming and Directory Interface) 기법이라고 한다.
	 */
	
	public CafeDBCP() {
		try {
			// 1. context.xml 파일에 등록된 자원을 알아낸다.
			InitialContext context = new InitialContext();
			// 2. 이중에 필요한 자원을 받는다.
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/TestDB");
			/*
				찾을 이름을 정하는 규칙 ]
					java:/comp/env/찾을이름
					
				우리의 경우
					java.:/comp/env/jdbc/TestDB
					
				따라서 이 작업이 성공하면 
				커넥션 풀을 찾은 것이다.
			 */
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
		필요한 순간에 오라클에 접속을 해야 한다.
		이때 접속은 직접 하는 것이 아니고
		커넥션 풀에 기억된 커넥션을 빌려오는 것이다.
	 */
	
	public Connection getCon() {
		Connection con = null;
		try {
			// 커넥션 풀을 관리하는 DataSource 에서 하나 꺼내온다.
			con = ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
			커넥션 풀은 직접 커넥션 시키지 않고
			풀에 저장해 놓았다가
			필요한 순간 가져다 쓰겠다는 개념이므로
			위의 작업만 다르고 
			이후의 다른 작업들은 이제까지 우리가 JDBC로 처리했던 것과 
			모두 동일하다.
		 */
		
		return con;
	}
	
	
		
	// 스테이트먼트를 꺼내주는 함수
	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	// PreparedStatement 꺼내주는 함수
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	// 사용하지 않는 자원 반환하는 함수
	public void close(Object o) {
		try {
			// 이 함수를 호출할 때 입력한 데이터가 무엇인지 파악하고 닫아준다.
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
