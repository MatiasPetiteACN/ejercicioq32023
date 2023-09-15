--CREATE TABLE roles (roleID int, accessType varchar(255));
INSERT INTO roles (roleID, access_Type) VALUES (1, 'USER');
INSERT INTO roles (roleID, access_Type) VALUES (2, 'ADMIN');
--CREATE TABLE users (userID int,username varchar(255),password varchar(255),debt double,enabled boolean, roles  varchar(255));
INSERT INTO users (userID,username,password,debt,enabled) VALUES (1, 'juanpabloperez', 'casa1234', 0.00, true);
INSERT INTO users (userID,username,password,debt,enabled) VALUES (2, 'juanignacioperez', 'casa1234', 0.00, true);
INSERT INTO users (userID,username,password,debt,enabled) VALUES (3, 'juanmanuelperez', 'casa1234', 0.00, true);
INSERT INTO users (userID,username,password,debt,enabled) VALUES (4, 'juangabrielperez', 'casa1234', 0.00, true);
INSERT INTO users (userID,username,password,debt,enabled) VALUES (5, 'juancarlosperez', 'casa1234', 0.00, true);

INSERT INTO user_role (users_userID, roles_roleID) VALUES (1, 2);
INSERT INTO user_role (users_userID, roles_roleID) VALUES (2, 1);
INSERT INTO user_role (users_userID, roles_roleID) VALUES (3, 1);
INSERT INTO user_role (users_userID, roles_roleID) VALUES (4, 1);
INSERT INTO user_role (users_userID, roles_roleID) VALUES (5, 2);
