################################
p231  view
################################

뷰란?
 - 뷰는 하나의 가상 테이블이라 생각 하면 된다.
 - 뷰는 실제 데이터가 저장 되는 것은 아니지만 뷰를 통해 데이터를 관리 할 수 있다.
 - 뷰는 복잡한 Query를 통해 얻을 수 있는 결과를 간단한 Query로 얻을 수 있게 한다.
 - 한개의 뷰로 여러 테이블에 대한 데이터를 검색 할 수 있다.
 - 특정 평가 기준에 따른 사용자 별로 다른 데이터를 엑세스할 수 있도록 한다.

select ename, sal, d.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno;


-- 뷰만들 권한부여하기 (system/1234에서 주기)
conn system/1234;      -- 시스템으로 들어가기
grant dba to SCOTT;
conn SCOTT/TIGER;      -- 다시 스캇으로 돌아오기

-- or replace 없다면 새로 만들고 있다면 replce를 교체해줌
-- insufficient privileges -> 뷰 만들 권한이 없다.
create or replace view emp_dept 
as
select ename, sal, d.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno;

-- 뷰 삭제하기
drop view emp_dept;

-- 오류남
create or replace view emp_dept 
as
select *                            --> emp의 deptno와 dept의 deptno이 중복이라 오류남
from emp e, dept d
where e.deptno = d.deptno;
-- 다시 생성
create or replace view emp_dept 
as
select ename, sal, hiredate, d.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno;

select * from emp_dept;
select * from tab;
select user from dual;  -- SCOTT으로 로그인했어서 SCOTT이 보임

자기가 속한 부서의 평균 급여보다 작게 받는 사람들의 명단을 view로 만드세요. highsalavg
create or replace view highsalavg 
as
select ename, sal, deptno from emp outer
where sal < (select avg(sal) from emp where deptno=outer.deptno);

select * from highsalavg;

-- 뷰 삭제하기
drop view highsalavg;

자기가 속한 부서의 평균 급여보다 많이 받는 사람들의 명단을 view로 만드세요.
create or replace view highsalavg 
as
select ename, sal, deptno from emp outer
where sal > (select avg(sal) from emp where deptno=outer.deptno);

select * from highsalavg;

--view 생성과정
select * from emp;
select avg(sal) from emp;
select avg(sal) from emp where deptno=10;

create or replace view highsalavg
as 
select * from emp outer
where sal > (select avg(sal) from emp where deptno=outer.deptno);



##############################################################
sequence
##############################################################
시퀀스란?
- 유일(UNIQUE)한 값을 생성해주는 오라클 객체이다.

-- 데이터 삭제
delete from dept2;
select * from dept2;
select * from emp2;

insert into dept2 (deptno,dname,loc) values(1,'인사부','비트');
rollback;

-- 부서번호를 시퀀스로 만듬 먼저 시퀀스만듬
create sequence deptno_seq;

insert into dept2 (deptno,dname,loc) values(deptno_seq.nextval,'인사부','비트'); -- nextval자동증가
select deptno_seq.currval from dual; -- 현재 시퀀스 값 확인currval

select deptno_seq.currval from dual;
-- 시퀀스 삭제
drop sequence deptno_seq;
-- 시퀀스 생성 
create sequence deptno_seq start with 10 increment by 10;  -- 시퀀스 10부터시작해서 10씩 늘어남 10,20,30 으로 생성됨
insert into dept2 (deptno,dname,loc) values(deptno_seq.nextval,'인사부','비트'); 
select * from deptno;
-- 데이터 삭제
delete from dept2;
commit;

-- 시퀀스 안주고 자동증가 
insert into dept2 (deptno,dname,loc) values( (select nvl(max(deptno),0)+10 from dept2) ,'인사부','비트'); 
select nvl(max(deptno),0)+10 from dept2;


#################################################################

#################################################################

select * from dept;
select * from emp;

--실행계획출력
set autotrace on; -- 일반계정은 안됨 SCOTT에 dba권한을 줬어야함 



select * from emp where empno=7698;        -- index 기반 pk는 자동으로 색인(인덱스가 만들어짐) 색인표(목차)를 이용해서 찾기때문에 훨씬 성능이 좋음
select * from emp where ename='FORD';      -- index가 없기때문에 필터링기법이다. full scan -> 앞에서부터 하나씩 찾는 것 성능 떨어짐

-- pk아닌 컬럼 인덱스생성 
create index emp_ename_idx on emp(ename);
-- 인덱스삭제
drop index emp_ename_idx;

--실행계획 다시 표시안할때 
set autotrace off;

-- 전체 테이블 pk인덱스 이름 확인
select index_name,table_name from user_indexes;

--백업
CREATE OR REPLACE DIRECTORY mdbackup as 'c:\\madang\mdbackup';
GRANT READ, WRITE ON DIRECTORY mdbackup TO madang;

EXPDP madang/madang DIRECTORY=mdbackup DUMPFILE=madang_20140701.dmp

