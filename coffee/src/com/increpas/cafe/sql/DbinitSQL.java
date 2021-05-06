package com.increpas.cafe.sql;

public class DbinitSQL {
	public final int ADD_TABLE	=	3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case ADD_TABLE:
			buff.append("CREATE TABLE buddy( ");
			buff.append("	    mno NUMBER(4) ");
			buff.append("	        CONSTRAINT b_NO_PK PRIMARY KEY, ");
			buff.append("	    name VARCHAR2(10 CHAR) ");
			buff.append("	        CONSTRAINT b_NAME_NN NOT NULL, ");
			buff.append("	    id VARCHAR2(8 CHAR) ");
			buff.append("	        CONSTRAINT b_ID_UK UNIQUE ");
			buff.append("	        CONSTRAINT b_ID_NN NOT NULL, ");
			buff.append("	    pw VARCHAR2(10 CHAR) ");
			buff.append("	        CONSTRAINT b_PW_NN NOT NULL, ");
			buff.append("	    mail VARCHAR2(30 CHAR) ");
			buff.append("	        CONSTRAINT b_MAIL_UK UNIQUE ");
			buff.append("	        CONSTRAINT b_MAIL_NN NOT NULL, ");
			buff.append("	    tel VARCHAR2(13 CHAR) ");
			buff.append("	        CONSTRAINT b_TEL_UK UNIQUE ");
			buff.append("	        CONSTRAINT b_TEL_NN NOT NULL, ");
			buff.append("	    gen CHAR(1) ");
			buff.append("	        CONSTRAINT b_GEN_CK CHECK(gen IN ('M', 'F')) ");
			buff.append("        	CONSTRAINT b_GEN_NN NOT NULL, ");
			buff.append("    	joindate DATE DEFAULT sysdate ");
			buff.append("       	CONSTRAINT b_JOIN_NN NOT NULL, ");
			buff.append("    	isshow CHAR(1) DEFAULT 'Y' ");
			buff.append("        	CONSTRAINT b_SHOW_CK CHECK(isshow IN ('Y', 'N')) ");
			buff.append("        	CONSTRAINT b_SHOW_NN NOT NULL ");
			buff.append(")");
			break;
		}
		return buff.toString();
	}

}
