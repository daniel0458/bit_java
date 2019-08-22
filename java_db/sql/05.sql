###############################
p231 view
###############################

뷰란?
-뷰는 하나의 가상테이블이라 생각하며노딘다.
-뷰는 실제 데이터가 저장되는 것은 아니지만 뷰를 통해 데이터를 관리할 수 있다.
-뷰는 복잡한 쿼리를 통해 얻을 수있는 결과를 간단한 쿼리로 얻을 수 있게한다.
-한개의 뷰로 여러 테이블에 대한 데이터를 검색할 수 있다.
-특정 평가기준에 따른 사용자 별로 다른 데이터를 엑세스할 수 있도록 한다.

select ename,sal,d.deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;

conn system/1234;
grant dba to SCOTT;
conn SCOTT/TIGER;

--없다면 생성 있다면 교체
create or replace view emp_dept 
as 
select ename,sal,d.deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;


drop view emp_dept;


create or replace view emp_dept 
as 
select ename,sal,hiredate,d.deptno,dname,loc
from emp e,dept d
where e.deptno = d.deptno;

select * from emp_dept;
select * from tab;


##자기가 속한 부서의 평균 급여보다 많이 받는 사람들의 명단을 뷰로 만드세요 highsalavg
create or replace view highsalavg
as
select ename,sal,deptno
from emp e 
where sal > (select avg(sal) from emp where deptno = e.deptno);

select * from highsalavg;
drop view highsalavg;

select * from emp;
select avg(sal) from emp;
select avg(sal) from emp where deptno=10;

create or replace view vvvv
select * from emp outer
where sal > (select avg(sal) from emp where deptno=outer.deptno);

######################################################
sequence
#####################################################

시퀀스란?
-유일(unique)한 값을 생성해주는 오라클 객체이다.
-시퀸스를 생성하면 기본키와 같이 순차적으로 증가하는 컬럼을 자동적으로 생성 할 수 있다.
-보통 primary key값을 생성하기위해 사용한다.
-메모리에 cache되었을 때 시퀀스값의 엑세스 효율이 증가한다.
-시퀸스는 테이블과는 독립적으로 저장되고 생성된다.
-oracle에서만 사용가능

delete from dept2;
select * from dept2;
select * from emp2;

create sequence deptno_seq;

insert into dept2 (deptno,dname,loc) values(deptno_seq.nextval,'인사부','비트');

select deptno_seq.currval from dual;

drop sequence deptno_seq;

create sequence deptno_seq start with 10 increment by 10;
	
delete from dept2;
commit;

insert into dept2 (deptno,dname,loc) values(10,'인사부','비트');
insert into dept2 (deptno,dname,loc) values((select nvl(max(deptno),0)+10 from dept2),'인사부','비트');

##########################################################
index
##########################################################

select * from dept;
select * from emp;

set autotrace on;

select * from emp where empno=7698;		//인덱스 기반
select * from emp where ename='FORD';	//full scan

create index emp_ename_idx on emp(ename);

drop index emp_ename_idx;

set autotrace off;



select index_name,table_name from user_indexes;

