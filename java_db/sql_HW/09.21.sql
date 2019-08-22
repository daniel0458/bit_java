//테이블 생성
create table users (
	id varchar2(10) constraint user_id primary key,
	password varchar2(10),
	name varchar2(8),
	role varchar(10)
);

create table board (
	seq number(4) constraint board_number primary key,
	title varchar2(20),
	content varchar2(1000),
	regdate date default sysdate,
	cnt number(4) default 0,		--조회수
	id varchar2(10) ,
	constraint board_fk foreign key(id) references users(id)
);


회원 등록
insert into users values('daniel','123','성현','client'); 

회원정보 수정
update users 
set role='manager' 
where id='daniel';

로그인
select *
from users
where id = 'daniel' and password = '123';

게시판 글등록
insert into board 
values((select nvl(max(seq),0)+1 from board),'hello','hello world',sysdate,0,'daniel');

글수정
update board
set content='Hello World'
where seq=1;

게시판 글 삭제
delete from board where seq=1;



데이터검색

전체 등록글 수
select count(seq) from board;

사용자별 등록글수
select count(*) from board group by id;

월별 게시글 수
select count(*) from board group by to_char(regdate,'mm');

사용자별 게시글 검색
select seq,title,regdate,id from board where id = 'daniel';

제목으로 게시글 검색
select seq,title,regdate,id from board where title like 'he%';