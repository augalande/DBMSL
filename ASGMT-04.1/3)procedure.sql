delimiter $$
create procedure submit_book(in roll_no INT)
begin 

declare days int;
declare fine int;
declare error int;
declare issue_date date;

select Borrower.DateOfIssue into issue_date from Borrower where Borrower.RollNo=roll_no;

set days=datediff(curdate(),issue_date);

if days>=15 and days<=30 then
set fine=(days-15)*5;

elseif days>30 then
set fine=(days-30)*50+15*5;

end if;

begin 
declare exit handler for 1452 set error=1;
insert into fine values(roll_no,curdate(),fine);
update Borrower set status='Return' where Borrower.RollNo=roll_no;
end;

if error=1 then
select 'Invalid Roll No';
else
select 'Book Sucessfully Returned';
end if;

end;
$$
delimiter ;