CREATE TABLE guestBoard(
    gno NUMBER(4)
        CONSTRAINT GBRD_NO_PK PRIMARY KEY,
    writer NUMBER(4)
        CONSTRAINT GBRD_MNO_FK REFERENCES member(mno)
        CONSTRAINT GBRD_MNO_NN NOT NULL,
    body VARCHAR2(4000)
        CONSTRAINT GBRD_BODY_NN NOT NULL,
    wdate DATE DEFAULT sysdate
        CONSTRAINT GBRD_DATE_NN NOT NULL,
    isShow CHAR(1) DEFAULT 'Y'
        CONSTRAINT GBRD_SHOW_CK CHECK (isShow IN ('Y', 'N'))
        CONSTRAINT GBRD_SHOW_NN NOT NULL
);

INSERT INTO
    guestBoard(gno, writer, body)
VALUES(
    (SELECT NVL(MAX(gno) + 1, 1001) FROM guestBoard),
    1001, '이제부터 시작~~~!'
);

commit;