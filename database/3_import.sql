INSERT INTO groomly.city (id, name) VALUES (default, 'Tallinn');
INSERT INTO groomly.city (id, name) VALUES (default, 'Tartu');
INSERT INTO groomly.city (id, name) VALUES (default, 'Pärnu');
INSERT INTO groomly.city (id, name) VALUES (default, 'Võru');

INSERT INTO groomly.role (id, name, status) VALUES (default, 'admin', 'A');
INSERT INTO groomly.role (id, name, status) VALUES (default, 'groomer', 'A');
INSERT INTO groomly.role (id, name, status) VALUES (default, 'customer', 'A');

INSERT INTO groomly."user" (id, role_id, username, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO groomly."user" (id, role_id, username, password, status) VALUES (default, 2, 'groomer', '123', 'A');
INSERT INTO groomly."user" (id, role_id, username, password, status) VALUES (default, 3, 'customer', '123', 'A');
INSERT INTO groomly."user" (id, role_id, username, password, status) VALUES (default, 3, 'mitteaktiivne', '123', 'D');



INSERT INTO groomly.location (id, city_id, street_name, house_number, lat, long) VALUES (default, 1, 'Aia tn', 15, null, null);
INSERT INTO groomly.location (id, city_id, street_name, house_number, lat, long) VALUES (default, 2, 'Tartu tn', 5, null, null);
INSERT INTO groomly.location (id, city_id, street_name, house_number, lat, long) VALUES (default, 3, 'Pärnu tn', 3, null, null);

INSERT INTO groomly.groomer (id, user_id, location_id, name, description, tel_number, email) VALUES (default, 2,1, 'Nastja', 'grooming', '123', 'meil');
INSERT INTO groomly.groomer (id, user_id, location_id, name, description, tel_number, email) VALUES (default, 3,2, 'Silver', 'total grooming', '456', 'meil1');
INSERT INTO groomly.groomer (id, user_id, location_id, name, description, tel_number, email) VALUES (default, 4,3, 'Mart', 'grooming üle Eesti', '789', 'meil2');

INSERT INTO groomly.booking (id, groomer_id, customer_user_id, status, total_price, date) VALUES (default, 1, 3, 'A', 140.00, '2025-05-23');

INSERT INTO groomly.procedure (id, name,  description, status) VALUES (default, 'täispakett', 'pesemine, lõikamine, küünte lõikus', 'A');
INSERT INTO groomly.procedure (id, name,  description, status) VALUES (default, 'lõikamine', 'lõikamine', 'A');

INSERT INTO groomly.groomer_procedure (id, groomer_id, procedure_id, price) VALUES (default, 1, 1, 90.00);
INSERT INTO groomly.groomer_procedure (id, groomer_id, procedure_id, price) VALUES (default, 1, 2,50.00 );

INSERT INTO groomly.booking_procedure (id, booking_id, procedure_id, price) VALUES (default, 1, 1, 90.00);
INSERT INTO groomly.booking_procedure (id, booking_id, procedure_id, price) VALUES (default, 1, 2, 40.00);
