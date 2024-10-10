CREATE TABLE public.sale_data
(
    id          bigserial NOT NULL,
    customer_id int8      NOT NULL,
    product_id  int8      NOT NULL,
    quantity    int8      NOT NULL,
    sale_date   timestamp NOT NULL,
    CONSTRAINT sale_data_pkey PRIMARY KEY (id),
    CONSTRAINT sale_data_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES public.customer (id),
    CONSTRAINT sale_data_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product_list (id)
);

INSERT INTO public.sale_data (customer_id, product_id, quantity, sale_date)
VALUES (1, 1, 2, '2024-10-11 10:30:00'),
       (1, 3, 1, '2024-10-11 11:00:00'),
       (2, 2, 3, '2024-10-11 14:45:00'),
       (2, 4, 2, '2024-10-11 09:15:00'),
       (3, 5, 1, '2024-10-11 12:00:00'),
       (3, 6, 4, '2024-10-11 13:30:00'),
       (4, 7, 1, '2024-10-11 16:00:00'),
       (4, 8, 1, '2024-10-11 17:30:00'),
       (5, 9, 1, '2024-10-11 19:00:00'),
       (5, 10, 2, '2024-10-11 20:45:00'),
       (1, 3, 1, '2024-10-11 11:00:00'),
       (2, 2, 3, '2024-10-11 14:45:00'),
       (2, 4, 2, '2024-10-11 09:15:00'),
       (3, 5, 1, '2024-10-11 12:00:00'),
       (3, 6, 4, '2024-10-11 13:30:00'),
       (4, 7, 1, '2024-10-11 16:00:00'),
       (4, 8, 1, '2024-10-11 17:30:00'),
       (5, 9, 1, '2024-10-11 19:00:00'),
       (5, 10, 2, '2024-10-11 20:45:00');







