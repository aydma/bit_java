###########################################
Table 생성  DDL (auto commit) 취소가안됨

테이블은 실제로 데이터들이 저장되는 곳 이라고 생각하면 쉽게 이해 할 수 있으며,
CREATE TABLE 명령어를 이용해서 테이블을 생성 할 수 있다.
###########################################
데이터타입설명
	VARCHAR2 타입
	- 가변길이 문자형 데이터 타입 
	- 최대 길이 : 2000 바이트(반드시 길이 지정) 
	- 다른 타입에 비해 제한이 적다 
	- 일부만 입력시 뒷부분은 NULL 
	- 입력한 값의 뒷부분에 있는 BLANK도 같이 입력 
	- 전혀 값을 주지 않으면 NULL 상태 입력 
	- 지정된 길이보다 길면 입력시 에러 발생 
	- 컬럼 길이의 편차가 심한 경우, NULL 로 입력되는 경우가 많은 경우 VARCHAR2 사용 

	NUMBER 타입
	- 숫자형 데이타 타입, 음수, ZERO, 양수 저장 
	- 전체 자리수는 38자리를 넘을 수 없다 
	- 소수점이 지정되지 않았을 때 소수점이 입력되거나, 지정된 소수점자리 이상 입력되면 반올림되어 저장 
	- 지정한 정수 자리수 이상 입력시 에러 발생 
	- 연산이 필요한 컬럼은 NUMBER타입으로 지정한다. 
	- NUMBER(p,s) 로 지정시 p는 s의 자리수를 포함한 길이므로 감안하여 P의 자리수를 결정 
	- NUMBER 타입은 항상 가변길이므로 충분하게 지정할 것 

	DATE 타입
	- 일자와 시간을 저장하는 날짜형 타입 
	- 일자나 시간의 연산이 빈번한 경우 사용 
	- 포함정보 : 세기, 년도, 월, 일, 시간, 분, 초 
	- NLS_DATE_FORMAT을 이용하여 국가별 특수성을 해결 
	- 특별히 시간을 지정하지 않으면 00:00:00로 입력 됨 
	- 특별히 일자를 지정하지 않았다면 현재월의 1일로 지정 됨 
	- SYSDATE는 현재일과 시간을 제공 

-- 테이블삭제
drop table book;
-- 테이블생성
create table book( 
	bookno     number(5),
	title      varchar2(30),
	author     varchar2(30),   -- 저자
	pubdate    date			-- 출판일자
);

select * from book;

insert into book values(1,'java','kim',sysdate);
insert into book values(2,'jsp','홍',sysdate);
insert into book values(2,'jsp','홍',sysdate);
insert into book values(2,'jsp','홍','19/02/02');

-- commit, rollback은 마지막에 커밋이나 롤백했던 때를 기준으로 실행된다.
commit;
rollback;

insert into book values(3, 'db');   --오류남
insert into book (bookno,title) values(3, 'db'); -- 컬럼어디에들어가는지알려줌

insert into book (bookno,title,author,pubdate) 
values(3, 'db', null, null); 

-- book데이터삭제 조건을 주지않으면 전체삭제
delete from book;
rollback;
delete from book where title='db';
delete from book where author is null;
delete from book where author = '홍';
commit;


--book테이블의 구조를보여줌
desc book;

-- 테이블 구조 변경 -컬럼추가
alter table book add(price number(7));  -- 데이터insert한후 커밋을 안했더라도 alter명령이 오토커밋이라서 데이터가 자동으로 커밋됨
insert into book (bookno,title,author,pubdate,price) 
values(3, 'db', null, null, 900); 
commit;

-- 이미 있는 데이터 수정하기 조건(where)이 없어서 모든 book데이터의 price가 10이됨
update book set price=10;
rollback;
-- price가정수형이라서 반올림되어 1001이 들어감
update book set price=1000.99;

update book set price=900 where title='db';
select * from book;
commit;

update book set author='~~~~', price=900, pubdate=sysdate where bookno=3;

--테이블의 컬럼 modify변경    --정수형인 price를 실수형으로 modify 변경 -- price에 데이터 있으면 수정불가능 -- price가 비어있어야함 
update book set price=null;
alter table book modify(price number(7,2));
update book set price=1000.99;
commit;

-- 테이블에서 컬럼삭제
alter table book drop column price;
rollback; -- roolback 안됨
--book테이블의 구조를보여줌
desc book;
-- 테이블 이름 변경
rename book to book2;
rename book2 to book;

delete from book; rollback;
-- 데이터 잘라내는 기능인데 오토커밋이라서 rollback이 안됨
truncate table book; 

select * from emp;
select * from dept;

-- emp 테이블구조, 데이터 그대로 복사되는 emp2 테이블이 만들어진다. --제약조건은 복사안됨 --내가 원하는 컬럼만 추출해서 만들수있다. 
create table emp2 as select * from emp; 
create table dept2 as select * from dept; 

insert into dept values(50,'EDU','SEOUL');
insert into dept2 values(50,'EDU','SEOUL');
commit;

insert into dept values(10,'EDU','SEOUL'); -- 실패 제약조건때문에
insert into dept2 values(10,'EDU','SEOUL'); -- 성공 제약조건없어서
rollback;

insert into emp (empno, ename, hiredate, sal, deptno) 
			values(9999, '홍길동', sysdate, 0, 90);    -- 90번부서번호가 존재하지않아서 에러남
			
insert into emp2 (empno, ename, hiredate, sal, deptno) 
			values(9999, '홍길동', sysdate, 0, 90); 	 -- 90번부서 없지만 emp2는 제약조건 없어서 에러안남	
insert into emp2 (empno, ename, hiredate, sal, deptno) 
			values(9999, '홍길동', sysdate, 0, 90);
insert into emp2 (empno, ename, hiredate, sal, deptno) 
			values(9999, '홍길동', sysdate, 0, 90);
			
insert into emp (empno, ename, hiredate, sal, deptno) 
			values(9999, '홍길동', sysdate, 0, 40);   
rollback;

			
-- 테이블삭제
drop table book;
-- 테이블생성
create table book( 
	bookno     number(5),
	title      varchar2(30),
	author     varchar2(30),   -- 저자
	price      number(7,2),    -- 실수형
	pubdate    date			-- 출판일자
);
-- 테이블 제약조건 주기 
-- scott_book_pk 제약조건 이름 내맘대로 짓기
-- primary key 중복허용안함 null안됨 자동적으로 인덱스생성   / unique 중복허용안함 null 허용  자동적으로 인덱스생성
-- check(price>0) 컬럼 체크해줌
create table book( 
	bookno     number(5)    constraint scott_book_pk primary key,
	title      varchar2(30) constraint scott_book_title_unique unique,
	author     varchar2(30),   
	price      number(7,2)  constraint book_price_check check(price>0),
	pubdate    date         default sysdate		
);		
insert into book (bookno, title, author, price, pubdate) 
			values(1, 'db', '홍길동', 900, sysdate);   
insert into book (bookno, title, author, price, pubdate) 
			values(2, 'jsp', '홍길동', 22000, sysdate);   
insert into book (bookno, title, author, price, pubdate) 
			values(3, 'java', '김길동', 32000, default);   
commit;

-- book테이블에 걸려있는 사용자 정의 제약조건이름 확인하는 문장
select CONSTRAINT_name
from user_cons_columns
where table_name='BOOK';


-- 테이블삭제
drop table book;
-- 테이블 제약조건 이름없이 주기  --이름없이주면 제약조건 오류날때 어떤 제약조건때문에 오류나는지 알 수 없음
-- ORA-00001: unique constraint (SCOTT.SYS_C007044) violated 이런 이름의 오류가남 
create table book( 
	bookno     number(5)    primary key,
	title      varchar2(30) unique,
	author     varchar2(30),   
	price      number(7,2)  check(price>0),
	pubdate    date         default sysdate		
);		



-- 테이블삭제
drop table book;
-- primary key 제약조건을 밖에서 줌
create table book( 
	bookno     number(5),
	title      varchar2(30) unique,
	author     varchar2(30),   
	price      number(7,2)  check(price>0),
	pubdate    date         default sysdate		
);	
-- 이미 만들어진 테이블에 primary key 제약조건 주기
alter table book add CONSTRAINT book_bookno_pk primary key(bookno); 
--primary key 제약조건 삭제  --삭제할때는 이름알아야삭제가능
alter table book drop CONSTRAINT book_bookno_pk;

insert into book (bookno, title, author, price) 
			values(5, null, '최길동', 32000); 
			
select * from book;
commit;

select CONSTRAINT_name
from user_cons_columns
where table_name='BOOK';

#####################################################################
emp   dept
#####################################################################
delete from dept where deptno = 50;
commit;

drop table dept2;
create table dept2 as select * from dept;
-- pk 제약조건주기
alter table dept2 add CONSTRAINT dept2_deptno_pk primary key(deptno);

drop table emp2;
create table emp2 as select * from emp;
-- pk 제약조건주기
alter table emp2 add CONSTRAINT emp2_pk primary key(empno);
-- fk 제약조건 --셀프 조인 테이블 이름만 지정해줘도 자동으로 pk를 레퍼런싱한다.
alter table emp2 add CONSTRAINT emp2_fk2 foreign key(mgr) references emp2;
-- fk 제약조건
alter table emp2 add CONSTRAINT emp2_fk1 foreign key(deptno) references dept2;

delete from dept2 where deptno=20;   -- 제약조건 걸려있어서 안됨

-- 제약조건 삭제 밑에서 제약조건 새로 만들려고
alter table emp2 drop CONSTRAINT emp2_fk1;

-- 제약조건 새로 만듬 deptno를 삭제하면 emp2의 deptno에 null을 줌
-- ON DELETE CASCADE 해당하는 FK를 가진 참조행도 삭제
-- ON DELETE SET NULL 해당하는 FK를 NULL로 바꿈
alter table emp2 
add CONSTRAINT emp2_fk1
foreign key(deptno) references dept2 ON DELETE SET NULL;  

alter table emp2 
add CONSTRAINT emp2_fk1
foreign key(deptno) references dept2 ON DELETE CASCADE; 

delete from dept2 where deptno=20; -- 위에서 제약조건 다시 줘서 실행가능해짐
rollback;

select * from emp2;

delete from dept where deptno=50;

select * from dept2;
insert into dept2 values(50, 'EDU', 'SEOUL');

select * from emp2;
insert into emp2 (empno, ename, hiredate, sal, deptno) 
			values(9999, '홍길동', sysdate, 0, 50); 
			
insert into emp2 (empno, ename, hiredate, sal, deptno) 
			values(7777, '고길동', sysdate, 0, 50); 
insert into emp2 (empno, ename, hiredate, sal, deptno, mgr) 
			values(8888, '이길동', sysdate, 0, null, 10); 
rollback;

drop table emp2;
-- 제약조건때문에 안지워짐 먼저 emp2를 지워야한다.
drop table dept2;
-- cascade CONSTRAINT 있으면 제약조건 있어도 테이블 지울 수 있다.
drop table dept2 cascade CONSTRAINT;


#####################################################################
트랜젝션 
#####################################################################
-- SCOTT/TIGER 창2개 연다
create table emp2 as select * from emp; 
select * from emp2;

창1
delete from emp2 where deptno=10;
-- 여기서 커밋이나 롤백안했는데 
창2
update emp2 set comm=0 where deptno=10;
-- 명령문 내리면 블락됨 위의 문장을 커밋이나 롤백해야 이 명령문이 수행된다. 
-- 창2 블락되었을때 창1에서 select는 문제없이 실행된다.
block 되는 거 확인 => 창1에서 commit or rollback 명령 수행하면 lock 풀림

데이터 관련명령##################################################################################
-- 테이블삭제
drop table book;
-- 테이블생성
create table book( 
	bookno     number(5),
	title      varchar2(30),
	author     varchar2(30),   -- 저자
	pubdate    date			-- 출판일자
);

insert into book (bookno,title,author,pubdate,price) values(3, 'db', null, null, 900); 
delete from book where author is null;
delete from book where author = '홍';
update book set author='~~~~', price=900, pubdate=sysdate where bookno=3;
commit;
rollback;

delete from book; rollback;
-- 데이터 잘라내는 기능인데 오토커밋이라서 rollback이 안됨
truncate table book; 
#############################################################################################

테이블 관련명령##################################################################################
--테이블의 컬럼 modify변경    --정수형인 price를 실수형으로 modify 변경 -- price에 데이터 있으면 수정불가능 -- price가 비어있어야함 
update book set price=null;
alter table book modify(price number(7,2));
update book set price=1000.99;
commit;
-- 테이블에서 컬럼삭제
alter table book drop column price;
rollback; -- roolback 안됨
--book테이블의 구조를보여줌
desc book;
-- 테이블 이름 변경
rename book to book2;
rename book2 to book;
#############################################################################################