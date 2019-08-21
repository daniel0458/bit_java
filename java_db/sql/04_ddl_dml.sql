#########################################################
table 생성 	DDL(Data Definition Language) -auto commin이라 취소가 안됨

테이블은 실제로 데이터들이 저장되는 곳이라고 생각하면 쉽게 이해할 수 있으며,
create table 명령어를 이용ㅇ해서 테이블을 생성할 수 있다
########################################################

drop table book;
create table book(
	bookno  number(5)     constraint scott_book_pk primary key,   --중복안되면서 null비허용
	title   varchar2(30)  constraint scott_book_title_unique unique, --중복안됨 null허용
	author  varchar2(30) ,
	price   number(7,2)   constraint book_price_check check(price>0),
	pubdate date default sysdate
);

alter table book add(price number(7));
alter table book modify(price number(7,2));
alter table book drop column price;
rename book to book2;
rename book2 to book;

insert into book (bookno,title,author,pubdate,price) values(4,'db',null,null,900);
delete from book where author = '홍';
update book set author='~~~~',price=900,pubdate=sysdate where bookno=3;

delete from book;		--복구가능 
rollback;
truncate table book;	--복구 불가 , 테이블은 남음
drop table book;		--복구 불가, 테이블도 삭제



select * from book;
#################################################################################
#################################################################################

select * from emp;
select * from dept;

--테이블을 통째로 복사하나 제약조건은 복사되지 않는다.
create table emp2 as select * from emp;
create table dept2 as select * from dept;

insert into dept values(50,'EDU','SEOUL');
insert into dept2 values(50,'EDU','SEOUL');

insert into dept values(10,'EDU','SEOUL');
insert into dept2 values(10,'EDU','SEOUL');

insert into emp2 (empno,ename,hiredate,sal,deptno) values(9999,'홍길동',sysdate,0,90);
insert into emp (empno,ename,hiredate,sal,deptno) values(9999,'홍길동',sysdate,0,40);

#########################################
트랜젝션
#########################################
create table emp2 as select * from emp;
select * from emp2;

창1
delete from emp2 where deptno=10;


창2
update emp2 set comm=0 where deptno=10; --창1에서 변경된 내용이 commit이 이뤄지지 않았기 때문에 블락된다.
										--commit하고나면 변경가능
block 되는거 확인 => 창1에서 commit or rollback 명령 수행하면 lock 풀림

--dml -취소가능
insert into book values(1,'java','kim',sysdate);
insert into book values(2,'jsp','홍',sysdate);
insert into book values(2,'jsp','홍',sysdate);
insert into book values(2,'jsp','홍','19/02/02');
commit;
rollback; --commit되지 않은 내용을  취소

insert into book(bookno,title) values(3,'db');
insert into book(bookno,title,author,pubdate) values(4,'db',null,null);

 delete from book;
rollback;
delete from book where title='db';
delete from book where author is null;
delete from book where author = '홍';


desc book; //테이브블 구조를 보여줌

alter table book add(price number(7)); --구조 변경 컬럼 추가
insert into book (bookno,title,author,pubdate,price) values(4,'db',null,null,900);

update book set price=1000.99;
commit;
rollback;
update book set price=900 where title='db';
select * from book;

update book set author='~~~~',price=900,pubdate=sysdate where bookno=3;

update book set price = null;
alter table book modify(price number(7,2));
update book set price=1000.99;
commit;

alter table book drop column price;

#################################################################
drop table book;
create table book(
	bookno  number(5)     constraint scott_book_pk primary key,   --중복안되면서 null비허용
	title   varchar2(30)  constraint scott_book_title_unique unique, --중복안됨 null허용
	author  varchar2(30) ,
	price   number(7,2)   constraint book_price_check check(price>0),
	pubdate date default sysdate
);


insert into book (bookno,title,author,price,pubdate) 
				values(2,'jsp','홍길동',22000,sysdate);

insert into book (bookno,title,author,price,pubdate) 
				values(3,'java','김길동',32000,default);

commit;

select CONSTRAINT_name
from user_cons_columns
where table_name='BOOK';




drop table book;
create table book(
	bookno  number(5)   ,
	title   varchar2(30)  unique, --중복안됨 null허용
	author  varchar2(30) ,
	price   number(7,2)   check(price>0),
	pubdate date default sysdate
);

alter table book add CONSTRAINT book_bookno_pk primary key(bookno);
alter table book drop CONSTRAINT book_bookno_pk;

insert into book (bookno,title,author,price,pubdate) 
				values(1,null,'김길동',32000,default);

insert into book (bookno,title,author,price) 
				values(5,null,'최길동',32000);
				
select CONSTRAINT_name
from user_cons_columns
where table_name='BOOK';
				
#####################################################################
emp   dept
#####################################################################
delete from dept where deptno=50;
commit;

drop table dept2;		
create table dept2 as select * from dept;
alter table dept2 add constraint dept2_pk primary key(deptno);

drop table emp2;
create table emp2 as select * from emp;
alter table emp2 add constraint emp2_pk primary key(empno);

alter table emp2 add constraint emp2_fk_mgr foreign key(mgr) references emp2; 

alter table emp2 add constraint emp2_fk1 foreign key(deptno) references dept2;

delete from dept2 where deptno=20; --안됨



alter table emp2 drop constraint emp2_fk1 ; 

alter table emp2
add constraint emp2_fk1
foreign key(deptno) references dept2 ON DELETE SET NULL; --삭제되고 자식은 null로
rollback;

alter table emp2 drop constraint emp2_fk1 ; 

alter table emp2
add constraint emp2_fk1
foreign key(deptno) references dept2 ON DELETE cascade; --삭제되고 자식튜플도 삭제

delete from dept2 where deptno=20; --됨 , delete조건절의 차이
rollback;

select * from dept2;
insert into dept2 values(50,'EDU','SEOUL');

select * from emp2;
insert into emp2 (empno,ename,hiredate,sal,deptno)
			values(9999,'홍길동',sysdate,0,50);
insert into emp2 (empno,ename,hiredate,sal,deptno)
			values(7777,'고길동',sysdate,0,null);
insert into emp2 (empno,ename,hiredate,sal,deptno,mgr)
			values(8888,'이길동',sysdate,0,null,10);
			
drop table emp2 cascade constraint; 
drop table dept2 cascade constraint; 