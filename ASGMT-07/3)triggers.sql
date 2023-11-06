create trigger audit_update_trigger
before update on library
for each row
insert into audit(id,name,price) values(old.id,old.name,old.price);

create trigger audit_delete_trigger
before delete on library
for each row
insert into audit(id,name,price) values(old.id,old.name,old.price);
