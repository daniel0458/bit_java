select * from emp;
select * from dept;
select ename,hiredate from emp;
select ENAME,HIREDATE from EMP;
SELECT ENAME,HIREDATE from EMP;

select ename,sal,comm from emp;

--연산 가능
select ename,sal,sal*12,comm from emp;

--as로 이름 바꾸기 가능	
select ename,sal,sal*12 as "년 봉",comm from emp;
--as생략
select ename,sal,sal*12 "년 봉",comm from emp;

select dname,loc from dept;

conn hr/hr
select * from employees;
select first_name,job_id,department_id from employees;

conn SCOTT/TIGER

--null을 포함한 산술식은 null이다
select empno, ename,sal,comm from emp;
select empno, ename,sal,comm,sal+comm 월급여 from emp;

--nvl(컬럼,값) 해당 컬럼값의 null값을 원하는값으로 바꿔줘  
select empno, ename,sal,comm,nvl(comm,0) 월급여 from emp;
select empno, ename,sal,comm,nvl(comm,0),sal+nvl(comm,0) 월급여 from emp;
select empno, ename,sal,comm,(sal+nvl(comm,0))*12 년봉 from emp;

select empno, ename,mgr,deptno from emp;
--nvl은 좌우값의 타입이 같아야한다.
select empno, ename,nvl(mgr,'CEO'),deptno from emp; --실행안됨

--to_char 문자로 형변환해주는 함수
select empno, ename,nvl(to_char(mgr),'CEO') mgr ,deptno from emp;
col mgr for a 10;

###문자열 연결 연산자 ||
select empno, ename,deptno from emp;
select empno||' '||ename||' '||deptno from emp;
--||을 사용하면 연결된 컬럼 내의 모든 값이 연결되서 출력된다.

select empno, ename,sal||'원' from emp;

--table의 row의 갯수 만큼 출력
select 10*24*24 from emp;

--dual은 가상의 테이블로 이를 써서 연산결과 출력가능
select 10*24*24 from dual;

select sysdate from dual;

## 중복제거 (distinct)

select job from emp;
select distinct job from emp;

select deptno from emp;
select distinct deptno from emp;

select * from emp;

## row 제한 where 절 사용

select 
from 
where

select *
from emp
where deptno=20;

select *
from emp
where job='manager';

## 대소문자 구분하지 않고 검색가능하도록 합니다
select *
from emp
where upper(job)=upper('MANAGER');

select sysdate from dual;

select *
from emp
where hiredate = '81/09/28';

select *
from emp
where hiredate <> '81/09/28';

select *
from emp
where hiredate != '81/09/28';

select *
from emp
where sal >= 3000 and sal <=5000;

select *
from emp
where sal between 3000 and 5000;

select *
from emp
where sal not between 3000 and 5000;

select *
from emp 
where deptno in(10,20);

select *
from emp 
where deptno not in(10,20);

select *
from dept
where (deptno,loc) in ((10,'DALLAS'),(30,'CHICAGO'));

## like 연산자
select *
from emp 
where ename='ALLEN';

--%이후에는 문자가 존재할 수 있다
select *
from emp 
where ename like 'AL%';

-- _개수만큼 사이에 문자가 존재하는 것을 찾는다
select *
from emp 
where ename like '%M_T%';

select * 
from emp
where hiredate like '81%';

##이름이 A,B,C,D로 시작하는 사원의 목록
select *
from emp
where ename like 'A%' or ename like 'B%' or ename like 'C%' or ename like 'D%';

##정규식 사용
select *
from emp
where regexp_like(ename,'A|B|C|D');

-- ^는 시작을 의미한다
select *
from emp
where regexp_like(ename,'^[A-D]');


-- $는 끝글자를 의미한다.
select *
from emp
where regexp_like(ename,'[A-D]$');

## null
select *
from emp
where comm is null;

## null
select *
from emp
where comm is not null; 

## row제한 where 절사용, 별칭사용안됨

select ename, sal, comm, sal+nvl(comm,0) total
from emp
where sal+nvel(comm,0)>3000;

select ename, sal, comm, sal+nvl(comm,0) total
from emp
where deptno = 20;

##정렬 order by 기본은  오름차순
select ename, sal, comm, sal+nvl(comm,0) total,deptno
from emp
order by deptno;

--내림차순
select ename, sal, comm, sal+nvl(comm,0) total,deptno
from emp
order by deptno desc;

select ename, sal, comm, sal+nvl(comm,0) total,deptno
from emp
order by total;

--n번째 컬럼으로 순서나열하면 order by에 n을 써줌
select ename, sal, comm, sal+nvl(comm,0) total,deptno
from emp
order by 2;
--순서정렬한것 내에서 다시 정렬가능
select ename, sal, comm, sal+nvl(comm,0) total,deptno
from emp
order by deptno desc,total;

select *
from emp
where deptno = 30
order by sal;

select *
from emp
where deptno in (20,30)
order by sal;

--any 는 in과 같은 기능을 한다
select *
from emp
where deptno = any(20,30)
order by sal;

select *
from emp
where deptno != all(20,30)
order by sal;

select *
from emp
where deptno <> all(20,30)
order by sal;

select * from employees
-----------------------------------
## 내장함수 p204 single row function

select * from dept;
select dname,loc from dept;
select dname,lower(dname),loc,lower(loc) from dept;

select 45.5678, 45.5678 from dual;
select round(45.5678), trunc(45.5678) from dual;

select sysdate, sysdate+30 from dual;

select ename, hiredate, substr(hiredate,1,2) 입사연도 from emp;
select sysdate ,to_char(sysdate,'yyyy') from dual;
select sysdate ,to_char(sysdate,'yy') from dual;
select sysdate ,to_char(sysdate,'day') from dual;


## emp 테이블에서 사원들의 입사월을 출력
select ename, to_char(hiredate,'mm') from emp;

select sysdate,to_date('2019/08/14') from dual;

select sysdate,to_date('08/14/19','MM/DD/YY') from dual;

## nvl() 함수 -- null을 value로 바꿔줌
select ename,mgr,nvl(to_char(comm),'_') from emp;
select ename,mgr,nvl(comm,0) from emp;

##nvl2(a,b,c); --null이 아니면 b,null이면 c
select ename,mgr,nvl2(comm,comm,0) from emp;

--nvl2의 경우 mgr이 정수형이지만 대체되는 값 yes,no 둘다 문자형이라 에러가 안남 
select ename,nvl2(mgr,'yes','no'),nvl2(comm,comm,0) from emp;

##decode 함수

select ename,sal, deptno, decode(deptno, 10 , sal*1,
										 20 , sal*2,
										 30 , sal*3,
										 sal) 계산 from emp;
