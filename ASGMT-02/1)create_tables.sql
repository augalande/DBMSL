create table training (
t_id int auto_increment primary key,
t_name varchar(255),
fee int,
t_year year );

create table placement_drive (
pd_id int auto_increment primary key,
pd_name varchar(255),
salary int,
location varchar(255) );

create table student (
s_id int auto_increment primary key,
pd_id int,
t_id int,
s_name varchar(255),
cgpa float,
department varchar(255),
foreign key (pd_id) references placement_drive(pd_id) on delete cascade,
foreign key (t_id) references training(t_id) on delete cascade );
