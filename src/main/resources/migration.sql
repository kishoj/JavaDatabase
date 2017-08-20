CREATE TABLE USER 
(
    ID INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    FIRSTNAME VARCHAR(30) NOT NULL,
    LASTNAME VARCHAR(30) NOT NULL,
    LOGIN VARCHAR(30) NOT NULL,
    EMAIL VARCHAR(80) NOT NULL
);

INSERT INTO USER VALUES (1, 'KISHOJ', 'BAJRACHARYA', 'KISH', 'kishoj@gmail.com');

CREATE TABLE person 
(
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    login VARCHAR(30) NOT NULL,
    email VARCHAR(80) NOT NULL
);

INSERT INTO person VALUES (1, 'KISHOJ', 'BAJRACHARYA', 'KISH', 'kishoj@gmail.com');


CREATE TABLE public.person
(
  id bigserial NOT NULL PRIMARY KEY,
  firstname character varying(30) NOT NULL,
  lastname character varying(30) NOT NULL,
  login character varying(30) NOT NULL,
  email character varying(80) NOT NULL
);

INSERT INTO person VALUES (1, 'KISHOJ', 'BAJRACHARYA', 'KISH', 'kishoj@gmail.com');
