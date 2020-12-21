CREATE TABLE cars(
    id BIGSERIAL NOT NULL PRIMARY KEY ,
    name_car VARCHAR (64) NOT NULL ,
    number_car VARCHAR (64) NOT NULL
);

INSERT INTO cars (name_car, number_car)
            VALUES ('Toyota','123ABS');