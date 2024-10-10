CREATE TABLE public.customer
(
    id         bigserial    NOT NULL,
    username   varchar(150) NOT NULL,
    email      varchar      NOT NULL,
    first_name text NULL,
    last_name  text NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);

INSERT INTO public.customer (username, email, first_name, last_name)
VALUES ('michael', 'michael@example.com', 'Michael', 'Scott'),
       ('pam', 'pam@example.com', 'Pam', 'Beesly'),
       ('jim', 'jim@example.com', 'Jim', 'Halpert'),
       ('dwight', 'dwight@example.com', 'Dwight', 'Schrute'),
       ('angela', 'angela@example.com', 'Angela', 'Martin'),
       ('kevin', 'kevin@example.com', 'Kevin', 'Malone'),
       ('oscar', 'oscar@example.com', 'Oscar', 'Martinez'),
       ('toby', 'toby@example.com', 'Toby', 'Flenderson'),
       ('ryan', 'ryan@example.com', 'Ryan', 'Howard'),
       ('stanley', 'stanley@example.com', 'Stanley', 'Hudson');
