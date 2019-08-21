select * from EMP;

select
from
where
order by

select ename,sal from EMP where deptno=10;

select ename,sal from EMP order by deptno;
select ename,sal,deptno from EMP order by deptno;

############################
join
############################

select ename, dname
from emp,dept
where emp.deptno = dept.deptno;

select ename, dname, dept.deptno
from emp,dept
where emp.deptno = dept.deptno;

select ename, d.deptno as 부서번호,dname, loc
from emp e,dept d
where e.deptno = d.deptno;

select *
from emp e,dept d
where e.deptno = d.deptno;

select *
from emp e,dept d
where e.deptno = d.deptno and sal > 2500;

############################
ANCI join 표준 ,=>join where=>on
############################

select ename,d.deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;

오라클 join==> 안시 join

select ename,d.deptno,dname,loc
from emp e join dept d
on e.deptno = d.deptno;

## join은 앞에를 생략하면 inner join
## inner join => 양쪽 테이블에 모두 있는 내용 출력

select ename,d.deptno,dname,loc
from emp e inner join dept d
on e.deptno = d.deptno
where sal > 2500;

########################################
outer join
########################################

select * from emp;
select * from dept;

*** +의 의미: null 쪽에 마킹 (아래 예시에는 e에는 존재하지 않는 요소라 e쪽에 +를 넣음)
select ename,sal,dname,loc,e.deptno
from emp e, dept d
where e.deptno(+) = d.deptno ;

오라클 join==> 안시 join

##right 쪽이 마스터 (기준이됨 왼쪽에서는 null인경우도 나옴)
select ename,sal,dname,loc,e.deptno
from emp e right outer join dept d
on e.deptno = d.deptno ;

##left 쪽이 마스터 (기준이됨 오른쪽에서는 null인경우도 나옴)
select ename,sal,dname,loc,e.deptno
from emp e left outer join dept d
on e.deptno = d.deptno ;

##############################################
non-equi join
##############################################

select * from salgrade;

select ename,sal,grade
from emp e , salgrade s
where sal between losal and hisal;

오라클 join==> 안시 join

select ename,sal,grade
from emp e join salgrade s
on sal between losal and hisal;

##########################################################
세개의 테이블 조인
##########################################################
--조인시 조건은 테이블 개수-1개이다.
select ename, sal, dname, loc, grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno and sal between losal and hisal
order by e.deptno;

select ename, sal, dname, loc, grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno and sal between losal and hisal and e.deptno = 20
order by e.deptno;

==> 안시 조인으로
## 다중 조인을 할때는 join하는 테이블마다 join 테이블 on 조건 형식으로 테이블 수 만큼 걸어줘야한다 

select ename, sal, dname, loc, grade
from emp e 
	join dept d 
	on e.deptno = d.deptno 
	join salgrade s
	on sal between losal and hisal
where e.deptno = 10
order by e.deptno;

#################
self join 
#################

select e.empno,e.ename 사원명,e.mgr, m.empno,m.ename 상사명
from emp e inner join emp m
on e.mgr = m.empno;

select e.empno,e.ename 사원명,e.mgr, m.empno,m.ename 상사명
from emp e left outer join emp m
on e.mgr = m.empno;

select e.empno,e.ename 사원명, nvl(m.ename,'<CEO>') 상사명
from emp e left outer join emp m
on e.mgr = m.empno;

## 상사보다 급여가 많은 사원 목록

select e.ename 사원명,e.sal, nvl(m.ename,'<CEO>') 상사명, m.sal
from emp e 
	join emp m
	on e.mgr = m.empno
where e.sal > m.sal;

select e.ename 사원명,e.sal,dname,loc, nvl(m.ename,'<CEO>') 상사명, m.sal
from emp e 
	join emp m
	on e.mgr = m.empno
	join dept
	on e.deptno = dept.deptno
where e.sal > m.sal;

#############################################
집계함수
#############################################

select ename, round(sal) from emp;
select avg(sal) from emp; -- avg같이 여러개의 데이터를 넣어서 하나의 결과값을 도출하는 함수를 집계함수라 한다

select round(avg(sal)) 평균급여 from emp;

select count(empno),count(comm),count(*),count(mgr),round(avg(sal)) 평균급여
from emp;

select count(job) from emp;
select count(distinct job) from emp;

select sum(sal) , count(*), round(avg(sal)),sum(sal)/count(*)
from emp;

select round(avg(sal)) 평균급여 from emp;
select round(avg(sal)) 평균급여 from emp where deptno=10;
select round(avg(sal)) 평균급여 from emp where deptno=20;
select round(avg(sal)) 평균급여 from emp where deptno=30;
select round(avg(sal)) 평균급여 from emp where deptno=40;

select * from emp order by deptno;


## group by 는 집계함수를 이용하겠다는 의미와 같다

select deptno,round(avg(sal)) 평균급여
from emp
group by deptno;


## 부서 이름별 평균 급여 구하기
select e.deptno, dname ,round(avg(sal)) 평균급여
from emp e
	join dept d
	on e.deptno = d.deptno
group by dname,e.deptno
order by 1;

select max(sal),min(sal),count(*),avg(sal) from emp;

select deptno,max(sal),min(sal),count(*),avg(sal) 
from emp
group by deptno;

## 부서별 평균 급여가 200이상인 리스트
select e.deptno, dname ,round(avg(sal)) 평균급여
from emp e
	join dept d
	on e.deptno = d.deptno
group by dname,e.deptno
having round(avg(sal)) > 2000
order by 1;

#############################
#	select					#
#	from					#
#	where					#
#	group by				#
#	having					#
#	order by				#
#############################

select e.deptno, dname ,round(avg(sal)) 평균급여
from emp e
	join dept d
	on e.deptno = d.deptno
where sal > 1000
group by dname,e.deptno
having round(avg(sal)) > 2000
order by 1;

##################################
sub Query
##################################

## FORD 보다 급여를 많이 받는 사원 리스트
select *
from emp
where sal > (select sal from emp where ename='FORD');

## 평균 급여보다 적게 받는 사원목록
select *
from emp
where sal < (select avg(sal) from emp);

select *
from emp
where sal = (select min(sal) from emp);

########################################
스칼라=단일값		벡터=다중값
########################################

## 각 부서에서 급여가 가장 적은 사원 리스트 
select deptno,ename,sal
from emp
where sal in (select min(sal) from emp group by deptno);

## 각 부서에서 급여가 가장 많은 사원 리스트 
select deptno,ename,sal
from emp
where sal in (select max(sal) from emp group by deptno);

select deptno,ename,sal
from emp
where (sal,deptno) in (select deptno,max(sal) from emp group by deptno);

############################################################
상관관계 서브쿼리 : outer 쿼리의 컬럼중 하나가 inner 쿼리문에서 사용되는 쿼리문
############################################################

##자신이 속한 부서의 평균 급여보다 적은 사원 리스트
select *
from emp outer
where sal > (select avg(sal) from emp where deptno = outer.deptno);

#################
rownum
#################

--기존의 상태에서 order by로 정렬해버리면 rownum이 뒤죽박죽이 된다.
select rownum,ename,sal,deptno,hiredate
from (select * from emp order by sal desc);

select rownum,ename,sal,deptno,hiredate
from (select * from emp order by sal desc)
where rownum < 4;

##주의 rownum은 1을 기준으로 접근해야만 한다.
select rownum,ename,sal,deptno,hiredate
from (select * from emp order by sal desc)
where rownum > 4;


select rownum,ename,sal,deptno,hiredate
from (select * from emp order by sal desc)
where rownum between 1 and 4;

select rownum,ename,sal,deptno,hiredate
from (select * from emp order by sal desc)
where rownum between 4 and 7;
