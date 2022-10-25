drop sequence if exists trade_id_seq;
drop table if exists APP_USER;
drop table if exists TRADES;
drop table if exists REF_DATA;
create sequence TRADE_ID_SEQ CACHE 1000;

create table APP_USER (
  ID                    SERIAL,
  EMAIL                      VARCHAR(50),
  PASSWORD                   VARCHAR(500) NOT NULL,
  ENABLED                    BOOLEAN      NOT NULL DEFAULT TRUE,
  PERSONAL_DETAILS           JSON NOT NULL,
  PREFERENCES                JSON NOT NULL,
  PREFERRED_REGION           VARCHAR(20)  NOT NULL,
  CREATED_DATE               TIMESTAMP             DEFAULT NOW(),
  UPDATED_DATE               TIMESTAMP             DEFAULT NOW(),
  PRIMARY KEY (ID, PREFERRED_REGION)
);

create table TRADES (
  TRADE_ID integer NOT NULL DEFAULT NEXTVAL('TRADE_ID_SEQ'),
  USER_ID integer NOT NULL,
  SYMBOL character varying(6),
  TRADE_TYPE character varying(20),
  ORDER_TIME timestamp(0) without time zone DEFAULT now(),
  BID_PRICE double precision,
  PREFERRED_REGION           VARCHAR(20)  NOT NULL,
  CONSTRAINT TRADES_PKEY PRIMARY KEY (TRADE_ID),
  CONSTRAINT FK_APP_USER FOREIGN KEY ( USER_ID, PREFERRED_REGION ) REFERENCES APP_USER(ID, PREFERRED_REGION)
);

create table if not exists REF_DATA(
	ID                  serial,
	KEY_NAME			varchar(200),
	KEY_VALUE			json not null,
	CLASSIFIER			varchar(100) DEFAULT 'GLOBAL',
	CREATED_DATE               timestamp             default now(),
  UPDATED_DATE               timestamp             default now(),
  primary key (ID, KEY_NAME, CLASSIFIER)
);
