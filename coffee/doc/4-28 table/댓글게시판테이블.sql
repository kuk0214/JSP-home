CREATE TABLE reboard(
    rno NUMBER(6)
        CONSTRAINT RBRD_NO_PK PRIMARY KEY,
    title VARCHAR2(50)
        CONSTRAINT RBRD_TTL_NN NOT NULL,
    body VARCHAR2(4000)
        CONSTRAINT RBRD_BODY_NN NOT NULL,
    wmno NUMBER(4)
        CONSTRAINT RBRD_MNO_FK REFERENCES member(mno)
        CONSTRAINT RBRD_MNO_NN NOT NULL,
    upno NUMBER(6)
        CONSTRAINT RBRD_UPNO_FK REFERENCES reboard(rno),
    wdate DATE DEFAULT sysdate
        CONSTRAINT RBRD_DATE_NN NOT NULL,
    isShow CHAR(1) DEFAULT 'Y'
        CONSTRAINT RBRD_SHOW_CK CHECK (isShow IN ( 'Y', 'N'))
        CONSTRAINT RBRD_SHOW_NN NOT NULL
);

-- 원글 등록
INSERT INTO
    reboard(rno, title, body, wmno)
VALUES(
    (SELECT NVL(MAX(rno) + 1, 100001) FROM reboard),
    '게시판 시작', '댓글 게시판 서비스를 시작합니다!', 1001
);

-- 댓글 등록
INSERT INTO
    reboard(rno, title, body, wmno, upno)
VALUES(
    (SELECT NVL(MAX(rno) + 1, 100001) FROM reboard),
    'test', 'test', 1008, 100007
);

INSERT INTO
    reboard(rno, title, body, wmno, upno)
VALUES(
    (SELECT NVL(MAX(rno) + 1, 100001) FROM reboard),
    '저도 축하!', '서비스 개설을 진심으로 축하합니다!', 1009, 100001
);

-- 댓글의 댓글 달기
INSERT INTO
    reboard(rno, title, body, wmno, upno)
VALUES(
    (SELECT NVL(MAX(rno) + 1, 100001) FROM reboard),
    '진심임???', '아무거나....', 1007, 100002
);

commit;

-- 계층 조회 질의명령
SELECT
    rno, mno, id, savename avatar, title, body, wmno, upno, wdate, level -1 as step
FROM
    reboard r, member m, avatar a
WHERE
    wmno = mno
    AND avt = ano
    AND r.isshow = 'Y'
START WITH
    upno IS NULL
CONNECT BY
    PRIOR rno = upno    
;