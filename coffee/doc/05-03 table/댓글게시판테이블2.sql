CREATE TABLE replyboard(
    reno NUMBER(6)
        CONSTRAINT RPLYBRD_NO_PK PRIMARY KEY,
    title VARCHAR2(50 CHAR)
        CONSTRAINT RPLYBRD_TTL_NN NOT NULL,
    body VARCHAR2(4000)
        CONSTRAINT RPLYBRD_BODY_NN NOT NULL,
    remno NUMBER(4)
        CONSTRAINT RPLYBRD_MNO_FK REFERENCES member(mno)
        CONSTRAINT RPLYBRD_MNO_NN NOT NULL,
    wdate DATE DEFAULT sysdate
        CONSTRAINT RPLYBRD_DATE_NN NOT NULL,
    bgroup VARCHAR2(4000)
        CONSTRAINT RPLYBRD_GR_NN NOT NULL,
    upno NUMBER(6)
        CONSTRAINT RPLYBRD_UP_FK REFERENCES replyboard(reno),
    step NUMBER(1) DEFAULT 0
        CONSTRAINT RPLYBRD_STEP_NN NOT NULL,
    isShow CHAR(1) DEFAULT 'Y'
        CONSTRAINT RPLYBRD_SHOW_CK CHECK (isShow IN ('Y', 'N'))
        CONSTRAINT RPLYBRD_SHOW_NN NOT NULL
);

/*
    bgroup 내용 작성 형식
        
        #상위글번호들#자신의글번호@
*/

-- 데이터 입력
INSERT INTO
    replyboard(reno, remno, title, body, bgroup)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 100001) FROM replyboard),
    (SELECT mno FROM member WHERE id = 'euns'),
    '테스트1', 'test01', 
    '#' || (SELECT NVL(MAX(reno) + 1, 100001) FROM replyboard) || '@'
);

INSERT INTO
    replyboard(reno, remno, title, body, bgroup, upno, step)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 100001) FROM replyboard),
    (SELECT mno FROM member WHERE id = 'chae'),
    '테스트2', 'test02', 
    (SELECT substr(bgroup, 1, length(bgroup) - 1) FROM replyboard WHERE reno = 100001) ||
    '#' || (SELECT NVL(MAX(reno) + 1, 100001) FROM replyboard) || '@',
    100001,
    (SELECT step + 1 FROM replyboard WHERE reno = 100001)
);

INSERT INTO
    replyboard(reno, remno, title, body, bgroup, upno, step)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 100001) FROM replyboard),
    (SELECT mno FROM member WHERE id = 'guk'),
    '테스트3', 'test03', 
    (SELECT substr(bgroup, 1, length(bgroup) - 1) FROM replyboard WHERE reno = 100001) ||
    '#' || (SELECT NVL(MAX(reno) + 1, 100001) FROM replyboard) || '@',
    100001,
    (SELECT step + 1 FROM replyboard WHERE reno = 100001)
);

INSERT INTO
    replyboard(reno, remno, title, body, bgroup, upno, step)
VALUES(
    (SELECT NVL(MAX(reno) + 1, 100001) FROM replyboard),
    (SELECT mno FROM member WHERE id = 'euns'),
    'thx', 'thanks so much~~!', 
    (SELECT substr(bgroup, 1, length(bgroup) - 1) FROM replyboard WHERE reno = 100002) ||
    '#' || (SELECT NVL(MAX(reno) + 1, 100001) FROM replyboard) || '@',
    100002,
    (SELECT step + 1 FROM replyboard WHERE reno = 100002)
);

SELECT
    *
FROM
    replyboard
ORDER BY
    bgroup DESC
;

------------------------------------------------------------------------------------------
-- 게시판 기능 관련 테이블

-- 게시판 테이블
CREATE TABLE board(
    bno NUMBER(6)
        CONSTRAINT BRD_NO_PK PRIMARY KEY,
    title VARCHAR2(50 CHAR)
        CONSTRAINT BRD_TTL_NN NOT NULL,
    body VARCHAR2(4000)
        CONSTRAINT BRD_BODY_NN NOT NULL,
    bmno NUMBER(4)
        CONSTRAINT BRD_MNO_FK REFERENCES member(mno)
        CONSTRAINT BRD_MNO_NN NOT NULL,
    wdate DATE DEFAULT sysdate
        CONSTRAINT BRD_DATE_NN NOT NULL,
    isShow CHAR(1) DEFAULT 'Y'
        CONSTRAINT BRD_SHOW_CK CHECK (isShow IN ('Y','N'))
        CONSTRAINT BRD_SHOW_NN NOT NULL
);

-- 업로드 파일 정보 테이블
CREATE TABLE upfile(
    fno NUMBER(6)
        CONSTRAINT FILE_NO_PK PRIMARY KEY,
    fbno NUMBER(6)
        CONSTRAINT FILE_BNO_FK REFERENCES board(bno)
        CONSTRAINT FILE_BNO_NN NOT NULL,
    oriname VARCHAR2(50 CHAR)
        CONSTRAINT FILE_ONAME_NN NOT NULL,
    savename VARCHAR2(50 CHAR)
        CONSTRAINT FILE_SNAME_NN NOT NULL,
    len NUMBER
        CONSTRAINT FILE_LEN_NN NOT NULL,
    dir VARCHAR2(100 CHAR) DEFAULT '/img/upfile/'
        CONSTRAINT FILE_DIR_NN NOT NULL,
    fdate DATE DEFAULT sysdate
        CONSTRAINT FILE_DATE_NN NOT NULL,
    isShow CHAR(1) DEFAULT 'Y'
        CONSTRAINT FILE_SHOW_CK CHECK (isShow IN ('Y', 'N'))
        CONSTRAINT FILE_SHOW_NN NOT NULL
);        
SELECT
    rno, bno, title, id, wdate
FROM
    (
        SELECT
            ROWNUM rno, bno, title, id, wdate
        FROM
            (
                SELECT
                    bno, title, id, wdate
                FROM
                    board b, member m
                WHERE
                    bmno = mno
                    AND b.isShow = 'Y'
                ORDER BY
                    wdate DESC
            )
    )    
;    
        