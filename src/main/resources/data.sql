INSERT INTO product(id, product_type, product_brand) VALUES (1, 'LOANS', 'MANGO');
INSERT INTO product(id, product_type, product_brand) VALUES (4, 'LOANS', 'WELP');
INSERT INTO product(id, product_type, product_brand) VALUES (2, 'RENO', 'MANGO');
INSERT INTO product(id, product_type, product_brand) VALUES (3, 'RENO_CANCELED', 'MANGO');
INSERT INTO product(id, product_type, product_brand) VALUES (5, 'RENO', 'WELP');
INSERT INTO product(id, product_type, product_brand) VALUES (6, 'RENO_CANCELED', 'WELP');

INSERT INTO product_template(id, name) VALUES (1, 'MangoMutuo');
INSERT INTO product_template(id, name) VALUES (2, 'MangoPagare');
INSERT INTO product_template(id, name) VALUES (3, 'WelpMutuo');
INSERT INTO product_template(id, name) VALUES (4, 'WelpPagare');

INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (1, 1);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (1, 2);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (2, 1);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (2, 2);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (3, 1);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (3, 2);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (4, 3);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (4, 4);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (5, 3);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (5, 4);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (6, 3);
INSERT INTO product_x_product_template(product_id, product_template_id) VALUES (6, 4);

