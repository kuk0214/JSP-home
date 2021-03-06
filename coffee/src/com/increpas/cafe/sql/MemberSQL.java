package com.increpas.cafe.sql;

public class MemberSQL {
	public final int SEL_LOGIN		= 1001;
	public final int SEL_ID_CNT		= 1002;
	public final int SEL_ID_INFO	= 1003;
	public final int SEL_MEMB_LIST	= 1004;
	public final int SEL_NO_INFO	= 1005;
	public final int SEL_AVT_INFO	= 1006;
	public final int SEL_AVTMNO		= 1007;
	
	public final int EDIT_MYINFO	= 2001;
	
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
		case SEL_MEMB_LIST:
			buff.append("SELECT ");
			buff.append("    mno, name, gen, joindate ");
			buff.append("FROM ");
			buff.append("	member ");
			buff.append("WHERE ");
			buff.append("	isshow = 'Y' "); // 현재 활동중이 회원만 꺼내온다.
			buff.append("ORDER BY ");
			buff.append("	mno DESC");
			break;
		case SEL_NO_INFO:
			buff.append("SELECT ");
			buff.append("    mno, name, id, mail, tel, member.gen, ano, savename avatar, joindate ");
			buff.append("FROM ");
			buff.append("    member, avatar ");
			buff.append("WHERE ");
			buff.append("	avt = ano ");
			buff.append("	AND isshow = 'Y' ");
			buff.append("	AND mno = ?");
			break;
		case SEL_AVT_INFO:
			buff.append("SELECT ");
			buff.append("    ano, savename avatar ");
			buff.append("FROM ");
			buff.append("    avatar ");
			buff.append("WHERE ");
			buff.append("	gen = ?");
			break;
		case SEL_AVTMNO:
			buff.append("SELECT ");
			buff.append("	mno, savename avatar ");
			buff.append("FROM ");
			buff.append("	member, avatar ");
			buff.append("WHERE ");
			buff.append("	avt = ano ");
			buff.append("	AND id = ?");
			break;
		case EDIT_MYINFO:
			buff.append("UPDATE ");
			buff.append("	member ");
			buff.append("SET ");
			buff.append("	### ");
			buff.append("WHERE ");
			buff.append("	id = ?");
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
