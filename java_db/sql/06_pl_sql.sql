SET SERVEROUTPUT ON ;

Create Procedure SALARY_CAL
    실행가능한 모듈이 데이터베이스에 만들어진다.  
   
##############################
   Procedure  p261
##############################
-- 저장프로시저만듬 프로시저내용은 begin~end까지 ()안이 매개변수-> v_empno이게 로컬변수 매개변수 이아이가 들어오면 프로시저에 적힌 일을함
-- 정수하나 넘겨주면 그아이의 셀이 변경됨
create or replace procedure update_sal(v_empno in number)
is
begin
 update emp
 set sal=sal*1.1
 where empno=v_empno;
end;
/

select * from emp;

-- update_sal 프로시저만들고 함수수행하는 방법 -- commit을 따로 해줘야 함 오토커밋이 아니다.
-- 7369는 스미스의 사번 
execute update_sal(7369);    -- 스미스의 급여가 바뀜
commit;


--프로시저삭제
drop procedure update_sal;

-- v_deptno부서 전체 sal 높이기  v_deptno in number -> 인풋매개변수
create or replace procedure update_sal(v_deptno in number)
is
begin
 update emp
 set sal=sal*2
 where deptno=v_deptno;
end;
/
--20번부서 sal높이는 함수실행
execute update_sal(20); 
rollback;

*******************

Drop table book;

CREATE TABLE Book (
  bookid      NUMBER(2) PRIMARY KEY,
  bookname    VARCHAR2(40),
  publisher   VARCHAR2(40),
  price       NUMBER(8) 
);

-- book테이블에 한개의 행을 삽입하는 프로시저 ()안이 매개변수 --넘어온데이터들이 values에서 관리됨
CREATE OR REPLACE PROCEDURE InsertBook(
    myBookID IN NUMBER,
     myBookName IN VARCHAR2,
     myPublisher IN VARCHAR2,
     myPrice IN NUMBER)
 AS
 BEGIN
      INSERT INTO Book(bookid, bookname, publisher, price)
      VALUES(myBookID, myBookName, myPublisher, myPrice);
 END;
/
--프로시저삭제
drop procedure InsertBook;
-- 책삽입 함수 실행  excute,exec도 가능
execute InsertBook(1,'java ~~~','한빛',27000);
exec InsertBook(2,'java ~~~','한빛',27000);

select * from book;
rollback;
********************************************************************
동일한 이름의 도서가 있는지 점검한 후 삽입하는 프로시저(BookInsertOrUpdate)   int타입, float타입은 ANCI기반 자동으로 number로 바뀜
********************************************************************
-- NUMBER타입인 mycount변수선언 ; 
CREATE OR REPLACE PROCEDURE BookInsertOrUpdate(
    myBookID NUMBER,
    myBookName VARCHAR2,
    myPublisher VARCHAR2,
    myPrice INT)
 AS
    mycount NUMBER;
 BEGIN
   SELECT COUNT(*) INTO mycount FROM Book
     WHERE bookname LIKE myBookName;
   IF mycount!=0 THEN
     UPDATE Book SET price = myPrice
       WHERE bookname LIKE myBookName;
   ELSE
     INSERT INTO Book(bookid, bookname, publisher, price)
       VALUES(myBookID, myBookName, myPublisher, myPrice);
   END IF;
 END;
/

execute BookInsertOrUpdate(1,'db','비트',0);
select * from book;
exec BookInsertOrUpdate(1,'db','비트',2000);
exec BookInsertOrUpdate(2,'db','비트',20000);
rollback;

##########################################
FUNCTION 함수  (사용자정의함수)
##########################################
-- NUMBER타입으로 myInterest 변수선언 pl_sql에서는 =을  :=로 쓴다.
CREATE OR REPLACE FUNCTION fn1(
    price NUMBER) RETURN INT
  IS
     myInterest NUMBER;
  BEGIN
  /* price가 30,00원 이상이면 10%, 30,00원 미만이면 5% */
    IF Price >= 3000 THEN myInterest := Price * 0.1;
    ELSE myInterest := Price * 0.05;
   END IF;
   RETURN myInterest;
  END;
/

--사용자정의함수 실행 --함수호출문장 fn1(sal)
select empno,ename,sal,fn1(sal) from emp;


####################################
trigger   스스로분석하기....
####################################
-- 물품테이블
create table item(
  code char(6) primary key, --물품 코드
  name varchar2(15) not null,
  company varchar2(15),
  price number(8),
  cnt number default 0 -- 재고 수량  
);

-- 창고테이블
create table warehouse(
   num number(6) primary key, --입고 번호
   code char(6) references item(code),
   indate date default sysdate, --입고날짜
   incnt number(6),
   inprice number(6),
   totalprice number(8)
);

insert into item(code, name, company, price)
values('c0001', '에어콘', '삼성', 1000000);

insert into item(code, name, company, price)
values('c0002', '선풍기', 'LG', 50000);

commit;

SELECT * FROM item;

--재고수량 갱신하기위한 트리거 생성 -- for each row 각행마다
create or replace trigger cnt_add
after insert on warehouse for each row
  begin
     update item set cnt = cnt+:new.incnt
     where code=:new.code; --new 선언은 insert문, update문에서만 사용
end;
/


insert into warehouse(num, code, incnt, inprice, totalprice)
values(1,'c0001',10, 900000, 9000000 );

SELECT * FROM item;
SELECT * FROM warehouse;

#################################################
trigger  book  p270
################################################
set serveroutput on;

drop table book;
CREATE TABLE Book (
  bookid      NUMBER(2) PRIMARY KEY,
  bookname    VARCHAR2(40),
  publisher   VARCHAR2(40),
  price       NUMBER(8) 
);


drop table Book_log;
 CREATE TABLE Book_log(
    bookid_l NUMBER,
    bookname_l VARCHAR2(40),
    publisher_l VARCHAR2(40),
    price_l NUMBER
 );

 select * from Book;
 select * from Book_log;

-- 트리거란 데이터 변경시 자동호출 되는 것이다. 프로시저는 내가 실행해줘야하지만 트리거는 자동실행임
-- 트리거 이름 AfterInsertBook      
-- Book테이블에 insert 작업이 일어난 after에    
-- INSERT INTO Book_log VALUES(:new.bookid, :new.bookname, :new.publisher, :new.price); 실행됨 book에 insert한후에 백업파일(Book_log)을 만들겠다는 뜻
--  DBMS_OUTPUT.PUT_LINE('삽입 투플을 Book_log 테이블에 백업..'); -> 콘솔창에 찍는 내용
CREATE OR REPLACE TRIGGER AfterInsertBook
     AFTER INSERT ON Book FOR EACH ROW
     DECLARE
     
     BEGIN
        INSERT INTO Book_log
        	/*new 선언은 insert문, update문에서만 사용*/
           VALUES(:new.bookid, :new.bookname, :new.publisher, :new.price); 
        DBMS_OUTPUT.PUT_LINE('Book_log 테이블에 백업..');
     END;
/
-- DBMS_OUTPUT.PUT_LINE('Book_log 테이블에 백업..'); 따로 창띄어주는게 없음 그래서 창띄어주려고 밑의 문장 수행
set serveroutput on;

insert into book values(1,'java ~~~','한빛미디어',9900);
insert into book values(2,'SQL','한빛미디어',9900);

 select * from Book;
 select * from Book_log;
         
######################################################################
CURSOR    sql문의 d코드로 처리하는게 나아서 수업안함..
######################################################################

drop PROCEDURE Interest;
CREATE OR REPLACE PROCEDURE Interest
 AS
    myInterest NUMERIC;
    Price NUMERIC;
    CURSOR InterestCursor IS SELECT saleprice FROM Orders;
 BEGIN
   myInterest := 0.0;
   OPEN InterestCursor;
   LOOP
       FETCH InterestCursor INTO Price;
       EXIT WHEN InterestCursor%NOTFOUND;
       IF Price >= 30000 THEN
           myInterest := myInterest + Price * 0.1;
       ELSE
           myInterest := myInterest + Price * 0.05;
       END IF;
    END LOOP;
    CLOSE InterestCursor;
    DBMS_OUTPUT.PUT_LINE(' 전체 이익 금액 = ' || myInterest);
 END;
 /
 
 
 
 create sequence SEQ_STID
 increment by 1
 start with 100 maxvalue 10000;
 
 drop 
 select SEQ_STID.nextval from dual;
 select max(SEQ_STID) from dual;
 
 create table customer(
 	custid number primary key,
 	name varchar2(40),
 	address varchar2(40),
 	phone varchar2(30)
 );
  insert into customer values(SEQ_STID.nextval,'1','1', '1');
  insert into customer values(SEQ_STID.nextval,'1','1', '1');
  insert into customer values(SEQ_STID.nextval,'1','1', '1');
	 select * from customer;
	 
	 delete from customer;
	 drop sequence SEQ_STID;
	 
	 select SEQ_STID.nextval from Dual;
	 select SEQ_STID.currval from Dual;
	 
	 
	 
	 
	 