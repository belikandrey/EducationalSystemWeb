use educational_system;
drop table Teacher;

create table Teacher(
	id int primary key auto_increment,
    name varchar(30),
    subjectName varchar(40),
    age int
);


insert into Teacher(name, subjectName, age) values('Andrei', 'Math', 15);

insert into Teacher(name, subjectName, age) values('Dima', 'Biology', 23);
insert into Teacher(name, subjectName, age) values('Roma', 'Physics', 27);
