

alter user hr identified by hr account unlock;

sqlplus hr/hr

select * from tab;


conn system/1234  -- sqlplus system/1234
-- tablespace 생성
create tablespace bit
datafile 'c:\lib\bit.dbf'
size 30M
autoextend on next 2M maxsize UNLIMITED;

-- 계정 생성 test01/1234 
create user test01 identified by 1234
default tablespace bit;

-- sqlplus system/1234 하기전에 
-- 권한부여 test01/1234
grant connect to test01;

-- 권한회수
revoke connect from test01;

-- 리소스까지 만들수있는 권한부여 (로그인가능, 테이블생성가능, 자원사용가능)
grant connect,resource to test01;

-- 계정 삭제 test01
drop user test01 cascade;

-- 계정 생성 SCOTT/TIGER 
create user SCOTT identified by TIGER
default tablespace bit;

--C:\oraclexe\app\oracle\product\11.2.0\server\sqlplus\admin 의 glogin.sql에 추가
ALTER USER SCOTT DEFAULT TABLESPACE bit;
ALTER USER SCOTT TEMPORARY TABLESPACE TEMP;

-- scott.sql 모두 실행해주는 명령어(SCOTT/TIGER에서 해줌)
@c:\lib\scott.sql

show linesize;
set linesize 300;

show pagesize;
set pagesize 20;

--C:\oraclexe\app\oracle\product\11.2.0\server\sqlplus\admin 의 glogin.sql에 추가 
-- 오라클 휴지통 비우기
purge recyclebin;
-- 관리자에서만 명령어 실행됨
select tablespace_name from dba_tablespaces;



