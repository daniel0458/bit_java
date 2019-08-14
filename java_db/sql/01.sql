

alter user hr identified by hr account unlock;

sqlplus hr/hr

select * from tab;

conn system/1234
-- tablespace 생성
create tablespace bit
datafile 'c:\lib\bit.dbf'
size 30M
autoextend on next 2M maxsize UNLIMITED;--초기 크기 2MB 최대사이즈는 무제한

-- 계정 생성
create user test01 identified by 1234
default tablespace bit;

--권한 부여 test01/1234
grant connect to test01;
select * from tab;

--권한 삭제
revoke connect from test01;

--resource 권한까지 부여
grant connect,resource to test01;

--계정 삭제
drop user test01 cascade;

--SCOTT/TIGER 계정 생성
create user SCOTT identified by TIGER
default tablespace bit;

GRANT CONNECT,RESOURCE,TO SCOTT IDENTIFIED BY TIGER;

ALTER USER SCOTT DEFAULT TABLESPACE bit;
ALTER USER SCOTT TEMPORARY TABLESPACE TEMP;

@c:\lib\scott.sql --해당 sql파일의 명령을 전부 수행

show linesize;
set linesize 300;

show pagesize;
set pagesize 20;

--오라클 휴지통 비우기
PURGE RECYCLEBIN;   

cl scr;
select tablespace_name from dba_tablespaces;
