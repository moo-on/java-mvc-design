-- member table 
create table member(
num int primary key auto_increment,
id varchar(20) not null,
pass varchar(20) not null,
name varchar(30) not null,
age int not null,
email varchar(30) not null,
phone varchar(30) not null
)
-- SQL(CRUD), JDBC

--�˻�
select * from member;

-- insert
insert into member(id, pass, name, age, email, phone)
value('admin','admin','������','19','ex@gmail.com','010-0000-0000');

-- update
update member set age = 20, phone = '010-1111-1111' where id = 'admin';

-- delete
delete from meber where id = 'admin';