-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-05-16 12:05:34.5

-- tables
-- Table: booking
CREATE TABLE booking (
    id serial  NOT NULL,
    groomer_id int  NOT NULL,
    customer_user_id int  NOT NULL,
    status char(1)  NOT NULL,
    total_price decimal(6,2)  NOT NULL,
    date date  NOT NULL,
    CONSTRAINT booking_pk PRIMARY KEY (id)
);

-- Table: booking_procedure
CREATE TABLE booking_procedure (
    id serial  NOT NULL,
    booking_id int  NOT NULL,
    procedure_id int  NOT NULL,
    CONSTRAINT booking_procedure_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: groomer
CREATE TABLE groomer (
    id serial  NOT NULL,
    location_id int  NOT NULL,
    name varchar(255)  NOT NULL,
    description varchar(500)  NOT NULL,
    tel_number varchar(20)  NOT NULL,
    email varchar(255)  NOT NULL,
    CONSTRAINT groomer_pk PRIMARY KEY (id)
);

-- Table: groomer_album
CREATE TABLE groomer_album (
    id serial  NOT NULL,
    groomer_id int  NOT NULL,
    image_data bytea  NOT NULL,
    status varchar(1)  NOT NULL,
    CONSTRAINT groomer_album_pk PRIMARY KEY (id)
);

-- Table: groomer_calendar
CREATE TABLE groomer_calendar (
    id serial  NOT NULL,
    groomer_id int  NOT NULL,
    date date  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT groomer_calendar_pk PRIMARY KEY (id)
);

-- Table: groomer_procedure
CREATE TABLE groomer_procedure (
    id serial  NOT NULL,
    groomer_id int  NOT NULL,
    procedure_id int  NOT NULL,
    CONSTRAINT groomer_procedure_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
    id serial  NOT NULL,
    city_id int  NOT NULL,
    street_name varchar(255)  NOT NULL,
    house_number varchar(255)  NULL,
    lat decimal(18,15)  NULL,
    long decimal(18,15)  NULL,
    CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: mailbox
CREATE TABLE mailbox (
    id serial  NOT NULL,
    sender_user_id int  NOT NULL,
    receiver_user_id int  NOT NULL,
    title varchar(255)  NOT NULL,
    body varchar(255)  NOT NULL,
    status char(3)  NOT NULL,
    CONSTRAINT mailbox_pk PRIMARY KEY (id)
);

-- Table: procedure
CREATE TABLE procedure (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    price decimal(5,2)  NOT NULL,
    description varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT procedure_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
    id serial  NOT NULL,
    name varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
    id serial  NOT NULL,
    role_id int  NOT NULL,
    username varchar(255)  NOT NULL,
    password varchar(255)  NOT NULL,
    status char(1)  NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
);

-- Table: user_image
CREATE TABLE user_image (
    id serial  NOT NULL,
    user_id int  NOT NULL,
    data bytea  NOT NULL,
    CONSTRAINT user_image_pk PRIMARY KEY (id)
);

-- Table: weekday
CREATE TABLE weekday (
    id serial  NOT NULL,
    number int  NOT NULL,
    short char(1)  NOT NULL,
    long varchar(10)  NOT NULL,
    CONSTRAINT weekday_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: booking_groomer (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_groomer
    FOREIGN KEY (groomer_id)
    REFERENCES groomer (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: booking_procedure_booking (table: booking_procedure)
ALTER TABLE booking_procedure ADD CONSTRAINT booking_procedure_booking
    FOREIGN KEY (booking_id)
    REFERENCES booking (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: booking_procedure_procedure (table: booking_procedure)
ALTER TABLE booking_procedure ADD CONSTRAINT booking_procedure_procedure
    FOREIGN KEY (procedure_id)
    REFERENCES procedure (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: booking_user (table: booking)
ALTER TABLE booking ADD CONSTRAINT booking_user
    FOREIGN KEY (customer_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: groomer_album_groomer (table: groomer_album)
ALTER TABLE groomer_album ADD CONSTRAINT groomer_album_groomer
    FOREIGN KEY (groomer_id)
    REFERENCES groomer (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: groomer_calendar_groomer (table: groomer_calendar)
ALTER TABLE groomer_calendar ADD CONSTRAINT groomer_calendar_groomer
    FOREIGN KEY (groomer_id)
    REFERENCES groomer (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: groomer_location (table: groomer)
ALTER TABLE groomer ADD CONSTRAINT groomer_location
    FOREIGN KEY (location_id)
    REFERENCES location (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: groomer_procedure_groomer (table: groomer_procedure)
ALTER TABLE groomer_procedure ADD CONSTRAINT groomer_procedure_groomer
    FOREIGN KEY (groomer_id)
    REFERENCES groomer (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: groomer_procedure_procedure (table: groomer_procedure)
ALTER TABLE groomer_procedure ADD CONSTRAINT groomer_procedure_procedure
    FOREIGN KEY (procedure_id)
    REFERENCES procedure (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: location_city (table: location)
ALTER TABLE location ADD CONSTRAINT location_city
    FOREIGN KEY (city_id)
    REFERENCES city (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: mailbox_user_receiver (table: mailbox)
ALTER TABLE mailbox ADD CONSTRAINT mailbox_user_receiver
    FOREIGN KEY (receiver_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: mailbox_user_sender (table: mailbox)
ALTER TABLE mailbox ADD CONSTRAINT mailbox_user_sender
    FOREIGN KEY (sender_user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_image_user (table: user_image)
ALTER TABLE user_image ADD CONSTRAINT user_image_user
    FOREIGN KEY (user_id)
    REFERENCES "user" (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
    REFERENCES role (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

