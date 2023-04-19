insert into user_details(id, birth_date, name) values(10001, current_date(), 'Viswa');

insert into user_details(id, birth_date, name) values(10002, current_date(), 'Akshay');

insert into user_details(id, birth_date, name) values(10003, current_date(), 'Lakshmi');


insert into posts(id, description, user_id) values(200, 'I want to learn AWS', 10001);
insert into posts(id, description, user_id) values(201, 'I want to learn Java', 10003);
insert into posts(id, description, user_id) values(202, 'I want to learn ReactJS', 10002);
insert into posts(id, description, user_id) values(203, 'I want to learn AngularJS', 10001);
insert into posts(id, description, user_id) values(204, 'I want to learn Full Stack', 10003);

insert into todo(ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10002, 'Viswa', 'Learn AWS Course', CURRENT_DATE(), false);

insert into todo(ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10003, 'Viswa', 'Learn Python', CURRENT_DATE(), false);


insert into todo(ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10004, 'Akshay', 'Learn React JS', CURRENT_DATE(), false);


insert into todo(ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10005, 'Akshay', 'Learn Angular JS', CURRENT_DATE(), false);

insert into todo(ID, USERNAME, DESCRIPTION, TARGET_DATE, DONE)
values(10006, 'Viswa', 'Learn Mongo Db', CURRENT_DATE(), false);