delimiter $$
create procedure proc_grade(in name varchar(255))
begin 
declare n varchar(255);
declare m int;
declare category varchar(255);
set n=name;
select marks into m from stud_marks where stud_marks.name=n;
if m>=990 and m<=1500 then
set category='Distinction';
elseif m>=900 and m<=989 then 
set category='First Class';
elseif m>=825 and m<=899 then 
set category='Higher Second Class';
end if;
update result set class=category where result.name=n;
end
$$
delimiter ;