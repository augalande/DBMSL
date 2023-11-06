-- Simple Index
create index idx_s_name 
on student(s_name);

-- Complex Index
create index idx_pd_name_salary 
on placement_drive(pd_name,salary);

-- View-1:- Pune Placement Drives
create view view_pune_placement_drives as
select * from placement_drive
where location='pune';

-- View-2:- Computer Engineering Students
create view view_ce_students as
select * from student
where department='CE';

-- Display View-1:-
select * from view_pune_placement_drives;

-- Display View-2:-
select * from view_ce_students;
