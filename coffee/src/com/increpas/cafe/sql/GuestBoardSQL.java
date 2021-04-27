package com.increpas.cafe.sql;

public class GuestBoardSQL {
	public final int SEL_ALL_LIST	= 1001;
	public final int SEL_MY_CNT		= 1002;
	
	public final int ADD_GBRD		= 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("	gno, mno, id, savename avatar, body, wdate ");
			buff.append("FROM ");
			buff.append("	guestBoard, member, avatar ");
			buff.append("WHERE ");
			buff.append("	writer = mno ");
			buff.append("	AND avt = ano ");
			buff.append("	AND guestBoard.isshow = 'Y'");
			break;
		case SEL_MY_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	guestBoard ");
			buff.append("WHERE ");
			buff.append("	writer = ( ");
			buff.append("		SELECT mno FROM member WHERE id = ? ");
			buff.append("			 )");
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
