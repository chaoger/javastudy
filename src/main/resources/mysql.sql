drop database if exists javastudy;
create database javastudy;
USE javastudy;
create table user (
  id int(10) auto_increment not null primary key,
  name varchar(64) not null,
  address varchar(128) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';
insert into user values(null,'chaoger','网易');
insert into user values(null,'python','海康');
