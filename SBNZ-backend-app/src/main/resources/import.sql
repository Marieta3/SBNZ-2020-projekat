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

INSERT INTO VOCE(id, name, nadmorska_visina, opis, kolicina_padavina, max_temperatura, min_temperatura, prosecna_godisnja_temperatura, calc_category, ph_category) VALUES (1, "Jabuka", 200, "Jabuka je voce koje raste na plodnom tlu. Ima vise sorti. Voli vodu.", 300, 30, -5, 15, 2, 4);
INSERT INTO VOCE(id, name, nadmorska_visina, opis, kolicina_padavina, max_temperatura, min_temperatura, prosecna_godisnja_temperatura, calc_category, ph_category) VALUES (2, "Kruska", 200, "Kruska je voce koje raste na plodnom tlu. Ima vise sorti. Voli vodu.", 250, 32, 0, 14, 1, 2);
INSERT INTO VOCE(id, name, nadmorska_visina, opis, kolicina_padavina, max_temperatura, min_temperatura, prosecna_godisnja_temperatura, calc_category, ph_category) VALUES (3, "Visnja", 200, "Visnja je voce koje raste na plodnom tlu. Ima vise sorti. Voli vodu.", 100, 25, -10, 12, 0, 3);


INSERT INTO REGION(id, naziv, nadmorska_visina, kolicina_padavina, max_temperatura, min_temperatura, prosecna_godisnja_temperatura) VALUES (1, "Srem", 200, 300, 30, -5, 15);
INSERT INTO REGION(id, naziv, nadmorska_visina, kolicina_padavina, max_temperatura, min_temperatura, prosecna_godisnja_temperatura) VALUES (2, "Banat", 150, 250, 32, 0, 14);
INSERT INTO REGION(id, naziv, nadmorska_visina, kolicina_padavina, max_temperatura, min_temperatura, prosecna_godisnja_temperatura) VALUES (3, "Backa", 100, 555, 25, -10, 12);