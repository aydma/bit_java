select * from emp;
select * from dept;
select ename,hiredate from emp; 
select Ename,HIREDATE from emp;
SELECT Ename,HIREDATE FROM emp;

desc dept;   -- dept테이블 요약정보
select ename,sal,comm from emp;

select ename,sal,sal*12,comm from emp; -- 컬럼에 연산가능

select ename,sal,sal*12 as "연  봉",comm from emp; -- 컬럼 이름 변경할때만 ""사용
select ename,sal,sal*12 "연  봉",comm from emp; -- 컬럼이름줄때""안해도 as생략가능

select DNAME,LOC from dept;


conn hr/hr
select * from employees;
select first_name,job_id,department_id from employees;


conn SCOTT/TIGER

null을 포함한 산술식은 null
select empno,ename,sal,comm from emp;
select empno,ename,sal,comm,sal+comm from emp;
select empno,ename,sal,comm,sal+comm 월급 from emp;

select empno,ename,sal,comm,nvl(comm,0) from emp; -- nvl(comm,0) comm의 값이 널일때 0로 바꿈
select empno,ename,sal,comm,nvl(comm,0),sal+nvl(comm,0) 월급 from emp;
select empno,ename,sal,comm,nvl(comm,0),sal+nvl(comm,0) 월급, (sal+nvl(comm,0))*12 연봉 from emp;--연봉

select empno,ename,mgr,comm from emp;
select empno,ename,nvl(mgr,'CEO'),deptno from emp; -- 형이 달라서 안됨
select empno,ename,nvl(to_char(mgr),'CEO') as mgr,deptno from emp; -- 문자열로 변환to_char()

### 문자열 연결 연산자 ||

select empno, ename, deptno from emp;
select empno || ename || deptno from emp;
select empno ||'  '||ename||'  '||deptno from emp; -- || 사이에 공백넣기

select empno,ename,sal||'원' from emp; -- 필드옆에 문자붙이기


## dual 가상의 테이블
select 10*24*24 from emp; -- emp테이블의 열이 12개라서 값이 12개나옴
select 10*24*24 from dept; -- dept테이블의 열이 4개라서 값이 4개나옴
select 10*24*24 from dual; -- 가상의 테이블dual

select sysdate from dual; -- 오늘날짜나옴

## 중복제거 (distinct)
select job from emp;
select distinct job from emp;

select deptno from emp;
select distinct deptno from emp;

select * from emp;

-- 조건검색(where)
## row 제한 where 절 사용, 별칭 사용 안됨
select 
from 
where 

select *
from emp
where deptno = 10;

select *
from emp
where job='manager'; -- where절은 대소문자 구분함

select *
from emp
where job='MANAGER';

## 대소문자 구분하지 않고 검색 가능 하도록 합니다.
select *
from emp
where UPPER(job)=UPPER('manager'); -- 대문자 변환함수 UPPER(), 소문자 변환함수 LOWER()

select sysdate from dual;

select *
from emp
where hiredate = sysdate;
 -- '81/09/28'이날 입사
select *
from emp
where hiredate = '81/09/28';
 -- '81/09/28' 이날 후에입사
select *
from emp
where hiredate > '81/09/28';
 -- '81/09/28' 이날 전에입사
select *
from emp
where hiredate < '81/09/28';
 -- '81/09/28'이 아닌 사람 <>은 !=와같음
select *
from emp
where hiredate <> '81/09/28';
select *
from emp
where hiredate != '81/09/28';
-- sal이 3000이상5000이하인사람
select *
from emp
where sal >= 3000 and sal <= 5000;
--위와 동일조건
## between 상한가 and 하한가
select *
from emp
where sal between 3000 and 5000;

select *
from emp
where sal between 5000 and 3000; -- 못찾음 앞에 작은값 뒤에 큰값줌

select *
from emp
where sal not between 3000 and 5000;

-- 부서번호 10번과 20번인 사람들
select *
from emp
where deptno = 10 or deptno = 20;

## 집합연산자 IN
select *
from emp
where deptno IN(10,20);
-- 부서번호 10번과 20번이 아닌 사람들
select *
from emp
where deptno not IN(10,20);
-- deptno가10이고 loc가DALLAS또는 deptno가30이고 loc가CHICAGO
select *
from dept
where (deptno,loc ) IN((10,'DALLAS'),(30,'CHICAGO')); 

## like 연산자
select *
from emp
where ename='ALLEN';
-- emane이 A로 시작하는사람
select *
from emp
where ename like 'S%'; 
-- emane에 S가 들어가는 사람
select *
from emp
where ename like '%S%'; 
-- emane에 M과 T사이에 한글자(_)가들어가는사람
select *
from emp
where ename like '%M_T%'; 

##81년도에 입사한 사원 목록 추출
select *
from emp
where hiredate like '81%';

select *
from emp
where hiredate like '82%';

## 이름이 A B C D 로 시작하는 사원의 목록
-- like사용하면 In을 못씀
select *
from emp
where ename like 'A%' or ename like 'B%'or ename like 'C%'or ename like 'D%';

##정규식 사용
-- 이름중에 A,B,C,D를 포함하는 사람들
select *
from emp
where regexp_like( ename,'A|B|C|D' ); 

select *
from emp
where regexp_like( ename,'[A-D]' ); 

-- 이름의 첫시작이 A,B,C,D인 사람들 
select *
from emp
where regexp_like( ename,'^[A-D]' ); -- ^가 시작
-- 이름의 끝글자가 A,B,C,D인 사람들
select *
from emp
where regexp_like( ename,'[A-D]$' );

## null

select *
from emp
where comm is null; -- null비교는 is

select *
from emp
where comm is not null;

## row 제한 where 절 사용, 별칭 사용 안됨
select ename, sal, comm, sal+nvl(comm,0) totlal
from emp
where total > 3000;     -- total 이 별칭이라 사용못함

select ename, sal, comm, sal+nvl(comm,0) totlal
from emp
where sal+nvl(comm,0) > 3000; 

select ename, sal, comm, sal+nvl(comm,0) totlal
from emp
where deptno = 20;   -- select에 보이지 않는 칼럼도 사용가능

## 정렬 order by 기본 오름차순 
select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp
order by deptno;

select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp
order by deptno desc; -- 내림차순

--order by에서는 별칭사용가능
select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp
order by total desc; 

select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp
order by 2; -- 2번째컬럼인 sal기준으로 정렬

select ename, sal, comm, sal+nvl(comm,0) total, deptno
from emp
order by deptno desc, total;  -- 1차오름차순deptno기준  2차내림차순 total기준정렬

select *
from emp 
where deptno = 30
order by sal;

select *
from emp 
where deptno in (20,30)
order by sal;
-- in이랑 결과같음
select *
from emp 
where deptno = any (20,30) 
order by sal;

select *
from emp 
where deptno != all (20,30) -- 부서번호 20,30아닌 사람들
order by sal;
-- 부서번호 20,30아닌 사람들
select *
from emp 
where deptno <> all (20,30) 
order by sal;



## 내장함수 p204 single row function

select * from dept;
select dname,loc from dept;
select dname,lower(dname),loc,lower(loc) from dept; -- 프로시져는 리턴값이 없음 lower()은 function

select round(45.5678), trunc(45.5678) from dual; -- round()반올림, trunc()소수점자름
select round(45.5678,2), trunc(45.5678,2) from dual; -- round()소수점둘째자리에서반올림, trunc()둘째소수점이후자름

select sysdate, sysdate+1 from dual;

select ename, hiredate from emp;
-- 입사년도만 뽑아내기 -- 오라클인덱스는 1
select ename, hiredate, substr(hiredate,1,2) 입사연도 from emp;

select sysdate, to_char(sysdate, 'yyyy') from dual;  -- 연도 4자리
select sysdate, to_char(sysdate, 'yy') from dual;    -- 연도 2자리
select sysdate, to_char(sysdate, 'day') from dual;   -- 요일

## emp 테이블에서 사원들의 입사월을 출력해보세요.

select ename, hiredate, to_char(hiredate, 'mm') 입사월 from emp;

select sysdate, to_date('2019/08/14') from dual; 

select sysdate, to_date('08/04/19') from dual;     -- 08년4월19일로 알아들음
select sysdate, to_date('08/04/19','mm/dd/yy') from dual; -- 년도가 어딘지알려주기

## nvl() 함수
select ename, mgr, comm from emp;

#nvl(a,b)함수 -- 숫자는 오른쪽정렬 문자는 왼쪽정렬함
select ename, mgr, nvl(to_char(comm), '_') from emp; -- '_'문자니까 숫자comm을문자로변환  
select ename, mgr, nvl(comm, 0) from emp; 

#nvl2(a,b,c)함수  -- 값이 있을때와 없을때 구분
select ename, mgr, nvl2(comm,comm, 0) from emp;  -- comm이 있으면 comm표시, 없으면 0표시
select ename, nvl2(mgr, 'yes', 'no'), nvl(comm, 0) from emp; -- mgr이 있으면 yes표시, 없으면 no표시

## decode 함수 -- else if랑 비슷함
-- deptno가 10이라면 sal에 1을 곱함, 20이면 2,30이면3, 아니면 그대로 sal
select ename, sal, deptno, decode(deptno, 10, sal*1, 
										  20, sal*2,
										  30, sal*3,
										  sal) 계산
from emp;


-- madang/madang 계정 생성후 실행합니다.
-- TABLESPACE는 bit 로 지정합니다.
create user madang identified by madang
default tablespace bit;

-- 권한은 connect,resource 권한을 부여합니다.
-- 리소스까지 만들수있는 권한부여 (로그인가능, 테이블생성가능, 자원사용가능)
grant connect,resource to madang;

@c:\lib\demo.sql

-- 계정 삭제 test01
drop user madang cascade;
