--pwd 123
INSERT INTO USER(user_type, id, username, password, email, name, last_name, confirmed, enabled, version) VALUES ("admin", 1, "admin", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra", "admin@gmail.com", "Admin", "Admin", true, true, 0);

--pwd admin
INSERT INTO USER(user_type, id, username, password, email, name, last_name, confirmed, enabled, version) VALUES ("admin", 2, "sys", "$2a$10$mj6jiG5FLHp4s2Nvf84mbeeYPjjFmeDDtk7Uzua8sBBWzuXtNoPqW", "admin2@gmail.com", "System", "Admin", true, true, 0);
--pwd 123
INSERT INTO USER(user_type, id, username, password, email, name, last_name, confirmed, enabled, version) VALUES ("user", 3, "user", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra", "mokranjac@gmail.com", "User", "User", true, true, 0);


INSERT INTO AUTHORITY (id, name) VALUES (1,"ROLE_ADMIN");
INSERT INTO AUTHORITY (id, name) VALUES (2,"ROLE_USER");

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (3, 2);
