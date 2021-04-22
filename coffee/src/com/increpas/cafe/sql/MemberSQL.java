package com.increpas.cafe.sql;

public class MemberSQL {
	public final int SEL_LOGIN		= 1001;
	public final int SEL_ID_CNT		= 1002;
	public final int SEL_ID_INFO	= 1003;
	
	public final int ADD_MEMB		= 3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_LOGIN:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' ");
			buff.append("	AND id = ? ");
			buff.append("	AND pw = ?");
			break;
		case SEL_ID_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	id = ?");
			break;
		case SEL_ID_INFO:
			buff.append("SELECT ");
			buff.append("    mno, name, id, mail, tel, member.gen, ano, savename avatar, joindate ");
			buff.append("FROM ");
			buff.append("    member, avatar ");
			buff.append("WHERE ");
			buff.append("	avt = ano ");
			buff.append("	AND isshow = 'Y' ");
			buff.append("	AND id = ?");
			break;
		case ADD_MEMB:
			buff.append("INSERT INTO ");
			buff.append("    member(mno, name, id, pw, mail, tel, gen, avt) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), ");
			buff.append("    ?, ?, ?, ?, ?, ?, ? ");
			buff.append(")");
			break;
	}
		return buff.toString();
	}
}
