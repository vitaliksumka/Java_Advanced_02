Drop database library;
create database library char set UTF8;
use library;
select database();

create table books (
		id int not null primary key auto_increment,
        nameBook varchar(80) not null,
        authorName varchar(80) not null,
        quentityPages int not null,
        price int not null
);

insert into books (nameBook, authorName, quentityPages, price) values 
 ('ИГРА ПРЕСТОЛОВ',  'ДжорджМартин', 465, 323.0),
    ('МАГИЯ УТРА', 'Гел Елрод',  240, 184.0),
    ('ПОСЛЕ', 'Анна Тодд', 192, 466.0);
    
Select * from books;
        

