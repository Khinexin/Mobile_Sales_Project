INSERT INTO category(cat_id,cat_name)
VALUES
(1,'Mobile'),(2,'Accessory'),(3,'Tablets');
-- --
INSERT INTO mobile_accessory(id,item_description,item_name,manufacturer,price,unit_stock,category_cat_id)
VALUES
(1,'type1','Iphone','vietnam',1230,20,1),
(2,'type2','Samsung','Note9',900,5,1),
(3,'Cover','Vivo','Note9',12,20,2),
(4,'Cover','Mi','keychain',10,20,2);
-- --
INSERT INTO app_role (ROLE_ID, ROLE_NAME)
VALUES (1, 'ROLE_ADMIN'),(2, 'ROLE_USER'),(3, 'ROLE_EMP');
-- --
-- -- Used by Spring Remember Me API.
CREATE TABLE Persistent_Logins (
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series));
INSERT INTO app_user(user_id,enabled,encryted_password,user_name)
VALUES
(1,true,'$2a$10$rZl5fgWK.Awd8irbqt49duEql3ROdEHStzcYOa.f34tF1MJiW8XOa','user1'),
(2,true,'$2a$10$rZl5fgWK.Awd8irbqt49duEql3ROdEHStzcYOa.f34tF1MJiW8XOa','user2'),
(3,true,'$2a$10$rZl5fgWK.Awd8irbqt49duEql3ROdEHStzcYOa.f34tF1MJiW8XOa','emp1'),
(4,true,'$2a$10$rZl5fgWK.Awd8irbqt49duEql3ROdEHStzcYOa.f34tF1MJiW8XOa','emp2'),
(5,true,'$2a$10$rZl5fgWK.Awd8irbqt49duEql3ROdEHStzcYOa.f34tF1MJiW8XOa','admin1'),
(6,true,'$2a$10$rZl5fgWK.Awd8irbqt49duEql3ROdEHStzcYOa.f34tF1MJiW8XOa','admin11');
--
INSERT INTO user_role(id,role_id,user_id)VALUES(1,2,1),(2,2,2),(3,3,3),(4,2,3),(5,3,4),(6,2,4),(7,1,5),(8,2,5),(9,3,5),(10,1,6);
--
