insert into training(t_name,fee,t_year)
values
('meta',5000,2019),
('amazon',2500,2018),
('netflix',7500,2020),
('apple',10000,2021),
('google',12000,2020) ;

insert into placement_drive(pd_name,salary,location)
values
('meta',20,'mumbai'),
('amazon',15,'pune'),
('netflix',25,'mumbai'),
('apple',40,'delhi'),
('google',50,'pune') ;

insert into student(pd_id,t_id,s_name,cgpa,department)
values
(1,2,'Aryan Galande',8.7,'CE'),
(1,3,'Suramya Jadhav',8.5,'CE'),
(3,4,'Ritesh Mahajan',8.6,'IT'),
(2,5,'Shubham Panchal',9.1,'ENTC'),
(5,3,'Swaraj Gosavi',8.9,'IT'),
(4,1,'Avnish Thakur',9.0,'ENTC'),
(4,2,'Suraj Mohite',8.2,'IT'),
(5,4,'Manav Mehta',8.1,'ENTC'),
(3,5,'Mayuresh Khankale',9.2,'CE'),
(3,1,'Niraj Karande',8.3,'CE'),
(4,5,'Ayush Meshram',7.4,'CE');

-- Display training table:-
select * from training;

-- Display placement_drive table:-
select * from placement_drive;

-- Display student table:-
select * from student;