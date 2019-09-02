create table mist_users(
username varchar2(100) primary key,
firstName varchar2(100) not null,
lastName varchar2(100) not null,
DOB date not null,
SSN number not null,
phonenumber number not null
);

create table mist_login(
serialnum number primary key,
username varchar2(100) not null,
userpassword varchar(100) not null
);

create table mist_savings_account(
savingaccountnumber number primary key,
username varchar(100) not null,
savingavailablebalance number default 0,
savingcurrentbalance number default 0,
savingintrest number
);

create table mist_checking_account(
checkingaccountnumber number primary key,
username varchar(100) not null,
checkingavailablebalance number default 0,
checkingcurrentbalance number default 0
);

create table transactions(
transactionid number primary key,
deposit NUMBER,
withdraw number,
savingaccountnumber number not null,
checkingaccountnumber number not null,
transactiondate date
);

create table transfers(
transferid number primary key,
fromaccount number,
toaccount number,
transferdate date
);

alter table mist_login
add constraint fk_username foreign key(username) references mist_users(username);

alter table mist_savings_account
add constraint fk_savings_username foreign key(username) references mist_users(username);

alter table mist_checking_account
add constraint fk_checking_username foreign key(username) references mist_users(username);

alter table transactions
add constraint fk_saving_acct_transaction foreign key(savingaccountnumber) references mist_savings_account(savingaccountnumber);

alter table transactions
add constraint fk_checking_acct_transaction foreign key(checkingaccountnumber) references mist_checking_account(checkingaccountnumber);

--drop table mist_login CASCADE CONSTRAINTS;
--drop table mist_savings_account CASCADE CONSTRAINTS;
--drop table mist_checking_account CASCADE CONSTRAINTS;
--drop table mist_users CASCADE CONSTRAINTS;
--drop table transactions CASCADE CONSTRAINTS;
--drop table transfers CASCADE CONSTRAINTS;