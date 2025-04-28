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

insert into Cap_Bank values(1,'JPMorgan Chase & Co.','New York',4,'21000021','CHASUS33');
insert into Cap_Bank values(2,'Bank of America','Charlotte',5,'26009593','BOFAUS3N');
insert into Cap_Bank values(3,'Citigroup Inc.','New York',4,'21000089','CITIUS33');
insert into Cap_Bank values(4,'Wells Fargo & Co.','San Francisco',3,'121000248','WFBIUS6S');
insert into Cap_Bank values(5,'U.S. Bancorp','Minneapolis',6,'91000022','USBKUS44IMT');
insert into Cap_Bank values(6,'PNC Financial Services','Pittsburgh',9,'43000096','USBKUS44IMT');
insert into Cap_Bank values(7,'Truist Financial Corporation','Charlotte',5,'61000104','BRBTUS33');
insert into Cap_Bank values(8,'Capital One Financial Corp.','McLean',1,'51405515','HIBKUS44');
insert into Cap_Bank values(9,'Regions Financial Corp.','Birmingham',7,'62005690','UPNBUS44');
insert into Cap_Bank values(10,'KeyCorp (KeyBank)','Cleveland',8,'41001039','KEYBUS33');

CREATE TABLE CAP_INDEX (
    Index_ID int NOT NULL,
    Index_Price_USD int NOT NULL,
    Index_Price_ZAR int NOT NULL,
	Index_Unit_First_Charge int NOT NULL,
    Index_Surchage_Percentage int NOT NULL,
    Index_Surchage_Limit int NOT NULL,
    Index_Surchage_Price int NOT NULL,
    Index_Unit_Last_Price int NOT NULL,
	Index_Surchage_Final int NOT NULL,
	Index_Tourism_Token varchar(200),
    Index_Bank_ID int not null,
    PRIMARY KEY (Index_ID),
    FOREIGN KEY (Index_Bank_ID) references CAP_Bank(Bank_ID)
);

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