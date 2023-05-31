--CREATE TABLE roles (roleID int, accessType varchar(255));
INSERT INTO roles (roleID, access_Type) VALUES (1, 'USER');
INSERT INTO roles (roleID, access_Type) VALUES (2, 'ADMIN');
--CREATE TABLE users (userID int,username varchar(255),password varchar(255),debt double,enabled boolean, roles  varchar(255));
INSERT INTO users (userID,username,password,debt,enabled) VALUES (1, 'Juan Pablo Perez', 'casa1234', 0.00, true);
INSERT INTO users (userID,username,password,debt,enabled) VALUES (2, 'Juan Ignacio Perez', 'casa1234', 0.00, true);
INSERT INTO users (userID,username,password,debt,enabled) VALUES (3, 'Juan Manuel Perez', 'casa1234', 0.00, true);
INSERT INTO users (userID,username,password,debt,enabled) VALUES (4, 'Juan Gabriel Perez', 'casa1234', 0.00, true);
INSERT INTO users (userID,username,password,debt,enabled) VALUES (5, 'Juan Carlos Perez', 'casa1234', 0.00, true);

INSERT INTO user_role (users_userID, roles_roleID) VALUES (1, 2);
INSERT INTO user_role (users_userID, roles_roleID) VALUES (2, 1);
INSERT INTO user_role (users_userID, roles_roleID) VALUES (3, 1);
INSERT INTO user_role (users_userID, roles_roleID) VALUES (4, 1);
INSERT INTO user_role (users_userID, roles_roleID) VALUES (5, 2);
