CREATE TABLE IF NOT EXISTS  customer_info (
    Id   BIGINT  PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(128) ,
    risk_rating VARCHAR(128) ,
    risk_given_by VARCHAR(128)
);