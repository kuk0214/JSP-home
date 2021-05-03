package com.increpas.cafe.sql;

public class BoardSQL {
	public final int SEL_TOTAL_CNT	=	1001;
	public final int SEL_BOARD_LIST	=	1002;
	
	public final int ADD_BOARD		=	3001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_TOTAL_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    board ");
			buff.append("WHERE ");
			buff.append("    isShow = 'Y'");
			break;
		case SEL_BOARD_LIST:
			buff.append("SELECT ");
			buff.append("    rno, bno, title, id, wdate ");
			buff.append("FROM ");
			buff.append("    ( ");
			buff.append("        SELECT ");
			buff.append("            ROWNUM rno, bno, title, id, wdate ");
			buff.append("        FROM ");
			buff.append("            ( ");
			buff.append("                SELECT ");
			buff.append("                    bno, title, id, wdate ");
			buff.append("                FROM ");
			buff.append("                    board b, member m ");
			buff.append("                WHERE ");
			buff.append("                    bmno = mno ");
			buff.append("                    AND b.isShow = 'Y' ");
			buff.append("                ORDER BY ");
			buff.append("                    wdate DESC ");
			buff.append("            ) ");
			buff.append("    ) ");
			buff.append("WHERE ");
			buff.append("    rno BETWEEN ? AND ?");
			break;
		case ADD_BOARD:
			buff.append("INSERT INTO ");
			buff.append("	board(bno, bmno, title, body) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(bno) + 1, 100001) FROM board), ");
			buff.append("	(SELECT mno FROM member WHERE id = ?), ?, ? ");
			buff.append(")");
			break;
		}
		
		return buff.toString();
	}
}
