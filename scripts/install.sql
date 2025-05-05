use mysql;

CREATE TABLE CAP_COUNTRY (
    Country_ID int NOT NULL,
    Country_name varchar(255) NOT NULL,
    Country_code varchar(255),
    PRIMARY KEY (Country_ID)
);

insert into cap_country values (1,'United States of America', 'USD');
insert into cap_country values (2,'Republic of South Africa', 'ZAR');

CREATE TABLE CAP_STATE (
    State_ID int NOT NULL,
    State_name varchar(255) NOT NULL,
    State_code varchar(255),
    State_country_id int,
    PRIMARY KEY (State_ID),
    FOREIGN KEY (State_country_id) references CAP_Country(Country_ID)
);

insert into CAP_STATE values (1,'Virginia', 'VA',1);
insert into CAP_STATE values (2,'Nevada', 'NV',1);
insert into CAP_STATE values (3,'California', 'CA',1);
insert into CAP_STATE values (4,'New York', 'NY',1);
insert into CAP_STATE values (5,'North Carolina', 'NC',1);
insert into CAP_STATE values (6,'Minneapolis', 'MN',1);
insert into CAP_STATE values (7,'Alabama', 'AL',1);
insert into CAP_STATE values (8,'Ohio', 'OH',1);
insert into CAP_STATE values (9,'Pennsyvania', 'PA',1);

CREATE TABLE CAP_BANK (
    Bank_ID int NOT NULL,
    Bank_name varchar(255) NOT NULL,
    Bank_hq varchar(255) NOT NULL,
    Bank_State_id int,
	Bank_ABA_ROUTING varchar(200),
    Bank_Swift_Code varchar(200),
    PRIMARY KEY (Bank_ID),
    FOREIGN KEY (Bank_State_id) references CAP_STATE(State_ID)
);

insert into CAP_BANK values(1,'JPMorgan Chase & Co.','New York',4,'21000021','CHASUS33');
insert into CAP_BANK values(2,'Bank of America','Charlotte',5,'26009593','BOFAUS3N');
insert into CAP_BANK values(3,'Citigroup Inc.','New York',4,'21000089','CITIUS33');
insert into CAP_BANK values(4,'Wells Fargo & Co.','San Francisco',3,'121000248','WFBIUS6S');
insert into CAP_BANK values(5,'U.S. Bancorp','Minneapolis',6,'91000022','USBKUS44IMT');
insert into CAP_BANK values(6,'PNC Financial Services','Pittsburgh',9,'43000096','USBKUS44IMT');
insert into CAP_BANK values(7,'Truist Financial Corporation','Charlotte',5,'61000104','BRBTUS33');
insert into CAP_BANK values(8,'Capital One Financial Corp.','McLean',1,'51405515','HIBKUS44');
insert into CAP_BANK values(9,'Regions Financial Corp.','Birmingham',7,'62005690','UPNBUS44');
insert into CAP_BANK values(10,'KeyCorp (KeyBank)','Cleveland',8,'41001039','KEYBUS33');

CREATE TABLE CAP_INDEX (
    Index_ID int NOT NULL,
	Index_City_Name varchar(200) NOT NULL,
	Index_State_ID int NOT NULL,
    Index_Price_USD double NOT NULL,
    Index_Price_ZAR double NOT NULL,
	Index_Unit_First_Charge double,
    Index_Surcharge_Percentage double NOT NULL,
    Index_Surcharge_Limit double NOT NULL,
    Index_Surchage_Price double,
    Index_Unit_Last_Price double,
	Index_Surchage_Final double,
	Index_Tourism_Token varchar(200),
    Index_Bank_ID int not null,
    PRIMARY KEY (Index_ID),
    FOREIGN KEY (Index_Bank_ID) references CAP_Bank(Bank_ID),
	FOREIGN KEY (Index_State_ID) references CAP_STATE(State_ID)
);
);

insert into CAP_INDEX (INDEX_ID,INDEX_CITY_NAME,INDEX_STATE_ID,INDEX_PRICE_USD,INDEX_PRICE_ZAR,INDEX_SURCHARGE_PERCENTAGE,INDEX_SURCHARGE_LIMIT,INDEX_BANK_ID) VALUES (1,'Virginia Beach',1,5.75,106.38,20,500,2);
insert into CAP_INDEX (INDEX_ID,INDEX_CITY_NAME,INDEX_STATE_ID,INDEX_PRICE_USD,INDEX_PRICE_ZAR,INDEX_SURCHARGE_PERCENTAGE,INDEX_SURCHARGE_LIMIT,INDEX_BANK_ID) VALUES (2,'Las Vegas',2,5.40,99.90,10,500,2);
insert into CAP_INDEX (INDEX_ID,INDEX_CITY_NAME,INDEX_STATE_ID,INDEX_PRICE_USD,INDEX_PRICE_ZAR,INDEX_SURCHARGE_PERCENTAGE,INDEX_SURCHARGE_LIMIT,INDEX_BANK_ID) VALUES (3,'Minneapolis',6,5.37,99.35,10,500,3);
insert into CAP_INDEX (INDEX_ID,INDEX_CITY_NAME,INDEX_STATE_ID,INDEX_PRICE_USD,INDEX_PRICE_ZAR,INDEX_SURCHARGE_PERCENTAGE,INDEX_SURCHARGE_LIMIT,INDEX_BANK_ID) VALUES (4,'New York',4,5.31,98.24,10,500,4);


CREATE TABLE CAP_USER (
    USER_ID varchar(255) NOT NULL,
    USER_FIRST_NAME varchar(255) NOT NULL,
    USER_LAST_NAME varchar(255) NOT NULL,
    USER_CARD_NUMBER varchar(255) NOT NULL,
    USER_BANK_ID int,
    USER_LOYALTY_CREDIT double,
    PRIMARY KEY (USER_ID),
    FOREIGN KEY (USER_BANK_ID) references CAP_BANK(BANK_ID)
);

CREATE TABLE CAP_REWARD_HISTORY (
    REWARD_ID varchar(255) NOT NULL,
    REWARD_DESCRIPTION varchar(255) NOT NULL,
    REWARD_TRANSACTION_TIME timestamp,
    REWARD_USER_ID varchar(255),
    REWARD_AMOUNT double,
    REWARD_FINAL_AMOUNT double,
    REWARD_APPLIED boolean,
    REWARD_TOKEN_INDEX int,
    PRIMARY KEY (REWARD_ID),
    FOREIGN KEY (REWARD_USER_ID) references CAP_USER(USER_ID),
    FOREIGN KEY (REWARD_TOKEN_INDEX) references CAP_INDEX(Index_ID)
);

CREATE TABLE CAP_ADMIN (
    ADMIN_ID int NOT NULL,
    ADMIN_USERNAME varchar(255) NOT NULL,
    ADMIN_PASSWORD varchar(32) NOT NULL,
    ADMIN_LAST_LOGIN TIMESTAMP,
    ADMIN_CREATED_DATE TIMESTAMP,
    PRIMARY KEY (ADMIN_ID)
);

insert into CAP_ADMIN (ADMIN_ID, ADMIN_USERNAME, ADMIN_PASSWORD) VALUES (0,'admin','9695da4dd567a19f9b92065f240c6725');