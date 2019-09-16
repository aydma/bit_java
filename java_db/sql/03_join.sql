select * from EMP;

select
from 
where 
order by 

select ename, sal from EMP where deptno=10;

select ename, sal from EMP order by deptno; 
select ename, sal from EMP where deptno=10 order by deptno; -- select 는 제일마지막에 수행하기때문에 deptno찾기가능
 
################################################
join
################################################

select ename, dname
from emp,dept;  -- 12개 4개 정보를 곱해서 48개가 나옴 그래서 where절에 조건줌

select ename, dname
from emp,dept
where emp.deptno = dept.deptno; -- fk,pk키비교

select ename, dname, deptno
from emp,dept
where emp.deptno = dept.deptno;  -- 에러남 select deptno때문

select ename, dname , dept.deptno 부서번호, dname, loc
from emp e, dept d
where emp.deptno = dept.deptno; -- 테이블이름을 얼라이브시켰으면 적용해야함

select ename, dname , d.deptno 부서번호, dname, loc
from emp e, dept d
where e.deptno = d.deptno;

select *
from emp e, dept d
where e.deptno = d.deptno;

select *
from emp e, dept d
where e.deptno = d.deptno and sal>2500; -- 조건 2개줄때 and

#########################################################
ANCI join 표준          ,=>join          where=>on
==> ANCI join으로 바꿀때 테이블 3개면 테이블 join 테이블 on 조건 join 테이블 on 조건 순서
where가 join조건하고 연관이 있을때만 on으로 바꿈
#########################################################
select ename, dname , d.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno;

오라클 hoin ==> 안씨 join

select ename, dname , d.deptno, dname, loc
from emp e join dept d   --join 앞에는 inner가 생략되어있다. 양쪽의 정보를 다 확인할때 
on e.deptno = d.deptno;

## inner join => 양쪽 테이블에 모두 있는 내용 출력

select ename, dname , d.deptno, dname, loc
from emp e inner join dept d        
on e.deptno = d.deptno
where sal > 2500;

################################################
outer join
################################################

select * from emp;
select * from dept; 

*** + null 쪽에 마킹 

select ename, sal, dname, loc, e.deptno
from emp e, dept d
where e.deptno(+) = d.deptno;  -- null쪽에 +마킹하는게 outer방식이다. d에는 정보있고 e에 정보없으니까 e에 +마킹

ANCI방식으로 변경

select ename, sal, dname, loc, e.deptno
from emp e join dept d
on e.deptno(+) = d.deptno; 

## right outer, left outer 기준으로 테이블이 가지고 있는 정보 모두 출력할때
## emp가 마스터(기준)면 left dept가 마스터(기준)면 right alter 
## right 쪽이 마스터 즉 dept테이블이 마스터 테이블이 되어 모두 출력
select ename, sal, dname, loc, e.deptno
from emp e right outer join dept d
on e.deptno = d.deptno; 

## left 쪽이 마스터 즉 emp테이블이 마스터 테이블
select ename, sal, dname, loc, e.deptno
from emp e left outer join dept d
on e.deptno = d.deptno; 

#######################################
non-equi join
#######################################
select * from salgrade;

select ename, sal, grade
from emp e, salgrade s
where sal between losal and hisal; -- fk,pk관계가 아니면 btween and 관계로 처리함.

==> ANCI로 바꿈
select ename, sal, grade
from emp e join salgrade s
on sal between losal and hisal;

#######################################
세개의 테이블 조인
#######################################
select ename, sal, dname, loc, grade
from emp e, dept d, salgrade s
where e.deptno=d.deptno and sal between losal and hisal
order by e.deptno;

select ename, sal, dname, loc, grade
from emp e, dept d, salgrade s
where e.deptno=d.deptno and sal 
		between losal and hisal 
		and e.deptno=20 -- dept가 20번인부서
order by e.deptno;

==> ANCI join으로 바꿈 테이블 3개면 테이블 join 테이블 on 조건 join 테이블 on 조건 순서
select ename, sal, dname, loc, grade
from emp e 
	join dept d 
	on e.deptno=d.deptno
	join salgrade s
	on sal between losal and hisal
order by e.deptno;

-- 부서번호가 10번인 사람중에서 찾기
select ename, sal, dname, loc, grade
from emp e 
	join dept d 
	on e.deptno=d.deptno 
	join salgrade s
	on sal between losal and hisal 
where e.deptno=10	
order by e.deptno;

#########################################
self 조인 => 하나의 테이블에서 조건걸기
#########################################
-- 사원의 이름, 상사의 이름 뽑기
select e.empno, e.ename 사원명, e.mgr, m.empno, m.ename 상사명 
from emp e, emp m
where e.mgr = m.empno;
-- null값 뽑아내기 위해서 outer join걸기
select e.empno, e.ename 사원명, e.mgr, m.empno, m.ename 상사명 
from emp e, emp m
where e.mgr = m.empno(+);
==> ANCI join 으로 변경
select e.empno, e.ename 사원명, e.mgr, m.empno, m.ename 상사명 
from emp e join emp m
on e.mgr = m.empno(+);

select e.empno, e.ename 사원명, e.mgr, m.empno, m.ename 상사명 
from emp e left outer join emp m
on e.mgr = m.empno;

select e.empno, e.ename 사원명, m.ename 상사명 
from emp e left outer join emp m 
on e.mgr = m.empno; 

select e.empno, e.ename 사원명, nvl(m.ename, 'CEO') 상사명 
from emp e left outer join emp m 
on e.mgr = m.empno; 

## 상사보다 급여가 많은 사원 목록
select e.ename 사원명, e.sal, m.ename 상사명, m.sal
from emp e, emp m 
where e.mgr=m.empno and e.sal>m.sal;

select e.ename 사원명, e.sal, e.dept m.ename 상사명, m.sal
from emp e, emp m, dept d
where e.mgr=m.empno and e.sal>m.sal;

select e.ename 사원명, e.sal, dname 부서명, loc, m.ename 상사명, m.sal
from emp e 
	join emp m 
	on e.mgr=m.empno 
	join dept d
	on e.deptno = d.deptno
where  e.sal>m.sal;

#########################################################
집계함수
#########################################################
select ename, round(sal) from emp; 
select avg(sal) from emp; -- sal의 모든값이 들어와서 더해지고 나눠져서 하나의 결과값이 나오는 집계함수

select ename, avg(sal) from emp; -- ename때문에 에러남

select round(avg(sal),2) 회사평균급여 from emp; -- 평균급여 소수점둘째자리까지

-- count는 null값도 센다
select count(empno),count(comm),count(*),count(mgr), round(avg(sal),2) 회사평균급여 
from emp; 

select count(job) from emp;
select count(distinct job) from emp; -- distinct 중복제거

select sum(sal), count(*), round(avg(sal)),sum(sal)/ count(*) from emp;

select round(avg(sal)) 평균급여 from emp where deptno = 10;
select round(avg(sal)) 평균급여 from emp where deptno = 20;
select round(avg(sal)) 평균급여 from emp where deptno = 30;
select round(avg(sal)) 평균급여 from emp where deptno = 40;

select * from emp order by deptno;

select deptno, round(avg(sal)) 평균급여
from emp
group by deptno;

## 부서 이름 별 평균 급여
select emp.deptno, dname, round(avg(sal)) 평균급여
from emp, dept
where emp.deptno = dept.deptno
group by dname, emp.deptno
order by 1;


select max(sal),min(sal),count(*),avg(sal) from emp;

select deptno, max(sal), min(sal), count(*),avg(sal) 
from emp
group by deptno;

## ANCI기반으로 바꾸기
select emp.deptno, dname, round(avg(sal)) 평균급여
from emp 
	join dept
	on emp.deptno = dept.deptno
group by dname, emp.deptno
order by 1;

## 순서 ##################
# select				#
# from					#	
# where					#
# group by				#
# having 				#
# order by				#
#########################

## 부서별 평균 급여가 2000이상인 부서 리스트
having -- group by이후의 값을 처리할때 

select emp.deptno, dname, round(avg(sal)) 평균급여
from emp, dept
where emp.deptno = dept.deptno
group by dname, emp.deptno
having avg(sal)>2000-- group by이후의 값을 where로 이용할때 
order by 1;

## ANCI기반으로 바꾸기
select emp.deptno, dname, round(avg(sal)) 평균급여
from emp 
	join dept
	on emp.deptno = dept.deptno
group by dname, emp.deptno
having avg(sal)>2000
order by 1;

#####################################
sub Query
#####################################
## FORD 보다 급여를 많이 받는 사원 리스트
select sal from emp where ename = 'FORD';

select * from emp where sal > 3000;

## FORD 보다 급여를 많이 받는 사원 리스트 위의 2문장 합친 서브쿼리
select * 
from emp 
where sal > (select sal from emp where ename = 'FORD');

## 평균 급여보다 적게 받는 사원 목록
select *
from emp 
where sal < (select round(avg(sal)) from emp);

## 우리 회사에서 가장 적은 급여를 받는 사원
select *
from emp 
where sal = (select min(sal) from emp);

##########################################
스칼라=단일값    벡터=다중값     =은 스칼라가 와야함 in은 벡터기반이 와도 됨
##########################################
## 각각의 부서에서 급여가 가장 작은 사원 리스트 
select deptno, ename, sal
from emp 
where sal = (select min(sal) from emp group by deptno); -- 싱글이랑 그룹이라서 비교불가능 집합연산자 IN써야함

select deptno, ename, sal
from emp 
where sal in (select min(sal) from emp group by deptno); -- 집합연산자 IN

## 각각의 부서에서 급여가 가장 많은 사원 리스트 
select deptno, ename, sal
from emp 
where sal in (select max(sal) from emp group by deptno);  -- 이거는 부서2개의 최대값이 같게되면 결과가 정확히 나오지 않는다.

select deptno, ename, sal
from emp 
where (deptno,sal) in (select deptno, max(sal) from emp group by deptno); -- deptno까지 비교해야 훨씬 정확한 정보임

##############################################################
상관관계 서브쿼리 : outer 쿼리의 컬럼중 하나가 inner 쿼리문에서 사용되는 쿼리문 
##############################################################

## 자신이 속한 부서의 평균 급여보다 적은 사원 리스트 
select *
from emp outer
where sal < (select round(avg(sal)) from emp where deptno = outer.deptno);

##########################
rownum => row에 번호가 매겨짐
##########################

select rownum, ename, sal, hiredate
from emp
order by sal desc;

-- 정렬후에 rownum을 주기
select rownum, ename, sal, hiredate
from ( select * from emp order by sal desc );

-- 정렬후에 rownum을 주고 top3뽑기
select rownum, ename, sal, hiredate
from ( select * from emp order by sal desc )
where rownum<4;

## 주의
select rownum, ename, sal, hiredate
from ( select * from emp order by sal desc )
where rownum>4;                         -- 오류남 rownum은 실행되면서 1부터 만들어지기때문에 갑자기 4랑 비교할수 없다.
										-- 무조건 1부터 접근해야한다.

select rownum, ename, sal, hiredate
from ( select * from emp order by sal desc )
where rownum between 1 and 4;             -- 1부터 접근해서 가능

select rownum, ename, sal, hiredate
from ( select * from emp order by sal desc )
where rownum between 4 and 7;          -- 오류남

############################################
page(페이지) 처리
############################################

select * from (
select rownum row#, ename, sal, hiredate
from ( select * from emp order by sal desc )
)
where row# between 6 and 10;       -- 이렇게하면 1부터 안해도 나눠짐


         	        start       end
1page 1=5 	        5*0+1		+4        
2page 6-10			5*0+1		+4
3page 11-15			5*0+1		+4


select * from (
    select rownum row#,deptno,dname,loc
    from (select * from dept order by deptno)
) where row# between 4 and 6;








