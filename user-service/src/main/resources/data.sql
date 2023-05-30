CREATE TABLE users (userID int,username varchar(255),password varchar(255),debt double,enabled boolean, roles  varchar(255));
INSERT INTO users (userID,username,password,debt,enabled, roles) VALUES (1, 'Juan Pablo Perez', 'casa1234', 0.00, true, 'ADMIN');
INSERT INTO users (userID,username,password,debt,enabled, roles) VALUES (2, 'Juan Ignacio Perez', 'casa1234', 0.00, true, 'USER');
INSERT INTO users (userID,username,password,debt,enabled, roles) VALUES (3, 'Juan Manuel Perez', 'casa1234', 0.00, true, 'USER');
INSERT INTO users (userID,username,password,debt,enabled, roles) VALUES (4, 'Juan Gabriel Perez', 'casa1234', 0.00, true, 'USER');
INSERT INTO users (userID,username,password,debt,enabled, roles) VALUES (5, 'Juan Carlos Perez', 'casa1234', 0.00, true, 'ADMIN');
CREATE TABLE roles (roleID int, accessType varchar(255));
INSERT INTO roles (roleID, accessType) VALUES (1, 'USER');
INSERT INTO roles (roleID, accessType) VALUES (2, 'ADMIN');