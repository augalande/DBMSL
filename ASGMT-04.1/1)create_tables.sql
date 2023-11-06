create table Borrower(
    RollNo int primary key,
    Name varchar(255),
    DateOfIssue date,
    NameOfBook  varchar(255),
    status varchar(255)
);

create table Fine(
    RollNo int ,
    CurrDate date,
    amt int
);