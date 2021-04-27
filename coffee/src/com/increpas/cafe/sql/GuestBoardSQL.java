package com.increpas.cafe.sql;

public class GuestBoardSQL {
	public final int SEL_ALL_LIST	= 1001;
	
	public final int ADD_GBRD		= 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("	gno, writer, body, wdate ");
			buff.append("FROM ");
			buff.append("	guestBoard ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y'");
			break;
		case ADD_GBRD:
			buff.append("INSERT INTO ");
			buff.append("	guestBoard(gno, writer, body) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(gno) + 1, 1001) FROM guestBoard), ");
			buff.append("	?, ? ");
			buff.append(")");
			break;
		}
		
		return buff.toString();
	}
}
