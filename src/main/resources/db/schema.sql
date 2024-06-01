CREATE DATABASE IF NOT EXISTS my_db;

USE my_db;


DROP TABLE IF EXISTS my_db.k_pac_set_k_pac;
DROP TABLE IF EXISTS my_db.k_pac;
DROP TABLE IF EXISTS my_db.k_pac_set;

CREATE TABLE my_db.k_pac (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(250) NOT NULL,
    description VARCHAR(2500) NOT NULL,
    creation_date DATE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE my_db.k_pac_set (
    id INT NOT NULL  AUTO_INCREMENT,
    title VARCHAR(250) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE my_db.k_pac_set_k_pac (
    k_pac_set_id INT NOT NULL,
    k_pac_id INT NOT NULL,
    PRIMARY KEY (k_pac_set_id, k_pac_id),
    CONSTRAINT k_pac_set_fk
        FOREIGN KEY (k_pac_set_id)  REFERENCES k_pac_set (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT k_pac_fk
        FOREIGN KEY (k_pac_id) REFERENCES k_pac (id)
        ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT unq_k_pac_multi_key UNIQUE (k_pac_id, k_pac_set_id)
);