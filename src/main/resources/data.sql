INSERT INTO category(cat_id,cat_name)
VALUES
(1,'Mobile'),(2,'Accessory'),(3,'Tablets');
-- --
INSERT INTO mobile_accessory(id,item_description,item_name,manufacturer,price,unit_stock,category_cat_id)
VALUES
(1,'iPhoneXs','Iphone','unknown',999,5,1),
(2,'iPhoneXs Max','Iphone','unknown',1099,5,1),
(3,'iPhone8','Iphone','unknown',599,5,1),
(4,'iPhone8 Plus','Iphone','unknown',699,5,1),

(5,'Samsung S9','Samsung','unknown',769,5,1),
(6,'Samsung S9 Plus','Samsung','unknown',889,5,1),
(7,'Samsung S8','Samsung','unknown',448,5,1),
(8,'Samsung S8 Plus','Samsung','unknown',499,5,1),

(9,'Huawei Mate20','Huawei','unknown',624,5,1),
(10,'Huawei P20Lite','Huawei','unknown',360,5,1),

(11,'Oppo K1','Oppo','unknown',368,5,1),
(12,'Oppo R17Pro','Oppo','unknown',858,5,1),

(13,'Finger holders and ring','for smartphone','unknown',12,10,2),
(14,'GlocalMe Mobile Hotspot','Wifi Hotspot','unknown',10,10,2),
(15,'Universal Magnetic','for Car mount','unknown',19,10,2),
(16,'Phone Controller Gamepad Thumb Stick','Wireless Cellphone Accessory','unknown',24,10,2),
(17,'Solar Mobile Charger','Waterproof','unknown',35,10,2),
(18,'Cell Phone Signal Booster for Home','Your signal up to 32x cover up 1200sqft','unknown',199,10,2),
(19,'Charging pad','Stanley Qi-Certified 10W Fast Charging','unknown',29,10,2),
(20,'UMIDIGI Mobile A3 Case','Top ACE','unknown',8,10,2),
(21,'All-new Echo Dot','Smart Speaker','unknown',29,10,2),
(22,'Jabra Move Wireless Stereo Headphones','Jabra','unknown',49,10,2),

(23,'Fire 7 Tablet with Alexa','7inches display, 8GB','unknown',49,5,3),
(24,'Chrismas Kids Tablet with Dual Camera','7inches, Android 4.4 4GB ROM 512MB RAM','unknown',10,5,3),
(25,'Android Tablets PC | 4GB RAM 64GB ROM | 10-Core Processor HD display','Inkach','unknown',10,5,3),
(26,'Ipad (Wifi,32GB)','Apple','unknown',10,5,3),
(27,'Dell Inspiron 11.6inch HD Touchscreen 2in1 Tablet Laptop Computer , 7th Gen AMD A9-940e 2.9GHz, Window 10','Dell','unknown',10,5,3);

-- --
INSERT INTO app_role (ROLE_ID, ROLE_NAME)
VALUES (1, 'ROLE_ADMIN'),(2, 'ROLE_USER'),(3, 'ROLE_EMP');
-- --


INSERT INTO `app_user` VALUES (1,'','$2a$10$pwt8QzTnnSJOLVjDYgmJ/eN3fFTCkfBz9WdDtSjQ/2mH.rq/A9Yie','Y',NULL,NULL,NULL,'htunhtunaungadmin');
INSERT INTO `customer` VALUES (1,'+95','9790137903','ambutamilno1@gmail.com','Htun Htun','Aung Admin' ,1,0,0,0);
INSERT INTO `user_role` VALUES (1,1,1);
INSERT INTO `user_role` VALUES (2,2,1);

INSERT INTO `app_user` VALUES (2,'','$2a$10$pwt8QzTnnSJOLVjDYgmJ/eN3fFTCkfBz9WdDtSjQ/2mH.rq/A9Yie','Y',NULL,NULL,NULL,'htunhtunaunguser');
INSERT INTO `customer` VALUES (2,'+95','9790137903','ambutamilno1@gmail.com','Htun Htun','Aung User' ,2,0,0,0);
INSERT INTO `user_role` VALUES (3,2,2);
--
INSERT INTO `app_user` VALUES (3,'','$2a$10$Dd.lXM.72Xt01Syez.Gvp.veNy3B136UCZLUPWD6bWLyJ.B4TVQLa','Y',NULL,NULL,NULL,'zawlwinooadmin');
INSERT INTO `customer` VALUES (3,'+95','9795522405','zawlwinoo106@gmail.com','Zaw Lwin','Oo Admin' ,3,0,0,0);
INSERT INTO `user_role` VALUES (4,1,3);
INSERT INTO `user_role` VALUES (5,2,3);

INSERT INTO `app_user` VALUES (4,'','$2a$10$Dd.lXM.72Xt01Syez.Gvp.veNy3B136UCZLUPWD6bWLyJ.B4TVQLa','Y',NULL,NULL,NULL,'zawlwinoouser');
INSERT INTO `customer` VALUES (4,'+95','9795522405','zawlwinoo106@gmail.com','Zaw Lwin','Oo User' ,4,0,0,0);
INSERT INTO `user_role` VALUES (6,2,4);
--
INSERT INTO `app_user` VALUES (5,'','$2a$10$Amhtd6AS7zrfZexk8Y7lBu07z0OlDDJUsmlwBuTDVOQDo6YsOQe1u','Y',NULL,NULL,NULL,'myokhantzawadmin');
INSERT INTO `customer` VALUES (5,'+95','9400537183','zmyokhant@gmail.com','Myo Khant','Zaw Admin' ,5,0,0,0);
INSERT INTO `user_role` VALUES (7,1,5);
INSERT INTO `user_role` VALUES (8,2,5);

INSERT INTO `app_user` VALUES (6,'','$2a$10$Amhtd6AS7zrfZexk8Y7lBu07z0OlDDJUsmlwBuTDVOQDo6YsOQe1u','Y',NULL,NULL,NULL,'myokhantzawuser');
INSERT INTO `customer` VALUES (6,'+95','9400537183','zmyokhant@gmail.com','Myo Khant','Zaw User' ,6,0,0,0);
INSERT INTO `user_role` VALUES (9,2,6);
--
INSERT INTO `app_user` VALUES (7,'','$2a$10$yoW9gU5rmEeH1jLUYZrdue7/Z5xbhLOhtj2vThAHdfbxQs/7BA4bG','Y',NULL,NULL,NULL,'naingnaingsoeadmin');
INSERT INTO `customer` VALUES (7,'+95','9773738777','nsoen365@gmail.com','Naing Naing','Soe Admin' ,7,0,0,0);
INSERT INTO `user_role` VALUES (10,1,7);
INSERT INTO `user_role` VALUES (11,2,7);

INSERT INTO `app_user` VALUES (8,'','$2a$10$yoW9gU5rmEeH1jLUYZrdue7/Z5xbhLOhtj2vThAHdfbxQs/7BA4bG','Y',NULL,NULL,NULL,'naingnaingsoeuser');
INSERT INTO `customer` VALUES (8,'+95','9773738777','nsoen365@gmail.com','Naing Naing','Soe User' ,8,0,0,0);
INSERT INTO `user_role` VALUES (12,2,8);
--
INSERT INTO `app_user` VALUES (9,'','$2a$10$fPniVpLBw3b4TMg/ifFI7uaReQMQL512q.SWR9CaCpEy.3Vvgjkk6','Y',NULL,NULL,NULL,'hannwenyeinadmin');
INSERT INTO `customer` VALUES (9,'+95','9773686473','hannwenyein225@gmail.com','Myo Khant','Zaw Admin' ,9,0,0,0);
INSERT INTO `user_role` VALUES (13,1,9);
INSERT INTO `user_role` VALUES (14,2,9);

INSERT INTO `app_user` VALUES (10,'','$2a$10$fPniVpLBw3b4TMg/ifFI7uaReQMQL512q.SWR9CaCpEy.3Vvgjkk6','Y',NULL,NULL,NULL,'hannwenyeinuser');
INSERT INTO `customer` VALUES (10,'+95','9773686473','hannwenyein225@gmail.com','Myo Khant','Zaw User' ,10,0,0,0);
INSERT INTO `user_role` VALUES (15,2,10);
--
INSERT INTO `app_user` VALUES (11,'','$2a$10$8L3YT5Gle5kguOwXTWJDjOQj/4kC1a.8FannlpFCIoJOFkETFVqWu','Y',NULL,NULL,NULL,'sansanthiadmin');
INSERT INTO `customer` VALUES (11,'+95','9784833731','sansanthi1996@gmail.com','San San','Thi Admin' ,11,0,0,0);
INSERT INTO `user_role` VALUES (16,1,11);
INSERT INTO `user_role` VALUES (17,2,11);

INSERT INTO `app_user` VALUES (12,'','$2a$10$8L3YT5Gle5kguOwXTWJDjOQj/4kC1a.8FannlpFCIoJOFkETFVqWu','Y',NULL,NULL,NULL,'sansanthiuser');
INSERT INTO `customer` VALUES (12,'+95','9784833731','sansanthi1996@gmail.com','San San','Thi User' ,12,0,0,0);
INSERT INTO `user_role` VALUES (18,2,12);
--
INSERT INTO `app_user` VALUES (13,'','$2a$10$FZYYDF9XACqeEh1P7xCeEO.t1S//Jc/uJpaj0di1Z/mLbvt/PlHSy','Y',NULL,NULL,NULL,'hkawsauadmin');
INSERT INTO `customer` VALUES (13,'+95','9692201153','htawmshinghkawsau@gmail.com','Hkaw Sau','Admin' ,13,0,0,0);
INSERT INTO `user_role` VALUES (19,1,13);
INSERT INTO `user_role` VALUES (20,2,13);

INSERT INTO `app_user` VALUES (14,'','$2a$10$FZYYDF9XACqeEh1P7xCeEO.t1S//Jc/uJpaj0di1Z/mLbvt/PlHSy','Y',NULL,NULL,NULL,'hkawsauuser');
INSERT INTO `customer` VALUES (14,'+95','9692201153','htawmshinghkawsau@gmail.com','Hkaw Sau','User' ,14,0,0,0);
INSERT INTO `user_role` VALUES (21,2,14);
--
INSERT INTO `app_user` VALUES (15,'','$2a$10$6W1lZNO7VfWzMivQZOg0FeCtAZmIwNPpxI6KjuH64qDC1pBdOWhWG','Y',NULL,NULL,NULL,'khinhtarooadmin');
INSERT INTO `customer` VALUES (15,'+95','9696577223','othica29@gmail.com','Khin Htar','Oo Admin' ,15,0,0,0);
INSERT INTO `user_role` VALUES (22,1,15);
INSERT INTO `user_role` VALUES (23,2,15);

INSERT INTO `app_user` VALUES (16,'','$2a$10$6W1lZNO7VfWzMivQZOg0FeCtAZmIwNPpxI6KjuH64qDC1pBdOWhWG','Y',NULL,NULL,NULL,'khinhtaroouser');
INSERT INTO `customer` VALUES (16,'+95','9696577223','othica29@gmail.com','Khin Htar','Oo User' ,16,0,0,0);
INSERT INTO `user_role` VALUES (24,2,16);
--
INSERT INTO `app_user` VALUES (17,'','$2a$10$uBTCQ6ojfle.HFuJ6RptX.amWKXNfL8l5LCWyTan1./r9LdAfdAQq','Y',NULL,NULL,NULL,'khinexinadmin');
INSERT INTO `customer` VALUES (17,'+95','9421064628','myjavaoceantest@gmail.com','Khine','Zin Admin' ,17,0,0,0);
INSERT INTO `user_role` VALUES (25,1,17);
INSERT INTO `user_role` VALUES (26,2,17);

INSERT INTO `app_user` VALUES (18,'','$2a$10$uBTCQ6ojfle.HFuJ6RptX.amWKXNfL8l5LCWyTan1./r9LdAfdAQq','Y',NULL,NULL,NULL,'khinexinuser');
INSERT INTO `customer` VALUES (18,'+95','9421064628','myjavaoceantest@gmail.com','Khine','Zin User' ,18,0,0,0);
INSERT INTO `user_role` VALUES (27,2,18);
--
