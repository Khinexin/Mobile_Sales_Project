INSERT INTO category(cat_id,cat_name)
VALUES
(1,'Mobile'),(2,'Accessory'),(3,'Tablets');
--
INSERT INTO mobile_accessory(id,item_description,item_name,manufacturer,price,unit_stock,category_cat_id)
VALUES
(1,'type1','Iphone','vietnam',1230,20,1),
(2,'type2','Samsung','Note9',900,5,1),
(3,'Cover','Vivo','Note9',12,20,2),
(4,'Cover','Mi','keychain',10,20,2);
--
insert into app_role (ROLE_ID, ROLE_NAME)
values (1, 'ROLE_ADMIN'),(2, 'ROLE_USER'),(3, 'ROLE_EMP');
-- --
-- -- Used by Spring Remember Me API.
-- CREATE TABLE Persistent_Logins (
--     username varchar(64) not null,
--     series varchar(64) not null,
--     token varchar(64) not null,
--     last_used timestamp not null,
--     PRIMARY KEY (series));
