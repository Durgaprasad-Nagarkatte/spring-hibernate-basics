insert into course(id, name, created_date, last_updated_date)
values (10001, 'JPA and Hibernate', sysdate(), sysdate());

insert into course(id, name, created_date, last_updated_date)
values (10002, 'Junit5', sysdate(), sysdate());

insert into course(id, name, created_date, last_updated_date)
values (10003, 'Reactive programming', sysdate(), sysdate());

insert into passport(id, number)
values (40001, '1234567');

insert into passport(id, number)
values (40002, '2345678');

insert into passport(id, number)
values (40003, '34567890');

insert into student(id, name, passport_id)
values (20001, 'Durgaprasad', 40001);

insert into student (id, name, passport_id)
values (20002, 'Akshatha', 40002);

insert into student (id, name, passport_id)
values (20003, 'Mangala', 40003);

insert into review(id, rating, description)
values (50001, 5, 'Great course');

insert into review(id, rating, description)
values (50002, 4, 'Awesome course');

insert into review(id, rating, description)
values (50003, 4, 'Wonderful course');

