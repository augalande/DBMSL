-- 1. Find the Student details and Placement details using NATURAL JOIN.  
select *
from student s
natural join placement_drive pd;

-- 2. Find all the student details with company_name who have conducted in same drive
select s.*,pd.pd_name
from student s
inner join placement_drive pd
on s.pd_id=pd.pd_id;

-- 3. List all the Student name and Student branch of Student having package 40 LPA
select s.s_name,s.department
from student s
inner join placement_drive pd
on s.pd_id=pd.pd_id
where salary = 40;

-- 4.List all the student names ,company_name having T_fee more than equal to 7500
select s.s_name,t.t_name,t.fee
from student s
inner join training t
on s.t_id=t.t_id
where t.fee>=7500;

--5. Display all training details attended by "Aryan Galande" in year 2018.  
select s.s_name,t.*
from student s
inner join training t
on s.t_id=t.t_id
where s.s_name='Aryan Galande' and t.t_year=2018;

--6. list the total number of companies who conduct training before 2020
select count(t_name)
from training
where training.t_year<2020;

--7. List the students name with company 'Google' and  location 'Pune'
select s.s_name
from student s
inner join placement_drive pd
on s.pd_id=pd.pd_id
where pd.pd_name='google' and pd.location='pune';

--8. Find  the names of all Students who have joined 'Google' training  in 2020 .
select s.s_name
from student s
inner join training t
on s.t_id=t.t_id
where t.t_name='google' and t.t_year=2020;

--9. Create a view showing the Student and Training details.  
create view view_student_training as
select s.*,t.t_name,t.fee,t.t_year
from student s
inner join training t
on s.t_id=t.t_id;
--Display created view
select * from view_student_training;

--10. Perform Manipulation on simple view-Insert, update, delete, drop view.  
create view view_student as
select s_name,cgpa
from student;

insert into view_student(s_name,cgpa)
values
('Joel Alphonso',8.8);

update view_student
set cgpa=7.8
where s_name='Joel Alphonso';

delete from view_student
where s_name='Joel Alphonso';

drop view view_student;




