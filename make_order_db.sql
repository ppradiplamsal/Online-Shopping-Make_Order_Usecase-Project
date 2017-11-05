USE make_order_db;

CREATE TABLE customer_account(
Customer_id int primary key not null AUTO_INCREMENT,
ACCOUNT_ID varchar(40) unique,
`Password` varchar(40),
CardNo varchar(40),
CustEmail varchar(40)
 );
 INSERT INTO customer_account (ACCOUNT_ID,`Password`,CardNo,CustEmail)VALUES
 ("steve","2345","12345678"," steve@ttu.edu"),
 ("alex","4567","23456789"," alex@ttu.edu"),
 ("Jane","6789","45678901","jane@ttu.edu"),
 ("john","5678","56789012","john@ttu.edu"),
 ("sam","7890"," 89012345"," sam@ttu.edu");
 

 CREATE TABLE delivery_order(
 order_id int primary key not null AUTO_INCREMENT  ,
 ACCOUNT_ID varchar(40) references CUSTOMER_ACCOUNT (ACCOUNT_ID)  ,
 item varchar(40),
 Quantity varchar(255),
 TotalPrice varchar(255),
 AuthorizationNo varchar(255) unique
 );
 INSERT INTO delivery_order (ACCOUNT_ID, item, Quantity, TotalPrice, AuthorizationNo) VALUES 
 ("alex","note","3","20.00","3333"),
 ("john","book","1","50.00","5555"),
 ("sam","pencil","20","10.00","7777");
