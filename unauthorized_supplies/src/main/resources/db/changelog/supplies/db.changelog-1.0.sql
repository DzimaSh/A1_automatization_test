-- changeset dzmitry.shushkevich@gmail.com:1
-- comment: Initialize database

CREATE SEQUENCE IF NOT EXISTS logins_id_seq
    INCREMENT BY 1
    START WITH 1;
CREATE TABLE logins
(
    id             BIGINT PRIMARY KEY,
    Application    VARCHAR(255) NOT NULL,
    AppAccountName VARCHAR(255) UNIQUE NOT NULL,
    IsActive       BOOLEAN      NOT NULL,
    JobTitle       VARCHAR(255),
    Department     VARCHAR(255)
);
ALTER TABLE logins ALTER id
    SET DEFAULT nextval('logins_id_seq');


CREATE SEQUENCE IF NOT EXISTS postings_id_seq
    INCREMENT BY 1
    START WITH 1;
CREATE TABLE postings
(
    id                  BIGINT PRIMARY KEY,
    MatDoc              VARCHAR(255) NOT NULL,
    Item                INT,
    DocDate             TIMESTAMP WITH TIME ZONE,
    PstngDate           TIMESTAMP WITH TIME ZONE,
    MaterialDescription VARCHAR(255),
    Quantity            INT,
    BUn                 VARCHAR(255),
    AmountLC            DECIMAL(10, 2),
    Crcy                VARCHAR(255),
    UserName            VARCHAR(255) REFERENCES logins(AppAccountName) ON DELETE SET NULL,
    Authorized          BOOLEAN
);
ALTER TABLE logins ALTER id
    SET DEFAULT nextval('postings_id_seq');
