INSERT INTO groomly.role (id, name, status) VALUES (default, 'admin', 'A');
INSERT INTO groomly.role (id, name, status) VALUES (default, 'groomer', 'A');
INSERT INTO groomly.role (id, name, status) VALUES (default, 'customer', 'A');

INSERT INTO groomly."user" (id, role_id, username, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO groomly."user" (id, role_id, username, password, status) VALUES (default, 2, 'groomer', '123', 'A');
INSERT INTO groomly."user" (id, role_id, username, password, status) VALUES (default, 3, 'customer', '123', 'A');
INSERT INTO groomly."user" (id, role_id, username, password, status) VALUES (default, 3, 'mitteaktiivne', '123', 'D');


INSERT INTO groomly.procedure (id, name, price, description, status) VALUES (default, 'täispakett', 90.00, 'pesemine, lõikamine, küünte lõikus', 'A');
INSERT INTO groomly.procedure (id, name, price, description, status) VALUES (default, 'lõikamine', 50.00, 'lõikamine', 'A');
