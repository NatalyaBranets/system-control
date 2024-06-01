INSERT INTO my_db.k_pac(id, title, description, creation_date) VALUES (1, 'title1', 'description1', '2024-05-24');
INSERT INTO my_db.k_pac(id, title, description, creation_date) VALUES (2, 'title2', 'description2', '2024-05-24');
INSERT INTO my_db.k_pac(id, title, description, creation_date) VALUES (3, 'title3', 'description3', '2024-05-25');
INSERT INTO my_db.k_pac(id, title, description, creation_date) VALUES (4, 'title4', 'description4', '2024-05-25');

INSERT INTO my_db.k_pac_set(id, title) value(1, 'title1');
INSERT INTO my_db.k_pac_set(id, title) value(2, 'title2');
INSERT INTO my_db.k_pac_set(id, title) value(3, 'title3');

INSERT INTO my_db.k_pac_set_k_pac (k_pac_set_id, k_pac_id) VALUES (1, 1);
INSERT INTO my_db.k_pac_set_k_pac (k_pac_set_id, k_pac_id) VALUES (1, 2);
INSERT INTO my_db.k_pac_set_k_pac (k_pac_set_id, k_pac_id) VALUES (1, 3);
INSERT INTO my_db.k_pac_set_k_pac (k_pac_set_id, k_pac_id) VALUES (2, 2);
INSERT INTO my_db.k_pac_set_k_pac (k_pac_set_id, k_pac_id) VALUES (3, 1);