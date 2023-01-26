create table signup(formno varchar(20)  , username varchar(20) , father_name varchar(20) , dob varchar(30) , gender varchar(10) , email varchar(50), marital varchar(20), address varchar(40), city varchar(25), state varchar(25), pincode varchar(20));
create table signuptwo( formno varchar(20), religen varchar (20), category varchar(20), income varchar(20), educational varchar(40), occupation varchar(30), pan varchar(20), aadhar varchar(25), seniorcitizen varchar(5), ExistingAccount varchar(5));
create table  signupthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25), pinnumber varchar(10), facility varchar(100));
create table  signin(formno varchar(20) , cardnumber varchar(25), pinnumber varchar(10) );
create table bank(pinnumber varchar(20) , date varchar(50), type varchar(20) , amount varchar(30));
	
