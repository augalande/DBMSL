delimiter $$
create procedure calculate_area(in radius int)
begin
declare r int;
declare a float;
declare msg varchar(255);
declare exit handler for SQLSTATE'45000' select msg;
set msg='Invalid Radius';
set r=radius;
if r>=5 and r<=9 then 
set a=3.14*r*r;
insert into areas(radius,area) values (r,a);
else
signal SQLSTATE'45000';
end if;
end
$$
delimiter ;
