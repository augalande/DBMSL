-- 2)Display all students details with department CE ‘and ‘IT’ and student name
-- starting with  'A' or 'S'.
select * from student 
where (department='CE' or department='IT') and (s_name like 'a%' or s_name like 's%');

-- 3)List the number of different companies.
select distinct pd_name
from placement_drive;

-- 4) Give 15% increase in fee of the Training  whose joining year is 2019.
select t_id,t_name,(fee*1.15) 
from training 
where t_year=2019;

-- 5) Delete Student details having CGPA score less than 7.5 
delete from student
where cgpa<7.5;

-- 6) Find the names of companies belonging to pune or Mumbai  
select pd_id,pd_name,salary from placement_drive
where (location = 'pune' or location='mumbai') ;

-- 7) Find the student name who joined training in  1-1-2019 as well as in 1-1-2021  
select s.s_id,t.t_id,s.s_name,t.t_year 
from student s,training t 
where s.t_id=t.t_id and (t.t_year=2019 or t.t_year=2021);

-- 8) Find the student name  having maximum CGPA score and names of students 
-- having CGPA score between  7 to 9 .
select s_id,s_name,cgpa 
from student 
where cgpa=(select max(cgpa) from student) or ( cgpa between 7 and 9);

-- 9) Display all Student  name with T_id  with decreasing order of Fees
select s.s_name,s.t_id,t.fee
from student s, training t
where s.t_id=t.t_id 
order by t.fee desc;

-- 10) Display Company name, S_name ,location and Package with Package  20, 40 and 50 
select s.s_name,pd.pd_name,pd.salary,pd.location
from student s, placement_drive pd
where s.pd_id=pd.pd_id and pd.salary in (20,40,50);