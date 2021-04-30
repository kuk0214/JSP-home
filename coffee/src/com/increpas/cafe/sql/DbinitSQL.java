package com.increpas.cafe.sql;

public class DbinitSQL {
	public final int ADD_TABLE	=	3001;
	public final int ADD_MEMB	=	3002;

	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case ADD_TABLE:
			buff.append("CREATE TABLE buddy( ");
			buff.append("	    mno NUMBER(4) ");
			buff.append("	        CONSTRAINT MEMBER_NO_PK PRIMARY KEY, ");
			buff.append("	    name VARCHAR2(10 CHAR) ");
			buff.append("	        CONSTRAINT MEMBER_NAME_NN NOT NULL, ");
			buff.append("	    id VARCHAR2(8 CHAR) ");
			buff.append("	        CONSTRAINT MEMBER_ID_UK UNIQUE ");
			buff.append("	        CONSTRAINT MEMBER_ID_NN NOT NULL, ");
			buff.append("	    pw VARCHAR2(10 CHAR) ");
			buff.append("	        CONSTRAINT MEMBER_PW_NN NOT NULL, ");
			buff.append("	    mail VARCHAR2(30 CHAR) ");
			buff.append("	        CONSTRAINT MEMBER_MAIL_UK UNIQUE ");
			buff.append("	        CONSTRAINT MEMBER_MAIL_NN NOT NULL, ");
			buff.append("	    tel VARCHAR2(13 CHAR) ");
			buff.append("	        CONSTRAINT MEMBER_TEL_UK UNIQUE ");
			buff.append("	        CONSTRAINT MEMBER_TEL_NN NOT NULL, ");
			buff.append("	    gen CHAR(1) ");
			buff.append("	        CONSTRAINT MEMBER_GEN_CK CHECK(gen IN ('M', 'F')) ");
			buff.append("        CONSTRAINT MEMBER_GEN_NN NOT NULL, ");
			buff.append("    	joindate DATE DEFAULT sysdate ");
			buff.append("       	CONSTRAINT MEMBER_JOIN_NN NOT NULL, ");
			buff.append("    	isshow CHAR(1) DEFAULT 'Y' ");
			buff.append("        	CONSTRAINT MEMBER_SHOW_CK CHECK(isshow IN ('Y', 'N')) ");
			buff.append("        	CONSTRAINT MEMBER_SHOW_NN NOT NULL ");
			buff.append(")");
			break;
		case ADD_MEMB:
			buff.append("INSERT INTO ");
			buff.append("    member(mno, name, id, pw, mail, tel, gen) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(mno) + 1, 1001) FROM member), ");
			buff.append("    ?, ?, ?, ?, ?, ? ");
			buff.append(")");
			break;
		}
		return buff.toString();
	}

}
