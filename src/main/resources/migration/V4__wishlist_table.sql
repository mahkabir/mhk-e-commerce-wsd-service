CREATE TABLE public.wish_list
(
    id          bigserial NOT NULL,
    customer_id int8      NOT NULL,
    product_id  int8      NOT NULL,
    CONSTRAINT wish_list_pkey PRIMARY KEY (id),
    CONSTRAINT wish_list_customer_id_fkey FOREIGN KEY (customer_id) REFERENCES public.customer (id),
    CONSTRAINT wish_list_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product_list (id)
);

INSERT INTO public.wish_list (customer_id, product_id)
VALUES (1, 2),
       (1, 3),
       (2, 1),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8),
       (5, 9),
       (5, 10);