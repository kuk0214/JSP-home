package com.increpas.cafe.sql;

public class ReBoardSQL {
	public final int SEL_ALL_LIST	=	1001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ALL_LIST:
			buff.append("SELECT ");
			buff.append("	rno, mno, id, savename avatar, ");
			buff.append("	title, body, wmno, upno, wdate, level -1 as step ");
			buff.append("FROM ");
			buff.append("    reboard r, member m, avatar a ");
			buff.append("WHERE ");
			buff.append("    wmno = mno ");
			buff.append("    AND avt = ano ");
			buff.append("    AND r.isshow = 'Y' ");
			buff.append("START WITH ");
			buff.append("    upno IS NULL ");
			buff.append("CONNECT BY ");
			buff.append("    PRIOR rno = upno ");
			buff.append("ORDER SIBLINGS BY "); 	// 정렬 방식 설정
			buff.append("    wdate DESC");		// 같은 레벨 일 때 무엇(wdate)을 먼저 보여줄지...
			break;
		}
		
		
		return buff.toString();
	}
}
