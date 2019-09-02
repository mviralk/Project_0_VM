
insert into accounts(userid, userpass) values ('user2','pass2');

insert into registration(firstName, lastName, DOB, SSN, userid, userpass) values ('kumar','mistry','09-SEP-94',123456789,'user1','pass1');

insert into SAVINGS_ACCT(saveacctid,userid,savetotamt,saveint) values (123,'user1',100,0.01);

insert into checking_ACCT(checkacctid,userid,checktotamt) values (456,'user1',200);

select * from accounts;
select initcap(firstName),initcap(lastName),userid,dob from registration;
select * from SAVINGS_ACCT;
select * from CHECKING_ACCT;
