insert into user_role(role, description) VALUES ("ROLE_USER", "default role for user");
insert into user_role(role, description) VALUES ("ROLE_ADMIN", "ADMIN");
INSERT INTO `test`.`user` ( `email`, `first_name`, `last_name`, `password`) VALUES ( 'asd@asd.pl', 'asd', 'asd', '{bcrypt}$2a$10$0aWaOqVXA86TX1vGBD3/AuUj8BEusbjavMRN3gwAg3f8KO1FcW3Au');
insert into user_roles(user_id,roles_id) values ("1","2");
