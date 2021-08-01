/*Clients*/
INSERT INTO clients (address,creation_date,email,last_name,name,phone,points,privilages,business_id) VALUES ('Barbosa','2021-06-11','Omitar@gmail.com','Andres','Omar','3123131321',0.0,NULL,NULL);
INSERT INTO clients (address,creation_date,email,last_name,name,phone,points,privilages,business_id) VALUES ('Barbosa','2021-05-19','Susan@gmail.com','Dayana','Susan','3123131321',0.0,NULL,NULL);
INSERT INTO clients (address,creation_date,email,last_name,name,phone,points,privilages,business_id) VALUES ('Barbosa','2021-03-29','Wisley@gmail.com','Fajardo','Wisley','3123131321',0.0,NULL,NULL);

/*Products*/
INSERT INTO products (amount,creation_date,description,name,price,business_id) VALUES (7,'2021-07-01','buenisimo','producto 1',57900,NULL);
INSERT INTO products (amount,creation_date,description,name,price,business_id) VALUES (5,'2021-07-01','mas bueno','producto 2',100000,NULL);

/*Bills*/
INSERT INTO bills (creation_date,description,observation,client_id,sell_id) VALUES ('2021-07-01','factura 1','factura 1',1,NULL);

/*Bills items*/
INSERT INTO bill_item (amount,product_id,bill_id) VALUES (3,1,1);
INSERT INTO bill_item (amount,product_id,bill_id) VALUES (5,2,1);
