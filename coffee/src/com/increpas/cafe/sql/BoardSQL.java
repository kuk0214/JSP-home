package com.increpas.cafe.sql;

public class BoardSQL {
	public final int SEL_TOTAL_CNT		=	1001;
	public final int SEL_BOARD_LIST		=	1002;
	public final int SEL_MAX_BNO		=	1003;
	public final int SEL_BNO_DETAIL		=	1004;	
	public final int SEL_FBNO_LIST		=	1005;	
	
	public final int ADD_BOARD			=	3001;
	public final int ADD_FILE			=	3002;
	
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
		case SEL_MAX_BNO:
			buff.append("SELECT ");
			buff.append("    MAX(bno) maxbno ");
			buff.append("FROM ");
			buff.append("    board ");
			buff.append("WHERE ");
			buff.append("    bmno = ( ");
			buff.append("                SELECT ");
			buff.append("                    mno ");
			buff.append("                FROM ");
			buff.append("                    member ");
			buff.append("                WHERE ");
			buff.append("                    id = ? ");
			buff.append("            )");
			break;
		case SEL_BNO_DETAIL:
			buff.append("SELECT ");
			buff.append("    bno, id, title, body, wdate ");
			buff.append("FROM ");
			buff.append("    board, member ");
			buff.append("WHERE ");
			buff.append("    bmno = mno ");
			buff.append("    AND bno = ?");
			break;
		case SEL_FBNO_LIST:
			buff.append("SELECT ");
			buff.append("    fno, oriname, savename ");
			buff.append("FROM ");
			buff.append("    upfile ");
			buff.append("WHERE ");
			buff.append("    fbno = ? ");
			buff.append("    AND isShow = 'Y'");
			break;
		case ADD_BOARD:
			buff.append("INSERT INTO ");
			buff.append("	board(bno, bmno, title, body) ");
			buff.append("VALUES( ");
			buff.append("	(SELECT NVL(MAX(bno) + 1, 100001) FROM board), ");
			buff.append("	(SELECT mno FROM member WHERE id = ?), ?, ? ");
			buff.append(")");
			break;
		case ADD_FILE:
			buff.append("INSERT INTO ");
			buff.append("    upfile(fno, fbno, oriname, savename, len, dir) ");
			buff.append("VALUES( ");   
			buff.append("    (SELECT NVL(MAX(fno) + 1, 100001) FROM upfile), ");
			buff.append("    ?, ?, ?, ?, '/img/upload/' ");
			buff.append(")");
			break;
		}
		
		return buff.toString();
	}
}
