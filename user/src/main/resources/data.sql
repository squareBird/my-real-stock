insert into "user" (userId, password, email, nickName, phoneNum, activated, created_at, modified_at) values ('admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'aaa@aaa.aaa', 'admin','01012345678', 1, '2022-09-12 23:00:00', '2022-09-12 23:00:00');
insert into "user" (userId, password, email, nickName, phoneNum, activated, created_at, modified_at) values ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'bbb@bbb.bbb', 'user', '01098765432', 1, '2022-09-12 23:00:00', '2022-09-12 23:00:00');

insert into authority (authority_name) values ('ROLE_USER');
insert into authority (authority_name) values ('ROLE_ADMIN');

insert into user_authority (id, authority_name) values (1, 'ROLE_USER');
insert into user_authority (id, authority_name) values (1, 'ROLE_ADMIN');
insert into user_authority (id, authority_name) values (2, 'ROLE_USER');