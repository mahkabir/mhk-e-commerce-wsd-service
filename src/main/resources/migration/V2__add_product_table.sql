CREATE TABLE public.product_list
(
    id             bigserial    NOT NULL,
    product_name   varchar(150) NOT NULL,
    initial_amount int8         NOT NULL,
    price          int8         NOT NULL,
    CONSTRAINT product_list_pkey PRIMARY KEY (id)
);

INSERT INTO public.product_list (product_name, initial_amount, price)
VALUES ('Gaming Console', 40, 500),
       ('Smartwatch', 150, 200),
       ('External Hard Drive', 120, 100),
       ('Bluetooth Speaker', 80, 90),
       ('Graphic Tablet', 60, 180),
       ('Webcam', 90, 50),
       ('Wireless Router', 50, 120),
       ('Projector', 25, 400),
       ('Electric Kettle', 70, 35),
       ('Air Purifier', 45, 250);

